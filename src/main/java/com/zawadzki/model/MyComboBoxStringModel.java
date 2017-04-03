package com.zawadzki.model;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

//K-M Programs
//http://km-programs.pl/
public class MyComboBoxStringModel extends AbstractListModel<String> implements ComboBoxModel<String>{


	private List<String> dane;
	private String selectedItem;
	
	public MyComboBoxStringModel(List<String> dane) {
		updateModel(dane);
	}
	
	public void updateModel(List<String> dane) {
		this.dane = dane;
		if (dane != null && !dane.isEmpty())
		{
			selectedItem = dane.get(0);
		}
	}
	

	@Override
	public String getElementAt(int idx) { //pobieranie elementu na pozycji w JComboBox podanej jako argument
		return dane.get(idx);
	}

	@Override
	public int getSize() { //pobranie ile elementow masz w JComboBox
		return dane.size();
	}


	@Override
	public Object getSelectedItem() { //pobranie zaznaczonego w JComboBox elementu
		return selectedItem;
	}


	@Override
	public void setSelectedItem(Object anItem) { //zaznaczenie elementu w JComboBox
		selectedItem = (String)anItem;
	}

}
