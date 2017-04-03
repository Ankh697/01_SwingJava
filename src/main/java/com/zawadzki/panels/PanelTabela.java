package com.zawadzki.panels;

import com.zawadzki.database.Database;
import com.zawadzki.model.MyComboBoxModel;
import com.zawadzki.model.MyListModel;
import com.zawadzki.model.MyTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.ChangedCharSetException;
import javax.swing.text.TableView;
//K-M Programs
//http://km-programs.pl/
public class PanelTabela extends JPanel implements ActionListener{
	
	private MyTableModel myTableModel;
	private JTable table;
	
	private JCheckBox checkBoxImie;
	private JCheckBox checkBoxNazwisko;
	private JCheckBox checkBoxRokStudiow;
	private JCheckBox checkBoxWiek;
	private JCheckBox checkBoxMiejscowosc;
	
	private MyListModel modelListImie;
	private JList<String> listImie;
	private MyListModel modelListNazwisko;
	private JList<String> listNazwisko;
	private MyListModel modelListMiejscowosc;
	private JList<String> listMiejscowosc;
	
	private JLabel wiekOd;
	private JLabel wiekDo;
	private JLabel rokStudiowOd;
	private JLabel rokStudiowDo;
	
	
	private MyComboBoxModel modelCbWiekOd;
	private JComboBox<Integer> cbWiekOd;
	private MyComboBoxModel modelCbWiekDo;
	private JComboBox<Integer> cbWiekDo;
	private MyComboBoxModel modelCbRokStudiowOd;
	private JComboBox<Integer> cbRokStudiowOd;
	private MyComboBoxModel modelCbRokStudiowDo;
	private JComboBox<Integer> cbRokStudiowDo;
	
	private JButton btnFiltruj;
	private JButton btnReset;
	
	public PanelTabela() {
		//super(new BorderLayout());
		super(new GridBagLayout());
		GridBagConstraints gbcMain = new GridBagConstraints();
		
		myTableModel = new MyTableModel(Database.selectInnerJoinStudentUczelnia());
		table = new JTable(myTableModel); //podobnie jak przy combobox najpierw robisz model a potem go ladujesz
		table.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );

		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(0).setMinWidth(20);

		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setMinWidth(50);

		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setMinWidth(50);

		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(100);

		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setMinWidth(200);

		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setMinWidth(200);

		table.getColumnModel().getColumn(6).setPreferredWidth(200);
		table.getColumnModel().getColumn(6).setMinWidth(200);

		table.getColumnModel().getColumn(7).setPreferredWidth(200);
		table.getColumnModel().getColumn(7).setMinWidth(200);

		table.getColumnModel().getColumn(8).setPreferredWidth(200);
		table.getColumnModel().getColumn(8).setMinWidth(200);

		table.getColumnModel().getColumn(9).setPreferredWidth(200);
		table.getColumnModel().getColumn(9).setMinWidth(200);

		table.getColumnModel().getColumn(10).setPreferredWidth(200);
		table.getColumnModel().getColumn(10).setMinWidth(200);

		table.getColumnModel().getColumn(11).setPreferredWidth(200);
		table.getColumnModel().getColumn(11).setMinWidth(200);

		table.getColumnModel().getColumn(12).setPreferredWidth(200);
		table.getColumnModel().getColumn(12).setMinWidth(200);

		table.getColumnModel().getColumn(13).setPreferredWidth(200);
		table.getColumnModel().getColumn(13).setMinWidth(200);



		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Times New Roman", Font.BOLD, 16));



		for (int i = 0; i < table.getRowCount(); ++i)
		{
			table.setRowHeight(i, 30);
		}
		for (int column = 0; column < table.getColumnCount(); column++) {

			TableColumn tableColumn = table.getColumnModel().getColumn(column);
			int preferredWidth = tableColumn.getMinWidth();
			int maxWidth = tableColumn.getMaxWidth();

			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
				Component c = table.prepareRenderer(cellRenderer, row, column);
				int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
				preferredWidth = Math.max(preferredWidth, width);

				//  We've exceeded the maximum width, no need to check other rows

				if (preferredWidth >= maxWidth) {
					preferredWidth = maxWidth;
					break;
				}
			}

