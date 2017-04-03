package com.zawadzki.panels;

import com.zawadzki.classes.Student;
import com.zawadzki.classes.StudentUczelnia;
import com.zawadzki.classes.Uczelnia;
import com.zawadzki.classes.Wpis;
import com.zawadzki.database.Database;
import com.zawadzki.model.MyComboBoxModel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//K-M Programs
//http://km-programs.pl/
public class PanelRejestracja extends JPanel implements ActionListener {
	private JButton btnLewo;
	private JButton btnPrawo;
	private JButton btnInsert;
	private JButton btnDelete;

	private JLabel lImie;
	private JLabel lNazwisko;
	private JLabel lWiek;
	private JLabel lAdresStudenta;
	private JLabel lAdresUczelni;
	private JLabel lRokStudiow;
	private JLabel lEmailUczelni;
	private JLabel lEmailStudenta;
	private JLabel lTelefon;
	private JLabel lMiejscowosc;
	private JLabel lRokZalozenia;
	private JLabel lNazwaRektora;
	private JLabel lNazwa;

	
	private JLabel lImie2;
	private JLabel lNazwisko2;
	private JLabel lWiek2;
	private JLabel lAdresStudenta2;
	private JLabel lAdresUczelni2;
	private JLabel lRokStudiow2;
	private JLabel lEmailUczelni2;
	private JLabel lEmailStudenta2;
	private JLabel lTelefon2;
	private JLabel lMiejscowosc2;
	private JLabel lRokZalozenia2;
	private JLabel lNazwaRektora2;
	private JLabel lNazwa2;
	
	private JTextField tfImie;
	private JTextField tfNazwisko;
	private JTextField tfWiek;
	private JTextField tfAdresUczelni;
	private JTextField tfAdresStudenta;
	private JTextField tfRokStudiow;
	private JTextField tfEmailStudenta;
	private JTextField tfEmailUczelni;
	private JTextField tfTelefon;
	private JTextField tfId;
	private JTextField tfMiejscowosc;
	private JTextField tfRokZalozenia;
	private JTextField tfNazwaRektora;
	private JTextField tfNazwa;
	
	private JTextField tfImie2;
	private JTextField tfNazwisko2;
	private JTextField tfWiek2;
	private JTextField tfAdresUczelni2;
	private JTextField tfAdresStudenta2;
	private JTextField tfRokStudiow2;
	private JTextField tfEmailStudenta2;
	private JTextField tfEmailUczelni2;
	private JTextField tfTelefon2;
	private JTextField tfMiejscowosc2;
	private JTextField tfRokZalozenia2;
	private JTextField tfNazwaRektora2;
	private JTextField tfNazwa2;
	
	private JLabel lIdStudent;
	private MyComboBoxModel cbModelStudent;
	private JComboBox<Integer> cbIdStudent;
	private JLabel lIdUczelnia;
	private MyComboBoxModel cbModelUczelnia;
	private JComboBox<Integer> cbIdUczelnia;
	
	private List<StudentUczelnia> lista;
	private int idx;

	
	public MyComboBoxModel getCbModelStudent() {
		return cbModelStudent;
	}

	public JComboBox<Integer> getCbIdStudent() {
		return cbIdStudent;
	}

	public MyComboBoxModel getCbModelUczelnia() {
		return cbModelUczelnia;
	}

	public JComboBox<Integer> getCbIdUczelnia() {
		return cbIdUczelnia;
	}

