package com.zawadzki.panels;

import com.zawadzki.classes.Uczelnia;
import com.zawadzki.database.Database;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

//K-M Programs
//http://km-programs.pl/
public class PanelUpdateUczelnia extends JPanel implements ActionListener {
	
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


	
	private PanelUczelnia pu;

	public PanelUpdateUczelnia(PanelUczelnia pu, Uczelnia u) {
		super(new BorderLayout());
		// https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html

		this.pu = pu;

		

		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(this);
		
	
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(this);

		lNazwa = new JLabel("NAZWA");
		lMiejscowosc = new JLabel("MIEJSCOWOSC");
		lRokZalozenia = new JLabel("ROK ZALOZENIA");
		lNazwaRektora = new JLabel("NAZWA REKTORA");
		lEmail = new JLabel("EMAIL");
		lAdres = new JLabel("ADRES");

		

		tfId = new JTextField(10);
		tfId.setText(u.getId() + "");
		tfId.setEnabled(false);

		tfNazwa = new JTextField(10);
		tfNazwa.setText(u.getNazwa());

		tfMiejscowosc = new JTextField(10);
		tfMiejscowosc.setText(u.getMiejscowosc());

		tfRokZalozenia = new JTextField(10);
		tfRokZalozenia.setText(u.getRokZalozenia() + "");

		tfNazwaRektora = new JTextField(10);
		tfNazwaRektora.setText(u.getNazwaRektora());

		tfAdres = new JTextField(10);
		tfAdres.setText(u.getAdres());

		tfEmail = new JTextField(10);
		tfEmail.setText(u.getEmail());

		
		JPanel panelGora = new JPanel(new GridLayout(6, 2, 5, 5));
		JPanel panelDol = new JPanel(new GridLayout(1, 3, 5, 5));

		// wprwadzamy obramowania
		panelGora.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panelGora.add(lNazwa);
		panelGora.add(tfNazwa);
		panelGora.add(lMiejscowosc);
		panelGora.add(tfMiejscowosc);
		panelGora.add(lRokZalozenia);
		panelGora.add(tfRokZalozenia);
		panelGora.add(lNazwaRektora);
		panelGora.add(tfNazwaRektora);
		panelGora.add(lEmail);
		panelGora.add(tfEmail);
		panelGora.add(lAdres);
		panelGora.add(tfAdres);
	
	
		panelGora.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true),
				"STUDENT", TitledBorder.CENTER, // wyrownanie tytulu ramki do
												// srodka
				TitledBorder.DEFAULT_POSITION, // tytul na gorze na srodku ramki
				new Font("Courier New", Font.BOLD, 20), // czcionka tytulu
				Color.RED // czerwony kolor ramki
		));

		panelDol.add(btnUpdate);
		panelDol.add(btnDelete);
		panelDol.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		add(panelGora, BorderLayout.PAGE_START);

		add(panelDol, BorderLayout.PAGE_END);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnUpdate == e.getSource()) {

			// walidacja
			int id = Integer.parseInt(tfId.getText());

			// nalezy pobrac wszystkie dane z pol tekstowych
			/*
			 * if (!tfImie.getText().matches("[A-Z|a-z|\\s]+")) {
			 * JOptionPane.showMessageDialog(null,
			 * "NIEPRAWIDLOWA ZAWARTOSC POLA IMIE"); return; //przerywam
			 * wykonywanie funkcji obslugujacej wcisniecie przycisku bo mam
			 * nieprawidlowa wartosc pola imie }
			 */
			String nazwa = tfNazwa.getText();

			/*
			 * if(!tfNazwisko.getText().matches("[A-Z]|a-z|\\s]+")) {
			 * JOptionPane.showMessageDialog(null,
			 * "NIEPRAWIDLOWA ZAWARTOSC POLA NAZWISKO"); return; }
			 */
			String miejscowosc = tfMiejscowosc.getText();

			/*
			 * if(!tfWiek.getText().matches("\\d{2}") ||
			 * Integer.parseInt(tfWiek.getText()) < 18 ||
			 * Integer.parseInt(tfWiek.getText()) > 45) {
			 * JOptionPane.showMessageDialog(null,
			 * "NIEPRAWIDLOWA ZAWARTOSC POLA WIEK"); return; }
			 */
			int rokZalozenia = Integer.parseInt(tfRokZalozenia.getText());

			/*
			 * if(!tfRokStudiow.getText().matches("[1-5]")) {
			 * JOptionPane.showMessageDialog(null,
			 * "NIEPRAWIDLOWA WARTOSC W POLU ROK STUDIOW"); return; }
			 */
			String nazwaRektora = tfNazwaRektora.getText();

			// ul. Cicha xxx Krakow //tutaj nie wiem czy sam Krakow czy inne
			// miasta tez
			// if(!tfAdres.getText().matches("ul\\.\\s[A-Z]{3,40}\\s\\d{3}\\s[A-Z]+[A-Za-z]{30}"))
			/*
			 * if(!tfAdres.getText().matches(
			 * "ul\\.\\s[A-Z]{3,40}\\s[1-9]\\d{0,2}\\s(Krakow)")) {
			 * JOptionPane.showMessageDialog(null,
			 * "NIEPRAWIDLOWA WARTOSC W POLU ADRES"); return; }
			 */
			

			// +48 765 676 777 //nie wiem czy + dobrze
			// "\\+d{2}\\s(\\d{3}\\)-\\d{3}-\\d{3}"
			/*
			 * if(!tfTelefon.getText().matches("\\+\\d{2}(\\s\\d{3}){3}")) {
			 * JOptionPane.showMessageDialog(null,
			 * "NIEPRAWIDLOWA WARTOSC W POLU NUMER TELEFONU"); return; }
			 */
			String email = tfEmail.getText();
			String adres = tfAdres.getText();

			// a.nowak@uczelnia.pl // jak zrobic zeby drugi czlon maila musial
			// byc nazwiskiem studenta
			//String reg = tfImie.getText().charAt(0) + "\\." + tfNazwisko.getText() + "@uczelnia.pl";
			/*
			 * if(!tfEmail.getText().matches(reg)) {
			 * JOptionPane.showMessageDialog(null,
			 * "NIEPRAWIDLOWA WARTOSC W POLU MAIL"); return; }
			 */
			


			Database.updateUczelnia(new Uczelnia(id, nazwa, miejscowosc , rokZalozenia , nazwaRektora , email , adres));
			pu.refreshAfterUpdate();


			JFrame currentFrame = (JFrame) (getRootPane().getParent());
			currentFrame.dispose();
		} 

	}
}
