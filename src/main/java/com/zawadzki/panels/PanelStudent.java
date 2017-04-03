package com.zawadzki.panels;

import com.zawadzki.classes.Student;
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
public class PanelStudent extends JPanel implements ActionListener {
	// dodajemy podstawowe elementy

	// przyciski
	private JButton btnLewo;
	private JButton btnPrawo;
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnUpdate;

	// label
	private JLabel lImie;
	private JLabel lNazwisko;
	private JLabel lWiek;
	private JLabel lAdres;
	private JLabel lRokStudiow;
	private JLabel lEmail;
	private JLabel lTelefon;
	// pole tekstowe
	private JTextField tfImie;
	private JTextField tfNazwisko;
	private JTextField tfWiek;
	private JTextField tfAdres;
	private JTextField tfRokStudiow;
	private JTextField tfEmail;
	private JTextField tfTelefon;
	private JTextField tfId;
	
	private List<Student> studenci;
	private int idx;

	public PanelStudent() {
		super(new GridBagLayout());
		// https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html

		btnLewo = new JButton("<<<");
		btnLewo.setFont(new Font("ComicSans", Font.PLAIN, 18));
		btnLewo.addActionListener(this);
		btnPrawo = new JButton(">>>");
		btnPrawo.setFont(new Font("ComicSans", Font.PLAIN, 18));
		btnPrawo.addActionListener(this);
		btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("ComicSans", Font.PLAIN, 18));
		btnDelete.addActionListener(this);
		btnInsert = new JButton("INSERT");
		btnInsert.setFont(new Font("ComicSans", Font.PLAIN, 18));
		btnInsert.addActionListener(this);
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("ComicSans", Font.PLAIN, 18));
		btnUpdate.addActionListener(this);

		lImie = new JLabel("IMIE");
		lImie.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lNazwisko = new JLabel("NAZWISKO");
		lNazwisko.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lWiek = new JLabel("WIEK");
		lWiek.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lAdres = new JLabel("ADRES");
		lAdres.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lRokStudiow = new JLabel("ROK STUDIOW");
		lRokStudiow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lEmail = new JLabel("EMAIL");
		lEmail.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lTelefon = new JLabel("TELEFON");
		lTelefon.setFont(new Font("Times New Roman", Font.PLAIN, 22));

		tfImie = new JTextField(20);
		tfImie.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfId = new JTextField(5);
		tfTelefon = new JTextField(20);
		tfTelefon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfEmail = new JTextField(20);
		tfEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfNazwisko = new JTextField(20);
		tfNazwisko.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfAdres = new JTextField(20);
		tfAdres.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfRokStudiow = new JTextField(20);
		tfRokStudiow.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfWiek = new JTextField(20);
		tfWiek.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JPanel panelGora = new JPanel(new GridBagLayout());
		GridBagConstraints gbcGora = new GridBagConstraints();

		JPanel panelDol = new JPanel(new GridBagLayout());
		GridBagConstraints gbcDol = new GridBagConstraints();

		JPanel panelSrodek = new JPanel(new GridBagLayout());
		GridBagConstraints gbcSrodek = new GridBagConstraints();


		gbcGora.gridx = 0;
		gbcGora.gridy = 0;
		panelGora.add(btnLewo, gbcGora);

		gbcGora.gridx = 1;
		gbcGora.gridy = 0;
		panelGora.add(tfId, gbcGora);

		gbcGora.gridx = 2;
		gbcGora.gridy = 0;
		panelGora.add(btnPrawo, gbcGora);

		// wprwadzamy obramowania
		panelGora.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		gbcSrodek.gridx = 0;
		gbcSrodek.gridy = 0;
		gbcSrodek.insets = new Insets(5,5,5,5);
		panelSrodek.add(lImie, gbcSrodek);

		gbcSrodek.gridx = 1;
		gbcSrodek.gridy = 0;
		panelSrodek.add(tfImie, gbcSrodek);

		gbcSrodek.gridx = 0;
		gbcSrodek.gridy = 1;
		panelSrodek.add(lNazwisko, gbcSrodek);

		gbcSrodek.gridx = 1;
		gbcSrodek.gridy = 1;
		panelSrodek.add(tfNazwisko, gbcSrodek);

		gbcSrodek.gridx = 0;
		gbcSrodek.gridy = 2;
		panelSrodek.add(lWiek, gbcSrodek);

		gbcSrodek.gridx = 1;
		gbcSrodek.gridy = 2;
		panelSrodek.add(tfWiek, gbcSrodek);

		gbcSrodek.gridx = 0;
		gbcSrodek.gridy = 3;
		panelSrodek.add(lRokStudiow, gbcSrodek);

		gbcSrodek.gridx = 1;
		gbcSrodek.gridy = 3;
		panelSrodek.add(tfRokStudiow, gbcSrodek);

		gbcSrodek.gridx = 0;
		gbcSrodek.gridy = 4;
		panelSrodek.add(lAdres, gbcSrodek);

		gbcSrodek.gridx = 1;
		gbcSrodek.gridy = 4;
		panelSrodek.add(tfAdres, gbcSrodek);

		gbcSrodek.gridx = 0;
		gbcSrodek.gridy = 5;
		panelSrodek.add(lEmail, gbcSrodek);

		gbcSrodek.gridx = 1;
		gbcSrodek.gridy = 5;
		panelSrodek.add(tfEmail, gbcSrodek);

		gbcSrodek.gridx = 0;
		gbcSrodek.gridy = 6;
		panelSrodek.add(lTelefon, gbcSrodek);

		gbcSrodek.gridx = 1;
		gbcSrodek.gridy = 6;
		panelSrodek.add(tfTelefon, gbcSrodek);


		panelSrodek.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true),
				"STUDENT", TitledBorder.CENTER,

				TitledBorder.DEFAULT_POSITION,
				new Font("Courier New", Font.BOLD, 20),
				Color.RED
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
		
		studenci = Database.selectStudent();
		idx = 0;
		fillPola();
		
	}
	
	public void refreshAfterInsert()
	{
		studenci = Database.selectStudent();
		idx = studenci.size() - 1;
		fillPola();
	}
	
	public void refreshAfterUpdate()
	{
		studenci = Database.selectStudent();
		fillPola();
	}
	
	public void refreshAfterDelete()
	{
		if (idx > 0) {idx--;}
		studenci = Database.selectStudent();
		fillPola();
	}

	private void fillPola()
	{
		if (studenci != null && !studenci.isEmpty())
		{
			tfId.setText(String.valueOf(studenci.get(idx).getId()));
			tfAdres.setText(studenci.get(idx).getAdres());
			tfEmail.setText(studenci.get(idx).getEmail());
			tfImie.setText(studenci.get(idx).getImie());
			tfNazwisko.setText(studenci.get(idx).getNazwisko());
			tfRokStudiow.setText(String.valueOf(studenci.get(idx).getRokStudiow()));
			tfWiek.setText(String.valueOf(studenci.get(idx).getWiek()));
			tfTelefon.setText(studenci.get(idx).getTelefon());
		}
		else
		{
			tfId.setText("");
			tfAdres.setText("");
			tfEmail.setText("");
			tfImie.setText("");
			tfNazwisko.setText("");
			tfRokStudiow.setText("");
			tfWiek.setText("");
			tfTelefon.setText("");
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLewo)
		{
			idx--;
			if (idx < 0)
			{
				idx = studenci.size()-1;
			}
			fillPola();
		}
		else if (e.getSource() == btnPrawo)
		{
			idx++;
			if (idx >= studenci.size())
			{
				idx = 0;
			}
			fillPola();
		}
		else if(e.getSource()== btnInsert)
		{
			JFrame frame = new JFrame("INSERT STUDENT");

			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			PanelInsertStudent panel = new PanelInsertStudent(this);
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
			Database.deleteStudent(id);
			refreshAfterDelete();
		}
		else if(e.getSource()== btnUpdate)
		{
			Student s = new Student(
					Integer.parseInt(tfId.getText()), 
					tfImie.getText(), 
					tfNazwisko.getText(), 
					Integer.parseInt(tfId.getText()), 
					tfAdres.getText(), 
					Integer.parseInt(tfRokStudiow.getText()), 
					tfEmail.getText(), 
					tfTelefon.getText()
			);
			
			JFrame frame = new JFrame("UPDATE STUDENT");

			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			PanelUpdateStudent panel = new PanelUpdateStudent(this, s);
			panel.setVisible(true);
			frame.setContentPane(panel);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(false);
			frame.pack();
		}
		
	}
}