	public PanelRejestracja() {
		
		super(new GridLayout(2, 1, 5, 5)); //grid bag layout
		
		btnLewo = new JButton("<<<");
		btnLewo.addActionListener(this);
		btnPrawo = new JButton(">>>");
		btnPrawo.addActionListener(this);
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(this);
		btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(this);

		lImie = new JLabel("IMIE");
		lNazwisko = new JLabel("NAZWISKO");
		lWiek = new JLabel("WIEK");
		lAdresStudenta = new JLabel("ADRES STUDENTA");
		lAdresUczelni = new JLabel("ADRES UCZELNI");
		lRokStudiow = new JLabel("ROK STUDIOW");
		lEmailUczelni = new JLabel("EMAIL UCZELNI");
		lEmailStudenta = new JLabel("EMAIL STUDENTA");
		lTelefon = new JLabel("TELEFON");
		lMiejscowosc = new JLabel("Miejscowosc");
		lRokZalozenia = new JLabel("ROK ZALOZENIA");
		lNazwaRektora = new JLabel("Nazwa rektora");
		lNazwa = new JLabel("Nazwa");
		lIdStudent = new JLabel("Id student");
		lIdUczelnia = new JLabel("Id Uczelnia");
		
		cbModelStudent = new MyComboBoxModel(Database.selectIdFromStudent());
		cbIdStudent = new JComboBox<>(cbModelStudent);
		cbIdStudent.addActionListener(this);
		cbModelUczelnia = new MyComboBoxModel(Database.selectIdFromUczelnia());
		cbIdUczelnia = new JComboBox<>(cbModelUczelnia);
		cbIdUczelnia.addActionListener(this);
		
		lImie2 = new JLabel("IMIE");
		lNazwisko2 = new JLabel("NAZWISKO");
		lWiek2 = new JLabel("WIEK");
		lAdresStudenta2 = new JLabel("ADRES STUDENTA");
		lAdresUczelni2 = new JLabel("ADRES UCZELNI");
		lRokStudiow2 = new JLabel("ROK STUDIOW");
		lEmailUczelni2 = new JLabel("EMAIL UCZELNI");
		lEmailStudenta2 = new JLabel("EMAIL STUDENTA");
		lTelefon2 = new JLabel("TELEFON");
		lMiejscowosc2 = new JLabel("Miejscowosc");
		lRokZalozenia2 = new JLabel("ROK ZALOZENIA");
		lNazwaRektora2 = new JLabel("Nazwa rektora");
		lNazwa2 = new JLabel("Nazwa");

		tfImie = new JTextField(10);
		tfId = new JTextField(5);
		tfTelefon = new JTextField(10);
		tfEmailStudenta = new JTextField(10);
		tfEmailUczelni = new JTextField(10);
		tfNazwisko = new JTextField(10);
		tfAdresUczelni = new JTextField(10);
		tfAdresStudenta = new JTextField(10);
		tfRokStudiow = new JTextField(10);
		tfWiek = new JTextField(10);
		tfMiejscowosc = new JTextField(10);
		tfRokZalozenia = new JTextField(10);
		tfNazwaRektora = new JTextField(10);
		tfNazwa = new JTextField(10);
		
		tfImie2 = new JTextField(10);
		tfTelefon2 = new JTextField(10);
		tfEmailStudenta2 = new JTextField(10);
		tfEmailUczelni2 = new JTextField(10);
		tfNazwisko2 = new JTextField(10);
		tfAdresUczelni2 = new JTextField(10);
		tfAdresStudenta2 = new JTextField(10);
		tfRokStudiow2 = new JTextField(10);
		tfWiek2 = new JTextField(10);
		tfMiejscowosc2 = new JTextField(10);
		tfRokZalozenia2 = new JTextField(10);
		tfNazwaRektora2 = new JTextField(10);
		tfNazwa2 = new JTextField(10);

		JPanel panelGora = new JPanel(new GridLayout(1, 3, 10, 10));
		panelGora.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
		
		JPanel panelFormularzGora = new JPanel(new GridLayout(1, 2, 5, 5));
		JPanel panelStudentFormularzGora = new JPanel(new GridLayout(10,  2, 5, 5));
		JPanel panelUczelniaFormularzGora = new JPanel(new GridLayout(10,  2, 5, 5));
		JPanel panelSrodkowy = new JPanel(new FlowLayout()); //dzieki flow layout przycisk zostanie 
		//idealnie na srodku
		JPanel panelFormularzDol = new JPanel(new GridLayout(1, 2, 5, 5));
		JPanel panelStudentFormularzDol = new JPanel(new GridLayout(10,  2, 5, 5));
		JPanel panelUczelniaFormularzDol = new JPanel(new GridLayout(11,  2, 5, 5));
		JPanel panelDol = new JPanel(new FlowLayout());
		
		panelGora.add(btnLewo);
		panelGora.add(tfId);
		panelGora.add(btnPrawo);
		
		panelStudentFormularzGora.add(lImie);
		panelStudentFormularzGora.add(tfImie);
		panelUczelniaFormularzGora.add(lNazwaRektora);
		panelUczelniaFormularzGora.add(tfNazwaRektora);
		
		panelStudentFormularzGora.add(lNazwisko);
		panelStudentFormularzGora.add(tfNazwisko);
		panelUczelniaFormularzGora.add(lMiejscowosc);
		panelUczelniaFormularzGora.add(tfMiejscowosc);
		
		panelStudentFormularzGora.add(lRokStudiow);
		panelStudentFormularzGora.add(tfRokStudiow);
		panelUczelniaFormularzGora.add(lRokZalozenia);
		panelUczelniaFormularzGora.add(tfRokZalozenia);
		
		panelStudentFormularzGora.add(lWiek);
		panelStudentFormularzGora.add(tfWiek);
		panelUczelniaFormularzGora.add(lNazwa);
		panelUczelniaFormularzGora.add(tfNazwa);
		
		panelStudentFormularzGora.add(lAdresStudenta);
		panelStudentFormularzGora.add(tfAdresStudenta);
		panelUczelniaFormularzGora.add(lAdresUczelni);
		panelUczelniaFormularzGora.add(tfAdresUczelni);
		
		panelStudentFormularzGora.add(lEmailStudenta);
		panelStudentFormularzGora.add(tfEmailStudenta);
		panelUczelniaFormularzGora.add(lEmailUczelni);
		panelUczelniaFormularzGora.add(tfEmailUczelni);
		
		panelFormularzGora.add(panelStudentFormularzGora);
		panelFormularzGora.add(panelUczelniaFormularzGora);
		
		panelSrodkowy.add(btnDelete);
		
		
		panelStudentFormularzDol.add(lIdStudent);
		panelStudentFormularzDol.add(cbIdStudent);
		panelUczelniaFormularzDol.add(lIdUczelnia);
		panelUczelniaFormularzDol.add(cbIdUczelnia);
		
		panelStudentFormularzDol.add(lImie2);
		panelStudentFormularzDol.add(tfImie2);
		panelUczelniaFormularzDol.add(lNazwaRektora2);
		panelUczelniaFormularzDol.add(tfNazwaRektora2);
		
		panelStudentFormularzDol.add(lNazwisko2);
		panelStudentFormularzDol.add(tfNazwisko2);
		panelUczelniaFormularzDol.add(lMiejscowosc2);
		panelUczelniaFormularzDol.add(tfMiejscowosc2);
		
		panelStudentFormularzDol.add(lRokStudiow2);
		panelStudentFormularzDol.add(tfRokStudiow2);
		panelUczelniaFormularzDol.add(lRokZalozenia2);
		panelUczelniaFormularzDol.add(tfRokZalozenia2);
		
		panelStudentFormularzDol.add(lWiek2);
		panelStudentFormularzDol.add(tfWiek2);
		panelUczelniaFormularzDol.add(lNazwa2);
		panelUczelniaFormularzDol.add(tfNazwa2);
		
		panelStudentFormularzDol.add(lAdresStudenta2);
		panelStudentFormularzDol.add(tfAdresStudenta2);
		panelUczelniaFormularzDol.add(lAdresUczelni2);
		panelUczelniaFormularzDol.add(tfAdresUczelni2);
		
		panelStudentFormularzDol.add(lEmailStudenta2);
		panelStudentFormularzDol.add(tfEmailStudenta2);
		panelUczelniaFormularzDol.add(lEmailUczelni2);
		panelUczelniaFormularzDol.add(tfEmailUczelni2);
		
		panelFormularzDol.add(panelStudentFormularzDol);
		panelFormularzDol.add(panelUczelniaFormularzDol);
		
		panelDol.add(btnInsert);
		
		JPanel panelGlownyGorny = new JPanel(new BorderLayout()); //grid bag layout
		panelGlownyGorny.add(panelGora, BorderLayout.PAGE_START);
		panelGlownyGorny.add(panelFormularzGora, BorderLayout.CENTER);
		panelGlownyGorny.add(panelSrodkowy, BorderLayout.PAGE_END);
		
		JPanel panelGlownyDolny = new JPanel(new BorderLayout());
		panelGlownyDolny.add(panelFormularzDol, BorderLayout.CENTER);
		panelGlownyDolny.add(panelDol, BorderLayout.PAGE_END);
		
		add(panelGlownyGorny);
		add(panelGlownyDolny);
		
		lista = Database.selectInnerJoinStudentUczelnia();
		idx = 0;
		fillPola();
		
		fillStudentFromCombobox();
		fillUczelniaFromCombobox();

	}
	
