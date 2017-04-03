package com.zawadzki.model;

import com.zawadzki.classes.StudentUczelnia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;


//K-M Programs
//http://km-programs.pl/
public class MyTableModel extends AbstractTableModel{

	List<StudentUczelnia> wiersze; //lista studentow i uczelni

	

	List<String> kolumny;
	public MyTableModel(List<StudentUczelnia> wiersze) {
		this.wiersze = wiersze;
		kolumny = new ArrayList<>(Arrays.asList("ID","IMIE","NAZWISKO", "WIEK", "ADRES\nUCZELNIA", "ROK\nSTUDIOW", "STUDENT\nEMAIL",
				"TELEFON", "NAZWA", "MIEJSCOWOSC", "ROK\nZALOZENIA", "NAZWA\nREKTORA", "UCZELNIA\nEMAIL", "ADRES\nSTUDENT"));
	}
	
	public void update(List<StudentUczelnia> wiersze)
	{
		this.wiersze = wiersze;
	}
	
	@Override
	public int getColumnCount() { //trzeba zwrocic liczbe kolumn - ilosc elementow w liscie napisow od kolumn
		return kolumny.size();
	}

	@Override
	public int getRowCount() { //tyle masz wierszy ile elementow w liscie wiersze
		return wiersze.size();
	}


	@Override
	public Object getValueAt(int row, int col) {
		//na poczatek pobierasz wiersz
		StudentUczelnia su = wiersze.get(row);
		//z wiersza pobieram danae dla poszczegolych kolumn
		
		if (col == 0)
		{
			return su.getId();
		}
		else if (col == 1)
		{
			return su.getImie();
		}
		else if (col == 2)
		{
			return su.getNazwisko();
		}
		else if (col == 3)
		{
			return su.getWiek();
		}
		else if (col == 4)
		{
			return su.getAdresUczelnia();
		}
		else if (col == 5)
		{
			return su.getRokStudiow();
		}
		else if (col == 6)
		{
			return su.getStudentEmail();
		}
		else if (col == 7)
		{
			return su.getTelefon();
		}
		else if (col == 8)
		{
			return su.getNazwa();
		}
		else if (col == 9)
		{
			return su.getMiejscowosc();
		}
		else if (col == 10)
		{
			return su.getRokZalozenia();
		}
		else if (col == 11)
		{
			return su.getNazwaRektora();
		}
		else if (col == 12)
		{
			return su.getUczelniaEmail();
		}
		else
		{
			return su.getAdresStudent();
		}
	}
	

	@Override
	public String getColumnName(int column) {
		return kolumny.get(column);
	}

}
