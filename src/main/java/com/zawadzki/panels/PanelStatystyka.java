package com.zawadzki.panels;

import com.zawadzki.classes.Logowanie;
import com.zawadzki.classes.Statystyka;
import com.zawadzki.classes.StudentUczelnia;
import com.zawadzki.database.Database;
import com.zawadzki.model.MyComboBoxStringModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.xml.crypto.Data;

//K-M Programs
//http://km-programs.pl/
public class PanelStatystyka extends JPanel{

	private JLabel lNajstarszyStudent;
	private JLabel lNajmlodszyStudent;
	private JLabel lNajstarszaUczelnia;
	private JLabel lNajmlodszaUczelnia;
	private JLabel lSredniWiekStudentow;
	private JLabel lIloscStudentowNaPoszczegolnychLatach;
	private JLabel lIloscStudentowWPoszczegolnychWojewodztwach;
	private JLabel lRokStudiow;
	

	private JTextArea tfNajstarszyStudent;
	private JTextArea tfNajmlodszyStudent;
	private JTextArea tfNajstarszaUczelnia;
	private JTextArea tfNajmlodszaUczelnia;
	private JTextField tfSredniWiekStudentow;
	private JTextArea tfIloscStudentowNaPoszczegolnychLatach;
	private JTextArea tfIloscStudentowWPoszczegolnychWojewodztwach;
	private JTextArea tfRokStudiow;

	private JLabel lIdStudent;
	private MyComboBoxStringModel cbModeIloscStudentowNaPoszczegolnychLatachStudiow;
	private JComboBox<String> cbIloscStudentow;
	private JLabel lIdStudentWoj;
	private MyComboBoxStringModel cbModeIloscStudentowWPoszczegolnychMiejscowosciach;
	private JComboBox<String> cbIloscStudentowMiejscowosci;

	private List<Statystyka> lista;
	private int idx;