	public void fillPola()
	{
		if (lista != null && !lista.isEmpty())
		{
			tfId.setText(String.valueOf(lista.get(idx).getId()));
			tfMiejscowosc.setText(lista.get(idx).getMiejscowosc());
			tfRokZalozenia.setText(String.valueOf(lista.get(idx).getRokZalozenia()));
			tfImie.setText(lista.get(idx).getNazwaRektora());
			tfNazwisko.setText(lista.get(idx).getStudentEmail());
			tfRokStudiow.setText(lista.get(idx).getAdresUczelnia());
			tfImie.setText(lista.get(idx).getImie());
			tfNazwisko.setText(lista.get(idx).getNazwisko());
			tfWiek.setText(String.valueOf(lista.get(idx).getWiek()));
			tfAdresStudenta.setText(lista.get(idx).getAdresStudent());
			tfAdresUczelni.setText(lista.get(idx).getAdresUczelnia());
			tfEmailStudenta.setText(lista.get(idx).getStudentEmail());
			tfRokStudiow.setText(String.valueOf(lista.get(idx).getRokStudiow()));
			tfTelefon.setText(lista.get(idx).getTelefon());
			tfNazwaRektora.setText(lista.get(idx).getNazwaRektora());
			tfEmailUczelni.setText(lista.get(idx).getUczelniaEmail());
			tfNazwa.setText(lista.get(idx).getNazwa());
			
		}
		else
		{
			tfId.setText("");
			tfMiejscowosc.setText("");
			tfRokZalozenia.setText("");
			tfImie.setText("");
			tfNazwisko.setText("");
			tfRokStudiow.setText("");
			tfImie.setText("");
			tfNazwisko.setText("");
			tfWiek.setText("");
			tfAdresStudenta.setText("");
			tfAdresUczelni.setText("");
			tfEmailStudenta.setText("");
			tfRokStudiow.setText("");
			tfTelefon.setText("");
			tfNazwaRektora.setText("");
			tfEmailUczelni.setText("");
		}
	}
	
