package com.zawadzki.panels;

import com.zawadzki.classes.Uczelnia;
import com.zawadzki.database.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

//K-M Programs
//http://km-programs.pl/
public class PanelUczelnia extends JPanel implements ActionListener {

	private JButton btnLewo;
	private JButton btnPrawo;
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnUpdate;

	private JLabel lNazwa;
	private JLabel lMiejscowosc;
	private JLabel lRokZalozenia;
	private JLabel lNazwaRektora;
	private JLabel lEmail;
	private JLabel lAdres;

	private JTextField tfNazwa;
	private JTextField tfMiejscowosc;
	private JTextField tfRokZalozenia;
	private JTextField tfNazwaRektora;
	private JTextField tfEmail;
	private JTextField tfAdres;
	private JTextField tfId;

	private List<Uczelnia> listaUczelnia;
	private int idx;

	public PanelUczelnia() {
		super(new GridBagLayout());
		btnLewo = new JButton("<<<");
		btnLewo.setFont(new Font("ComicSans", Font.PLAIN, 18));
		btnLewo.addActionListener(this);
		btnPrawo = new JButton(">>>");
		btnPrawo.setFont(new Font("ComicSans", Font.PLAIN, 18));
		btnPrawo.addActionListener(this);
		btnInsert = new JButton("INSERT");
		btnInsert.setFont(new Font("ComicSans", Font.PLAIN, 18));
		btnInsert.addActionListener(this);
		btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("ComicSans", Font.PLAIN, 18));
		btnDelete.addActionListener(this);
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("ComicSans", Font.PLAIN, 18));
		btnUpdate.addActionListener(this);

		lNazwa = new JLabel("Nazwa");
		lNazwa.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lMiejscowosc = new JLabel("Miejscowosc");
		lMiejscowosc.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lRokZalozenia = new JLabel("Rok Zalozenia");
		lRokZalozenia.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lNazwaRektora = new JLabel("Nazwa rektora");
		lNazwaRektora.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lEmail = new JLabel("Email");
		lEmail.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lAdres = new JLabel("Adres");
		lAdres.setFont(new Font("Times New Roman", Font.PLAIN, 22));

		tfNazwa = new JTextField(20);
		tfNazwa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfMiejscowosc = new JTextField(20);
		tfMiejscowosc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfRokZalozenia = new JTextField(20);
		tfRokZalozenia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfNazwaRektora = new JTextField(20);
		tfNazwaRektora.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfEmail = new JTextField(20);
		tfEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfAdres = new JTextField(20);
		tfAdres.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfId = new JTextField(5);
		tfId.setFont(new Font("Times New Roman", Font.PLAIN, 20));




		JPanel panelGora = new JPanel(new GridBagLayout());
		GridBagConstraints gbcGora = new GridBagConstraints();

		JPanel panelDol = new JPanel(new GridBagLayout());
		GridBagConstraints gbcDol = new GridBagConstraints();

		JPanel panelSrodek = new JPanel(new GridBagLayout());
		GridBagConstraints gbcSrodek = new GridBagConstraints();
		//gbc.gridx = 0; //kolumna
		//gbc.gridy = 0; //wiersz

		gbcGora.gridx = 0;
		gbcGora.gridy = 0;
		panelGora.add(btnLewo, gbcGora);
		gbcGora.gridx = 1;
		gbcGora.gridy = 0;
		panelGora.add(tfId, gbcGora);
		gbcGora.gridx = 2;
		gbcGora.gridy = 0;
		panelGora.add(btnPrawo, gbcGora);

		panelGora.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		gbcSrodek.gridx = 0;
		gbcSrodek.gridy = 0;
		panelSrodek.add(lNazwa, gbcSrodek);
		gbcSrodek.gridx = 1;
		gbcSrodek.gridy = 0;
		panelSrodek.add(tfNazwa, gbcSrodek);
		gbcSrodek.gridx = 0;
		gbcSrodek.gridy = 1;
		panelSrodek.add(lMiejscowosc, gbcSrodek);
		gbcSrodek.gridx = 1;
		gbcSrodek.gridy = 1;
		panelSrodek.add(tfMiejscowosc, gbcSrodek);
		gbcSrodek.gridx = 0;
		gbcSrodek.gridy = 2;
		panelSrodek.add(lRokZalozenia, gbcSrodek);
		gbcSrodek.gridx = 1;
		gbcSrodek.gridy = 2;
		panelSrodek.add(tfRokZalozenia, gbcSrodek);
		gbcSrodek.gridx = 0;
		gbcSrodek.gridy = 3;
		panelSrodek.add(lNazwaRektora, gbcSrodek);
		gbcSrodek.gridx = 1;
		gbcSrodek.gridy = 3;
		panelSrodek.add(tfNazwaRektora, gbcSrodek);
		gbcSrodek.gridx = 0;
		gbcSrodek.gridy = 4;
		panelSrodek.add(lEmail, gbcSrodek);
		gbcSrodek.gridx = 1;
		gbcSrodek.gridy = 4;
		panelSrodek.add(tfEmail, gbcSrodek);
		gbcSrodek.gridx = 0;
		gbcSrodek.gridy = 5;
		panelSrodek.add(lAdres, gbcSrodek);
		gbcSrodek.gridx = 1;
		gbcSrodek.gridy = 5;
		panelSrodek.add(tfAdres, gbcSrodek);






		panelSrodek.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 3, true),
				"PANEL UCZELNIA", TitledBorder.CENTER, // wyrownanie tytulu ramki do
													// srodka
				TitledBorder.DEFAULT_POSITION, // tytul na gorze na srodku ramki
				new Font("Courier New", Font.BOLD, 20), // czcionka tytulu
				Color.BLACK
		));

		gbcDol.gridx = 0;
		gbcDol.gridy = 0;
		panelDol.add(btnInsert, gbcDol);
		gbcDol.gridx = 1;
		gbcDol.gridy = 0;
		panelDol.add(btnDelete, gbcDol);
		gbcDol.gridx = 2;
		gbcDol.gridy = 0;
		panelDol.add(btnUpdate, gbcDol);
		panelDol.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		GridBagConstraints gbcMain = new GridBagConstraints();

		gbcMain.gridx = 0;
		gbcMain.gridy = 0;
		add(panelGora, gbcMain);
		gbcMain.gridx = 0;
		gbcMain.gridy = 1;
		add(panelSrodek, gbcMain);
		gbcMain.gridx = 0;
		gbcMain.gridy = 2;
		add(panelDol, gbcMain);
		
		listaUczelnia = Database.selectUczelnia();
		idx = 0;
		fillPola();
	}

	
	public void refreshAfterInsert()
	{
		listaUczelnia = Database.selectUczelnia();
		idx = listaUczelnia.size() - 1;
		fillPola();
	}
	
	public void refreshAfterUpdate()
	{
		listaUczelnia = Database.selectUczelnia();
		fillPola();
	}
	
	public void refreshAfterDelete()
	{
		if (idx > 0) {idx--;}
		listaUczelnia = Database.selectUczelnia();
		fillPola();
	}
	
	private void fillPola() {
		if (listaUczelnia != null && !listaUczelnia.isEmpty()) {
			tfId.setText(String.valueOf(listaUczelnia.get(idx).getId()));
			tfNazwa.setText(listaUczelnia.get(idx).getNazwa());
			tfMiejscowosc.setText(listaUczelnia.get(idx).getMiejscowosc());
			tfRokZalozenia.setText(String.valueOf(listaUczelnia.get(idx).getRokZalozenia()));
			tfNazwaRektora.setText(listaUczelnia.get(idx).getNazwaRektora());
			tfEmail.setText(listaUczelnia.get(idx).getEmail());
			tfAdres.setText(listaUczelnia.get(idx).getAdres());

		} 
		else
		{
			tfId.setText("");
			tfNazwa.setText("");
			tfMiejscowosc.setText("");
			tfRokZalozenia.setText("");
			tfNazwaRektora.setText("");
			tfEmail.setText("");
			tfAdres.setText("");

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLewo)
		{
			idx--;
			if (idx < 0)
			{
				idx = listaUczelnia.size()-1;
			}
			fillPola();
		}
		else if (e.getSource() == btnPrawo)
		{
			idx++;
			if (idx >= listaUczelnia.size())
			{
				idx = 0;
			}
			fillPola();
		}
		else if(e.getSource()== btnInsert)
		{
			JFrame frame = new JFrame("INSERT UCZELNIA");

			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			PanelInsertUczelnia panel = new PanelInsertUczelnia(this);
			panel.setVisible(true);
			frame.setContentPane(panel);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(false);
			frame.pack();
		}
		else if(e.getSource()== btnDelete)
		{

			int id = Integer.parseInt(tfId.getText());
			Database.deleteUczelnia(id);
			refreshAfterDelete();
		}
	/*	private int id;
		private String nazwa;
		private String miejscowosc;
		private int rokZalozenia;
		private String nazwaRektora;
		private String email;
		private String adres;*/
		
		else if(e.getSource()== btnUpdate)
		{
			//Uczelnia(int id, String miejscowosc, int rokZalozenia, String nazwaRektora, String email, String adres) 
			Uczelnia u = new Uczelnia(
					Integer.parseInt(tfId.getText()), 
					tfNazwa.getText(),  
					tfMiejscowosc.getText(), 
					Integer.parseInt(tfRokZalozenia.getText()), 
					tfNazwaRektora.getText(),
					tfEmail.getText(), 
					tfAdres.getText()
					//Integer.parseInt(tfId.getText())
			);
			
			JFrame frame = new JFrame("UPDATE UCZELNIA");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			PanelUpdateUczelnia panel = new PanelUpdateUczelnia(this, u);
			panel.setVisible(true);
			frame.setContentPane(panel);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(false);
			frame.pack();
		}

	}

}
