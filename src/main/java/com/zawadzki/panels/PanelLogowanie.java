package com.zawadzki.panels;

import com.zawadzki.classes.Szyfrowanie;
import com.zawadzki.database.Database;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//K-M Programs
//http://km-programs.pl/
public class PanelLogowanie extends JPanel implements ActionListener{
	private JButton btnZaloguj;
	private JButton btnAnuluj;
	private JLabel lUser;
	private JLabel lHaslo;
	private JTextField tfUser;
	private JPasswordField tfHaslo;
	

	public PanelLogowanie() {
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints(); //wspolpracuje z grid bag layoutem i pozwala konfigurowac kazdy dodawany komponent
		
		
		btnZaloguj = new JButton("ZALOGUJ");
		btnZaloguj.addActionListener(this);
		btnAnuluj = new JButton("ANULUJ");
		btnAnuluj.addActionListener(this);		
		lUser = new JLabel("LOGIN");
		lHaslo = new JLabel("HASLO");
		tfHaslo = new JPasswordField(10);
		tfUser = new JTextField(10);
		
		gbc.gridx = 0; //kolumna
		gbc.gridy = 0; //wiersz
		add(lUser,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(tfUser, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(lHaslo,gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(tfHaslo,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(btnZaloguj,gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(btnAnuluj,gbc);
		
	}
	Scanner sc = new Scanner(System.in);
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnZaloguj)
		{

			String user = tfUser.getText();
			String haslo = String.valueOf(tfHaslo.getPassword()); //pole JPasswordField zwraca haslo w postaci tablicy znakow
			
			
			if (user.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "PODAJ NAZWE UZYTKOWNIKA");
				return; 
			}
			
			
			if (haslo.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "PODAJ HASLO");
				return;
			}

			System.out.println("**************************************");
			System.out.println(Database.pobierzHaslo(user));

			String hasloZBazy = Szyfrowanie.odszyfrowanie(Database.pobierzHaslo(user));
			
			if (hasloZBazy == null)
			{
				JOptionPane.showMessageDialog(null, "NIEPRAWIDLOWA NAZWA UZYTKOWNIKA");
				return;
			}

			System.out.println("HASLO 1 : " + haslo);
			System.out.println("HASLO 2 : " + hasloZBazy);
			if (!haslo.equals(hasloZBazy))
			{
				JOptionPane.showMessageDialog(null, "NIEPRAWIDLOWE HASLO");
				return;
			}
			
			String rola = Database.pobierzRole(user);
			

			JFrame frame = new JFrame("DZIEKANAT");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			PanelGlowny panel = new PanelGlowny(rola.equals("admin"));
			panel.setVisible(true);
			frame.setContentPane(panel);
			//frame.setLocationRelativeTo(null);
			frame.setLocation(700, 200);
			frame.setJMenuBar(panel.createMenu());
			frame.setVisible(true);
			frame.setResizable(true);
			frame.pack();
			
			//po odpaleniu okienka glowengo trzeba zamknac okienko z haslem
			JFrame stareOkno = (JFrame)getRootPane().getParent();
			stareOkno.dispose();
		}
		else if (e.getSource() == btnAnuluj)
		{
			
		}
		
	}
	
}