	public void refreshAfterDelete()
	{
		if (idx > 0) {idx--;}
		lista = Database.selectInnerJoinStudentUczelnia();
		fillPola();
	}
	
	public void refreshAfterInsert()
	{
		lista = Database.selectInnerJoinStudentUczelnia();
		idx = lista.size()-1;
		fillPola();
	}
	
	
/*	private int id;
	private String imie;
	private String nazwisko;
	private int wiek;
	private String adres;
	private int rokStudiow;
	private String email;
	private String telefon;*/
	private void fillStudentFromCombobox()
	{
		//na poczatek nalezy zidentyfikowac ktorego studenta mamy pobrac z bazy
		int id = (Integer)cbIdStudent.getSelectedItem();
		Student s = Database.selectStudentById(id);
		System.out.println(s);
		tfImie2.setText(s.getImie());
		tfNazwisko2.setText(s.getNazwisko());
		tfRokStudiow2.setText(s.getRokStudiow() + "");
		tfWiek2.setText(s.getWiek() + "");
		tfAdresStudenta2.setText(s.getAdres());
		tfEmailStudenta2.setText(s.getEmail());
		tfTelefon2.setText(s.getTelefon());
	}
	
	
	/*private int id;
	private String nazwa;
	private String miejscowosc;
	private int rokZalozenia;
	private String nazwaRektora;
	private String email;
	private String adres;*/
	private void fillUczelniaFromCombobox()
	{
		int id = (Integer)cbIdUczelnia.getSelectedItem();
		Uczelnia u = Database.selectUczelniaById(id);
		tfNazwa2.setText(u.getNazwa());
		tfRokZalozenia2.setText(u.getRokZalozenia() + "");
		tfNazwaRektora2.setText(u.getNazwaRektora());
		tfEmailUczelni2.setText(u.getEmail());
		tfAdresUczelni2.setText(u.getAdres());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLewo)
		{
			idx--;
			if (idx < 0)
			{
				idx = lista.size()-1;
			}
			fillPola();
		}
		else if (e.getSource() == btnPrawo)
		{
			idx++;
			if (idx >= lista.size())
			{
				idx = 0;
			}
			fillPola();
		}
		else if(e.getSource()== btnDelete)
		{

			int id = Integer.parseInt(tfId.getText());

			Database.deleteWpis(id);

			refreshAfterDelete();
		}
		else if (e.getSource() == btnInsert)
		{
			int idS = (Integer)cbIdStudent.getSelectedItem();
			int idU = (Integer)cbIdUczelnia.getSelectedItem();
			Database.insertWpis(new Wpis(0,idS, idU));
			refreshAfterInsert();
			
		}
		else if(e.getSource() == cbIdStudent)
		{
			fillStudentFromCombobox();
		}
		else if (e.getSource() == cbIdUczelnia)
		{
			fillUczelniaFromCombobox();
		}
	

	}

}
