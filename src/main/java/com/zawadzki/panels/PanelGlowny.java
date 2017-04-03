package com.zawadzki.panels;

import com.zawadzki.database.Database;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

//K-M Programs
//http://km-programs.pl/
public class PanelGlowny extends JPanel implements ActionListener{
	private PanelStudent panelStudent;
	private PanelUczelnia panelUczelnia;
	private PanelRejestracja panelRejestracja;
	private PanelStatystyka panelStatystyka;
	private PanelTabela panelTabela;
	
	private static boolean admin;
	
	public PanelGlowny(boolean admin)
	{
		super(new CardLayout()); //cardLayout przechowuje kolejne panele jeden na drugim
		//i tylko je przelaczasz
		panelStudent = new PanelStudent();
		panelUczelnia = new PanelUczelnia();
		panelRejestracja = new PanelRejestracja();
		panelStatystyka = new PanelStatystyka();
		panelTabela = new PanelTabela();
		
		//do card layout komponenty dodajesz na zasadzie nazwa komponentu oraz etykieta
		add(panelStudent, "STUDENT");
		add(panelUczelnia, "UCZELNIA");
		add(panelRejestracja, "REJESTRACJA");
		add(panelStatystyka, "STATYSTYKA");
		
		this.admin = admin;
	}
	
	//tworzenie menu
	public JMenuBar createMenu()
	{
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuPanele = new JMenu("PANELE");
		menuPanele.setMnemonic('P');
		
		JMenuItem itemStudent = new JMenuItem("PANEL STUDENT");
		itemStudent.addActionListener(this);
		itemStudent.setActionCommand("PANEL STUDENT");
		itemStudent.setMnemonic('S');
		itemStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		
		JMenuItem itemUczelnia = new JMenuItem("PANEL UCZELNIA");
		itemUczelnia.addActionListener(this);
		itemUczelnia.setActionCommand("PANEL UCZELNIA");
		itemUczelnia.setMnemonic('U');
		itemUczelnia.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_MASK));

		JMenuItem itemRejestracja = new JMenuItem("PANEL REJESTRACJA");
		itemRejestracja.addActionListener(this);
		itemRejestracja.setActionCommand("PANEL REJESTRACJA");
		itemRejestracja.setMnemonic('R');
		itemRejestracja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK));

		JMenuItem itemStatystyka = new JMenuItem("PANEL STATYSTYKA");
		itemStatystyka.addActionListener(this);
		itemStatystyka.setActionCommand("PANEL STATYSTYKA");
		itemStatystyka.setMnemonic('A');
		itemStatystyka.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, KeyEvent.CTRL_MASK));

		JMenuItem itemTabela = new JMenuItem("PANEL TABELA");
		itemTabela.addActionListener(this);
		itemTabela.setActionCommand("PANEL TABELA");
		itemTabela.setMnemonic('T');
		itemTabela.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_MASK));

		menuPanele.add(itemStudent);
		menuPanele.add(itemUczelnia);
		menuPanele.add(itemRejestracja);
		menuPanele.add(itemStatystyka);
		menuPanele.add(itemTabela);
		
		menuBar.add(menuPanele);
		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("PANEL STUDENT"))
		{

			CardLayout cl = (CardLayout)getLayout(); //getLayout pobiera aktualnie ustawiony w panelu layout

			cl.show(this, "STUDENT");
		}
		else if (e.getActionCommand().equals("PANEL UCZELNIA"))
		{

			CardLayout cl = (CardLayout)getLayout(); //getLayout pobiera aktualnie ustawiony w panelu layout

			cl.show(this, "UCZELNIA");
		}
		else if (e.getActionCommand().equals("PANEL REJESTRACJA"))
		{
			//najpierw aktualizuje modele comboboxow i przerysowujesz comboboxy
			panelRejestracja.getCbModelStudent().updateModel(Database.selectIdFromStudent());
			panelRejestracja.getCbModelUczelnia().updateModel(Database.selectIdFromUczelnia());
			panelRejestracja.getCbIdStudent().updateUI();
			panelRejestracja.getCbIdUczelnia().updateUI();
			

			CardLayout cl = (CardLayout)getLayout();

			cl.show(this, "REJESTRACJA");
		}
		else if(e.getActionCommand().equals("PANEL STATYSTYKA"))
		{
			panelStatystyka.odswiezCb();
			CardLayout cl = (CardLayout)getLayout();
			cl.show(this, "STATYSTYKA");
		}
		else if(e.getActionCommand().equals("PANEL TABELA"))
		{
			JFrame frame = new JFrame("TABELA");
			panelTabela.setVisible(true); //ustawiasz panel na widoczny
			frame.setContentPane(panelTabela);
			//frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(true);
			//frame.pack();
			frame.setSize(new Dimension((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 400), 400));
			frame.setLocation(100, 100);
			frame.setSize(new Dimension(
					(int)(0.8 * Toolkit.getDefaultToolkit().getScreenSize().getWidth()), 
					(int)(0.85 * Toolkit.getDefaultToolkit().getScreenSize().getHeight()))
			);
		}
	}
}
