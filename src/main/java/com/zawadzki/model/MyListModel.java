package com.zawadzki.model;

import java.util.List;

import javax.swing.AbstractListModel;
//K-M Programs
//http://km-programs.pl/
public class MyListModel extends AbstractListModel<String>{


	private List<String> items; //lista przechowuje dane ktore beda w wyswietlanie w liscie swing
	
	public MyListModel(List<String> items) {
		updateList(items);
	}
	
	public void updateList(List<String> items) {
		this.items = items;
	}
	
	@Override
	public String getElementAt(int idx) {
		return items.get(idx);
	}

	@Override
	public int getSize() {
		return items.size();
	}

}
