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
public class PanelInsertStudent extends JPanel implements ActionListener{
	private JButton btnInsert;
	private JButton btnCancel;
	
	private JLabel lImie;
	private JLabel lNazwisko;
	private JLabel lWiek;
	private JLabel lAdres;
	private JLabel lRokStudiow;
	private JLabel lEmail;
	private JLabel lTelefon;
	
	private JTextField tfImie;
	private JTextField tfNazwisko;
	private JTextField tfWiek;
	private JTextField tfAdres;
	private JTextField tfRokStudiow;
	private JTextField tfEmail;
	private JTextField tfTelefon;

	private PanelStudent ps;
	
	public PanelInsertStudent(PanelStudent ps) {
		super(new BorderLayout());
		// https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html

		this.ps = ps;
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(this);
		
		btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(this);
		
		

		lImie = new JLabel("IMIE");
		lNazwisko = new JLabel("NAZWISKO");
		lWiek = new JLabel("WIEK");
		lAdres = new JLabel("ADRES");
		lRokStudiow = new JLabel("ROK STUDIOW");
		lEmail = new JLabel("EMAIL");
		lTelefon = new JLabel("TELEFON");

		tfImie = new JTextField(10);
		tfTelefon = new JTextField(10);
		tfEmail = new JTextField(10);
		tfNazwisko = new JTextField(10);
		tfAdres = new JTextField(10);
		tfRokStudiow = new JTextField(10);
		tfWiek = new JTextField(10);

		JPanel panelGora = new JPanel(new GridLayout(7, 2, 5, 5));
		JPanel panelDol = new JPanel(new GridLayout(1, 2, 5, 5));

		// wprwadzamy obramowania
		panelGora.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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

		panelDol.add(btnInsert);
		panelDol.add(btnCancel);
		panelDol.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		add(panelGora, BorderLayout.PAGE_START);
		
		add(panelDol, BorderLayout.PAGE_END);
		
		
		
		
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnInsert == e.getSource())
		{

			/*
			if (!tfImie.getText().matches("[A-Z|a-z|\\s]+"))
			{
				JOptionPane.showMessageDialog(null, "NIEPRAWIDLOWA ZAWARTOSC POLA IMIE");
				return; //przerywam wykonywanie funkcji obslugujacej wcisniecie przycisku bo mam nieprawidlowa wartosc pola imie
			}
			*/
			String imie = tfImie.getText();
			
			/*
			if(!tfNazwisko.getText().matches("[A-Z]|a-z|\\s]+"))
			{
				JOptionPane.showMessageDialog(null, "NIEPRAWIDLOWA ZAWARTOSC POLA NAZWISKO");
				return;
			}
			*/
			String nazwisko = tfNazwisko.getText();
			
			/*
			if(!tfWiek.getText().matches("\\d{2}") || Integer.parseInt(tfWiek.getText()) < 18 || Integer.parseInt(tfWiek.getText()) > 45)
			{
				JOptionPane.showMessageDialog(null, "NIEPRAWIDLOWA ZAWARTOSC POLA WIEK");
				return;
			}
			*/
			int wiek = Integer.parseInt(tfWiek.getText());
			
			/*
			if(!tfRokStudiow.getText().matches("[1-5]"))
			{
				JOptionPane.showMessageDialog(null, "NIEPRAWIDLOWA WARTOSC W POLU ROK STUDIOW");
				return;
			}
			*/
			int rokStudiow = Integer.parseInt(tfRokStudiow.getText());
			
			//ul. Cicha xxx Krakow //tutaj nie wiem czy sam Krakow czy inne miasta tez
			//if(!tfAdres.getText().matches("ul\\.\\s[A-Z]{3,40}\\s\\d{3}\\s[A-Z]+[A-Za-z]{30}"))
			/*
			if(!tfAdres.getText().matches("ul\\.\\s[A-Z]{3,40}\\s[1-9]\\d{0,2}\\s(Krakow)"))
			{
				JOptionPane.showMessageDialog(null, "NIEPRAWIDLOWA WARTOSC W POLU ADRES");
				return;
			}
			*/
			String adres = tfAdres.getText();
			
			//+48 765 676 777 //nie wiem czy + dobrze
			//"\\+d{2}\\s(\\d{3}\\)-\\d{3}-\\d{3}"
			/*
			if(!tfTelefon.getText().matches("\\+\\d{2}(\\s\\d{3}){3}"))
			{
				JOptionPane.showMessageDialog(null, "NIEPRAWIDLOWA WARTOSC W POLU NUMER TELEFONU");
				return;
			}
			*/
			String telefon = tfTelefon.getText();
			
			
			//a.nowak@uczelnia.pl // jak zrobic zeby drugi czlon maila musial byc nazwiskiem studenta
			String reg = tfImie.getText().charAt(0) + "\\." + tfNazwisko.getText() + "@uczelnia.pl";
			/*
			if(!tfEmail.getText().matches(reg))
			{
				JOptionPane.showMessageDialog(null, "NIEPRAWIDLOWA WARTOSC W POLU MAIL");
				return;
			}
			*/
			String email = tfEmail.getText();
			
			//na podstawie pol wstawiam dane do bazy danych
			Database.insertStudent(new Student(0, imie, nazwisko, wiek, adres, rokStudiow, email, telefon));
			//musze jeszcze zaktualizowac panel glowny w ktorym sie wszystko wyswietla
			ps.refreshAfterInsert();
			
			//jak zamknac okno? trzeba odwolac sie do JFrame w ktorym jest odpalony Twoj panel
			JFrame currentFrame = (JFrame)(getRootPane().getParent());
			currentFrame.dispose();
		}
		else if (btnCancel == e.getSource())
		{
			JFrame currentFrame = (JFrame)(getRootPane().getParent());
			currentFrame.dispose();
		}
		
	}
}
