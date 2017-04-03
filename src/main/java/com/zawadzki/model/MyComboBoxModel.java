package com.zawadzki.model;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

//K-M Programs
//http://km-programs.pl/
public class MyComboBoxModel extends AbstractListModel<Integer> implements ComboBoxModel<Integer>{


	private List<Integer> dane;
	private Integer selectedItem;
	
	public MyComboBoxModel(List<Integer> dane) {
		updateModel(dane);
	}
	
	public void updateModel(List<Integer> dane) {
		this.dane = dane;
		if (dane != null && !dane.isEmpty())
		{
			selectedItem = dane.get(0); //pierwszy zaznaczonym elementem zostaje pierwszy element z listy
		}
	}
	

	@Override
	public Integer getElementAt(int idx) { //pobieranie elementu na pozycji w JComboBox podanej jako argument
		return dane.get(idx);
	}

	@Override
	public int getSize() { //pobranie ile elementow masz w JComboBox
		return dane.size();
	}

	//pozwala pobrac zaznaczony aktualnie w combobox element
	@Override
	public Object getSelectedItem() { //pobranie zaznaczonego w JComboBox elementu
		return selectedItem;
	}

	//ta metoda pozwala do zmiennej selectedItem zapisac to co zaznaczyles w combobox
	@Override
	public void setSelectedItem(Object anItem) { //zaznaczenie elementu w JComboBox
		selectedItem = (Integer)anItem;
	}

}