	public PanelStatystyka() {

		super(new GridBagLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

		lNajstarszyStudent = new JLabel("Najstarszy student");
		lNajstarszyStudent.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		//lNajmlodszyStudent = new JLabel("NAJMLODSZY STUDENT");
		lNajstarszaUczelnia = new JLabel("Najstarsza uczelnia");
		lNajstarszaUczelnia.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lNajmlodszaUczelnia = new JLabel("Najmlodsza uczelnia");
		lNajmlodszaUczelnia.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lNajmlodszyStudent = new JLabel("Najmlodszy student");
		lNajmlodszyStudent.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lSredniWiekStudentow = new JLabel("Sredni wiek studentow");
		lSredniWiekStudentow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		//lRokStudiow = new JLabel("ROK STUDI�W");
		lIloscStudentowNaPoszczegolnychLatach = new JLabel("Ilosc studentow na poszczegolnych latach");
		lIloscStudentowNaPoszczegolnychLatach.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lIloscStudentowWPoszczegolnychWojewodztwach = new JLabel("Ilosc studentow z poszczegolnych miejscowosci");
		lIloscStudentowWPoszczegolnychWojewodztwach.setFont(new Font("Times New Roman", Font.PLAIN, 22));

		lIdStudent = new JLabel("Id student");
		lIdStudent.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lIdStudentWoj = new JLabel("Id Wojewodztwo");
		lIdStudentWoj.setFont(new Font("Times New Roman", Font.PLAIN, 22));

		cbModeIloscStudentowNaPoszczegolnychLatachStudiow = new MyComboBoxStringModel(Database.liczbaStudentowNaPoszczegolnychLatachStudiow());
		cbIloscStudentow = new JComboBox<>(cbModeIloscStudentowNaPoszczegolnychLatachStudiow);
		cbModeIloscStudentowWPoszczegolnychMiejscowosciach = new MyComboBoxStringModel(Database.liczbaStudentowZPoszczegolnychWojewodztw());
		cbIloscStudentowMiejscowosci = new JComboBox<>(cbModeIloscStudentowWPoszczegolnychMiejscowosciach);
		//JTextArea textArea2 = new JTextArea("najmlodszy", 5, 10);



		tfNajmlodszaUczelnia = new JTextArea("", 5, 20);
		tfNajmlodszaUczelnia.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tfNajstarszyStudent = new JTextArea("", 5 , 20);
		tfNajstarszyStudent.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tfNajstarszaUczelnia = new JTextArea("", 5, 20);
		tfNajmlodszaUczelnia.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tfNajmlodszyStudent = new JTextArea("", 5, 20);
		tfNajmlodszyStudent.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tfSredniWiekStudentow = new JTextField(20);
		tfSredniWiekStudentow.setBorder(BorderFactory.createLineBorder(Color.BLACK));


		//tfIloscStudentowWPoszczegolnychWojewodztwach = new JTextArea("Ilosc studentow z poszczegolnych wojewodztw" ,5 ,10);
		//tfSredniWiekStudentow = new JTextArea("Sredni wiek studentow", 5, 10);
		//tfRokStudiow = new JTextArea("Rok Studiow" , 5, 10);


		/*tfNajmlodszaUczelnia = new JTextField(20);
		tfNajstarszyStudent = new JTextField(20);
		tfNajstarszaUczelnia = new JTextField(20);
		tfNajmlodszyStudent = new JTextField(20);
		tfIloscStudentowNaPoszczegolnychLatach = new JTextField(20);
		tfIloscStudentowWPoszczegolnychWojewodztwach = new JTextField(20);
		tfSredniWiekStudentow = new JTextField(20);
		tfRokStudiow = new JTextField(20);*/

		JPanel panelGlowny = new JPanel(new GridBagLayout());
		GridBagConstraints gbcGlowny = new GridBagConstraints();


		gbcGlowny.gridx = 0;
		gbcGlowny.gridy = 0;
		panelGlowny.add(lNajmlodszyStudent, gbcGlowny);

		gbcGlowny.gridx = 1;
		gbcGlowny.gridy = 0;
		panelGlowny.add(new JScrollPane(tfNajmlodszyStudent), gbcGlowny);

		gbcGlowny.gridx = 0;
		gbcGlowny.gridy = 1;
		panelGlowny.add(lNajstarszyStudent, gbcGlowny);

		gbcGlowny.gridx = 1;
		gbcGlowny.gridy = 1;
		panelGlowny.add(new JScrollPane(tfNajstarszyStudent), gbcGlowny);

		gbcGlowny.gridx = 0;
		gbcGlowny.gridy = 2;
		panelGlowny.add(lNajstarszaUczelnia, gbcGlowny);

		gbcGlowny.gridx = 1;
		gbcGlowny.gridy = 2;
		panelGlowny.add(new JScrollPane(tfNajstarszaUczelnia), gbcGlowny);

		gbcGlowny.gridx = 0;
		gbcGlowny.gridy = 3;
		panelGlowny.add(lNajmlodszaUczelnia, gbcGlowny);

		gbcGlowny.gridx = 1;
		gbcGlowny.gridy = 3;
		panelGlowny.add(new JScrollPane(tfNajmlodszaUczelnia), gbcGlowny);

		gbcGlowny.gridx = 0;
		gbcGlowny.gridy = 4;
		panelGlowny.add(lSredniWiekStudentow, gbcGlowny);

		gbcGlowny.gridx = 1;
		gbcGlowny.gridy = 4;
		panelGlowny.add(tfSredniWiekStudentow, gbcGlowny);

		gbcGlowny.gridx = 0;
		gbcGlowny.gridy = 5;
		panelGlowny.add(lIloscStudentowNaPoszczegolnychLatach, gbcGlowny);

		gbcGlowny.gridx = 1;
		gbcGlowny.gridy = 5;
		panelGlowny.add(cbIloscStudentow, gbcGlowny);

		gbcGlowny.gridx = 0;
		gbcGlowny.gridy = 6;
		panelGlowny.add(lIloscStudentowWPoszczegolnychWojewodztwach, gbcGlowny);

		gbcGlowny.gridx = 1;
		gbcGlowny.gridy = 6;
		panelGlowny.add(cbIloscStudentowMiejscowosci, gbcGlowny);

		panelGlowny.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 3, true),
				"Statystyka", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION,
				new Font("Courier New", Font.BOLD, 24),
				Color.BLACK // czerwony kolor ramki
		));

		GridBagConstraints gbcMain = new GridBagConstraints();
		gbcMain.gridx = 0;
		gbcMain.gridy = 0;
		add(panelGlowny, gbcMain);
		fillFields();
		

	}
	
	public void fillFields()
	{
		tfNajstarszyStudent.setText(Database.najstarszyStudent() + "");;
		tfNajmlodszyStudent.setText(Database.najmlodszyStudent() + "");
		tfNajstarszaUczelnia.setText(Database.najstarszaUczelnia().getNazwa());;
		tfNajmlodszaUczelnia.setText(Database.najmlodszaUczelnia().getNazwa());
		tfSredniWiekStudentow.setText(Database.sredniSredniWiekStudentow() + "");
		cbModeIloscStudentowNaPoszczegolnychLatachStudiow.updateModel(Database.liczbaStudentowNaPoszczegolnychLatachStudiow());
		cbIloscStudentow.updateUI();
		cbModeIloscStudentowWPoszczegolnychMiejscowosciach.updateModel(Database.liczbaStudentowZPoszczegolnychWojewodztw());
		cbIloscStudentowMiejscowosci.updateUI();
		//tfIloscStudentowNaPoszczegolnychLatach.setText(Database.liczbaStudentowNaPoszczegolnychLatachStudiow() + "");;
		//tfIloscStudentowWPoszczegolnychWojewodztwach.setText(Database.liczbaStudentowZPoszczegolnychWojewodztw() + "");
	}

	public void odswiezCb()
	{
		List<StudentUczelnia> przypisanie = Database.selectInnerJoinStudentUczelnia();
		System.out.println("+++-----------+++");
		przypisanie.forEach(s -> {
			System.out.println(s);
		});
		System.out.println("+++=========+++");
		Map<Integer, List<StudentUczelnia>> zestawienie = przypisanie.stream().collect(Collectors.groupingBy(StudentUczelnia::getRokStudiow));
		zestawienie.forEach((k,v) -> {
			System.out.println(k + " - " + v);
		});
		System.out.println("+++=========+++");
		cbModeIloscStudentowNaPoszczegolnychLatachStudiow.updateModel(Database.liczbaStudentowNaPoszczegolnychLatachStudiow());
		cbIloscStudentow.updateUI();
		cbModeIloscStudentowWPoszczegolnychMiejscowosciach.updateModel(Database.liczbaStudentowZPoszczegolnychWojewodztw());
		cbIloscStudentowMiejscowosci.updateUI();
	}



}