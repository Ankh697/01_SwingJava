package com.zawadzki.panels;

import com.zawadzki.classes.Student;
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
public class PanelUpdateStudent extends JPanel implements ActionListener {
	private JButton btnUpdate;
	private JButton btnCancel;

	private JLabel lId;
	private JLabel lImie;
	private JLabel lNazwisko;
	private JLabel lWiek;
	private JLabel lAdres;
	private JLabel lRokStudiow;
	private JLabel lEmail;
	private JLabel lTelefon;

	private JTextField tfId;
	private JTextField tfImie;
	private JTextField tfNazwisko;
	private JTextField tfWiek;
	private JTextField tfAdres;
	private JTextField tfRokStudiow;
	private JTextField tfEmail;
	private JTextField tfTelefon;

	private PanelStudent ps;

	public PanelUpdateStudent(PanelStudent ps, Student s) {
		super(new BorderLayout());
		// https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html

		this.ps = ps;

		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(this);

		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(this);

		lId = new JLabel("Id");
		lImie = new JLabel("IMIE");
		lNazwisko = new JLabel("NAZWISKO");
		lWiek = new JLabel("WIEK");
		lAdres = new JLabel("ADRES");
		lRokStudiow = new JLabel("ROK STUDIOW");
		lEmail = new JLabel("EMAIL");
		lTelefon = new JLabel("TELEFON");

		tfId = new JTextField(10);
		tfId.setText(s.getId() + "");
		tfId.setEnabled(false);

		tfImie = new JTextField(10);
		tfImie.setText(s.getImie());

		tfTelefon = new JTextField(10);
		tfTelefon.setText(s.getTelefon());

		tfEmail = new JTextField(10);
		tfEmail.setText(s.getEmail());

		tfNazwisko = new JTextField(10);
		tfNazwisko.setText(s.getNazwisko());
		
		tfAdres = new JTextField(10);
		tfAdres.setText(s.getAdres());
		
		tfRokStudiow = new JTextField(10);
		tfRokStudiow.setText(s.getRokStudiow() + "");
		
		tfWiek = new JTextField(10);
		tfWiek.setText(s.getWiek() + "");
		JPanel panelGora = new JPanel(new GridLayout(8, 2, 5, 5));
		JPanel panelDol = new JPanel(new GridLayout(1, 2, 5, 5));

		// wprwadzamy obramowania
		panelGora.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panelGora.add(lId);
		panelGora.add(tfId);
		panelGora.add(lImie);
		panelGora.add(tfImie);
		panelGora.add(lNazwisko);
		panelGora.add(tfNazwisko);
		panelGora.add(lWiek);
		panelGora.add(tfWiek);
		panelGora.add(lRokStudiow);
		panelGora.add(tfRokStudiow);
		panelGora.add(lAdres);
		panelGora.add(tfAdres);
		panelGora.add(lEmail);
		panelGora.add(tfEmail);
		panelGora.add(lTelefon);
		panelGora.add(tfTelefon);
		panelGora.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true),
				"STUDENT", TitledBorder.CENTER, // wyrownanie tytulu ramki do
												// srodka
				TitledBorder.DEFAULT_POSITION, // tytul na gorze na srodku ramki
				new Font("Courier New", Font.BOLD, 20), // czcionka tytulu
				Color.RED // czerwony kolor ramki
		));

		panelDol.add(btnUpdate);
		panelDol.add(btnCancel);
		panelDol.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		add(panelGora, BorderLayout.PAGE_START);

		add(panelDol, BorderLayout.PAGE_END);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnUpdate == e.getSource()) {
			
			//walidacja
			int id = Integer.parseInt(tfId.getText());
			
			// nalezy pobrac wszystkie dane z pol tekstowych
			/*
			 * if (!tfImie.getText().matches("[A-Z|a-z|\\s]+")) {
			 * JOptionPane.showMessageDialog(null,
			 * "NIEPRAWIDLOWA ZAWARTOSC POLA IMIE"); return;
			 */
			String imie = tfImie.getText();

			/*
			 * if(!tfNazwisko.getText().matches("[A-Z]|a-z|\\s]+")) {
			 * JOptionPane.showMessageDialog(null,
			 * "NIEPRAWIDLOWA ZAWARTOSC POLA NAZWISKO"); return; }
			 */
			String nazwisko = tfNazwisko.getText();

			/*
			 * if(!tfWiek.getText().matches("\\d{2}") ||
			 * Integer.parseInt(tfWiek.getText()) < 18 ||
			 * Integer.parseInt(tfWiek.getText()) > 45) {
			 * JOptionPane.showMessageDialog(null,
			 * "NIEPRAWIDLOWA ZAWARTOSC POLA WIEK"); return; }
			 */
			int wiek = Integer.parseInt(tfWiek.getText());

			/*
			 * if(!tfRokStudiow.getText().matches("[1-5]")) {
			 * JOptionPane.showMessageDialog(null,
			 * "NIEPRAWIDLOWA WARTOSC W POLU ROK STUDIOW"); return; }
			 */
			int rokStudiow = Integer.parseInt(tfRokStudiow.getText());

			// ul. Cicha xxx Krakow //tutaj nie wiem czy sam Krakow czy inne
			// miasta tez
			// if(!tfAdres.getText().matches("ul\\.\\s[A-Z]{3,40}\\s\\d{3}\\s[A-Z]+[A-Za-z]{30}"))
			/*
			 * if(!tfAdres.getText().matches(
			 * "ul\\.\\s[A-Z]{3,40}\\s[1-9]\\d{0,2}\\s(Krakow)")) {
			 * JOptionPane.showMessageDialog(null,
			 * "NIEPRAWIDLOWA WARTOSC W POLU ADRES"); return; }
			 */
			String adres = tfAdres.getText();

			// +48 765 676 777 //nie wiem czy + dobrze
			// "\\+d{2}\\s(\\d{3}\\)-\\d{3}-\\d{3}"
			/*
			 * if(!tfTelefon.getText().matches("\\+\\d{2}(\\s\\d{3}){3}")) {
			 * JOptionPane.showMessageDialog(null,
			 * "NIEPRAWIDLOWA WARTOSC W POLU NUMER TELEFONU"); return; }
			 */
			String telefon = tfTelefon.getText();

			// a.nowak@uczelnia.pl // jak zrobic zeby drugi czlon maila musial
			// byc nazwiskiem studenta
			String reg = tfImie.getText().charAt(0) + "\\." + tfNazwisko.getText() + "@uczelnia.pl";
			/*
			 * if(!tfEmail.getText().matches(reg)) {
			 * JOptionPane.showMessageDialog(null,
			 * "NIEPRAWIDLOWA WARTOSC W POLU MAIL"); return; }
			 */
			String email = tfEmail.getText();

			// na podstawie pol wstawiam dane do bazy danych
			Database.updateStudent(new Student(id, imie, nazwisko, wiek, adres, rokStudiow, email, telefon));
			// musze jeszcze zaktualizowac panel glowny w ktorym sie wszystko
			// wyswietla
			ps.refreshAfterUpdate();


			JFrame currentFrame = (JFrame) (getRootPane().getParent());
			currentFrame.dispose();
		} else if (btnCancel == e.getSource()) {
			JFrame currentFrame = (JFrame) (getRootPane().getParent());
			currentFrame.dispose();
		}

	}
}