			tableColumn.setPreferredWidth(preferredWidth);
		}
		
		checkBoxImie = new JCheckBox("IMIE");
		checkBoxNazwisko = new JCheckBox("NAZWISKO");
		checkBoxRokStudiow = new JCheckBox("ROK STUDIOW");
		checkBoxWiek = new JCheckBox("WIEK");
		checkBoxMiejscowosc = new JCheckBox("MIEJSCOWOSC");
		
		modelListImie = new MyListModel(Database.selectImionaStudenci());
		listImie = new JList<>(modelListImie);
		listImie.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //pozwala robic wielokrotne zaznaczenia
		modelListNazwisko = new MyListModel(Database.selectNazwiskoStudentow());
		listNazwisko = new JList<>(modelListNazwisko);
		listNazwisko.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		modelListMiejscowosc = new MyListModel(Database.selectMiejscowoscUczelnia());
		listMiejscowosc = new JList<>(modelListMiejscowosc);
		listMiejscowosc.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		modelCbWiekOd = new MyComboBoxModel(Database.selectWiekStudentow());
		cbWiekOd = new JComboBox<>(modelCbWiekOd);
		cbWiekOd.addActionListener(this);
		modelCbWiekDo = new MyComboBoxModel(Database.selectWiekStudentow());
		cbWiekDo = new JComboBox<>(modelCbWiekDo);
		cbWiekDo.addActionListener(this);
		modelCbRokStudiowOd = new MyComboBoxModel(Database.selectRokStudiow());
		cbRokStudiowOd = new JComboBox<>(modelCbRokStudiowOd);
		cbRokStudiowOd.addActionListener(this);
		modelCbRokStudiowDo = new MyComboBoxModel(Database.selectRokStudiow());
		cbRokStudiowDo = new JComboBox<>(modelCbRokStudiowDo);
		cbRokStudiowDo.addActionListener(this);
		
		btnFiltruj = new JButton("FILTRUJ");
		btnFiltruj.addActionListener(this);
		btnReset = new JButton("RESET");
		btnReset.addActionListener(this);
		
		wiekOd = new JLabel("OD");
		wiekDo = new JLabel("DO");
		rokStudiowOd =  new JLabel("OD");
		rokStudiowDo = new JLabel("DO");
		
		JPanel panelFiltrowanie = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(10, 10, 10, 10);
		
		gbc.gridx = 0; //kolumna
		gbc.gridy = 0;
		panelFiltrowanie.add(checkBoxImie,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipadx = 100;
		gbc.ipady = 100;
		//gbc.weightx = 1;
		//gbc.weighty = 1;
		//gbc.fill = GridBagConstraints.BOTH;
		//listScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS)
		JScrollPane scrollPaneListImie = new JScrollPane(listImie);
		scrollPaneListImie.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelFiltrowanie.add(scrollPaneListImie,gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		panelFiltrowanie.add(checkBoxNazwisko, gbc);
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.ipadx = 100;
		gbc.ipady = 100;
		panelFiltrowanie.add(new JScrollPane(listNazwisko), gbc);
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		panelFiltrowanie.add(checkBoxMiejscowosc, gbc);
		gbc.gridx = 5;
		gbc.gridy = 0;
		gbc.ipadx = 100;
		gbc.ipady = 100;
		panelFiltrowanie.add(new JScrollPane(listMiejscowosc), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		panelFiltrowanie.add(checkBoxWiek, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panelFiltrowanie.add(wiekOd, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		panelFiltrowanie.add(cbWiekOd,gbc);
		gbc.gridx = 3;
		gbc.gridy = 1;
		panelFiltrowanie.add(wiekDo, gbc);
		gbc.gridx = 4;
		gbc.gridy = 1;
		panelFiltrowanie.add(cbWiekDo, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelFiltrowanie.add(checkBoxRokStudiow, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panelFiltrowanie.add(rokStudiowOd, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		panelFiltrowanie.add(cbRokStudiowOd, gbc);
		gbc.gridx = 3;
		gbc.gridy = 2;
		panelFiltrowanie.add(rokStudiowDo,gbc);
		gbc.gridx = 4;
		gbc.gridy = 2;
		panelFiltrowanie.add(cbRokStudiowDo, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		panelFiltrowanie.add(btnFiltruj, gbc);
		gbc.gridx = 3;
		gbc.gridy = 3;
		panelFiltrowanie.add(btnReset, gbc);
		
		panelFiltrowanie.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
		
		gbcMain.gridy = 0;
		gbcMain.gridx = 0;
		gbcMain.ipady = (int)(0.5 * Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		gbcMain.ipadx = (int)(0.7 * Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		add(new JScrollPane(table), gbcMain);
		
		gbcMain.gridy = 1;
		gbcMain.gridx = 0;
		gbcMain.ipady = 0;
		gbcMain.ipadx = 0;
		add(panelFiltrowanie, gbcMain);
		
		//add(new JScrollPane(table), BorderLayout.CENTER);
		//add(panelFiltrowanie, BorderLayout.PAGE_END);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cbWiekDo)
		{
			List<Integer> wieki = Database.selectWiekStudentowMniejszyNiz((int)cbWiekDo.getSelectedItem());
			if(wieki == null || wieki.isEmpty())
			{
				modelCbWiekOd.setSelectedItem(null);
				modelCbWiekOd.updateModel(new ArrayList<>());
			}
			else
			{
				modelCbWiekOd.updateModel(wieki);
			}
			cbWiekOd.updateUI();
		}
		else if (e.getSource() == cbWiekOd)
		{
			List<Integer> wieki = Database.selectWiekStudentowWiekszyNiz((int)cbWiekOd.getSelectedItem());
			if(wieki == null || wieki.isEmpty())
			{
				modelCbWiekDo.setSelectedItem(null);
				modelCbWiekDo.updateModel(new ArrayList<>());
			}
			else
			{
				modelCbWiekDo.updateModel(wieki);
			}
			cbWiekDo.updateUI();
		}
		else if(e.getSource() == cbRokStudiowOd) //dokonczyc dol
		{
			List<Integer> years = Database.selectRokStudiowStudentowWiekszyNiz((int)cbRokStudiowOd.getSelectedItem());
			if (years == null || years.isEmpty()){
				modelCbRokStudiowDo.setSelectedItem(null); //zeby nie mial dalej poprzedniej wartosci tylko null bo nie ma nic
				modelCbRokStudiowDo.updateModel(new ArrayList<>());
			}
			else
			{
				modelCbRokStudiowDo.updateModel(years);
			}
			cbRokStudiowDo.updateUI();
			
		}
		else if(e.getSource() == cbRokStudiowDo)
		{
			//modelCbRokStudiowOd.updateModel(Database.selectRokStudiowStudentowMniejszyNiz((int)cbRokStudiowDo.getSelectedItem()));
			//cbRokStudiowOd.updateUI();
			List<Integer> years = Database.selectRokStudiowStudentowMniejszyNiz((int)cbRokStudiowDo.getSelectedItem());
			if(years == null || years.isEmpty())
			{
				modelCbRokStudiowOd.setSelectedItem(null);
				modelCbRokStudiowOd.setSelectedItem(new ArrayList<>());
			}
			else
			{
				modelCbRokStudiowOd.updateModel(years);
			}
			cbRokStudiowOd.updateUI();
		}
		else if (e.getSource() == btnFiltruj)
		{
			
			myTableModel.update(Database.filtrujStudentUczelnia(
					checkBoxImie.isSelected(), 
					checkBoxNazwisko.isSelected(), 
					checkBoxMiejscowosc.isSelected(), 
					checkBoxWiek.isSelected(), 
					checkBoxRokStudiow.isSelected(), 
					listImie.getSelectedValuesList(),
					listNazwisko.getSelectedValuesList(), 
					listMiejscowosc.getSelectedValuesList(), 
					(Integer)cbWiekOd.getSelectedItem(), 
					(Integer)cbWiekDo.getSelectedItem(), 
					(Integer)cbRokStudiowOd.getSelectedItem(), 
					(Integer)cbRokStudiowDo.getSelectedItem()));
			table.updateUI();
			
		}
		else if (e.getSource() == btnReset)
		{
			myTableModel.update(Database.selectInnerJoinStudentUczelnia());
			table.updateUI();
		}
		
		
	}

}
