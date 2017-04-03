package com.zawadzki.panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelKonwersjaWalut extends JPanel implements ActionListener{
	private JButton btnPLNToGBP;
	private JButton btnGBPToPLN;
	private JLabel lGBP;
	private JLabel lPLN;
	private JTextField tfGBP;
	private JTextField tfPLN;
	
	public PanelKonwersjaWalut()
	{

		super(new GridLayout(2, 3, 5, 5));
		
		btnGBPToPLN = new JButton("<<<");

		/*
		btnGBPToPLN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("GBT TO PLN");
			}
		});
		*/
		

		btnGBPToPLN.addActionListener((e) -> {
			System.out.println("LAMBDA GBP TO PLN");
			//na szybko pobierzemy sobie dane z pol tekstowych
			System.out.println(tfGBP.getText());
			System.out.println(tfPLN.getText());
			
			String x = tfPLN.getText();
			
			//w tej metodzie sprawdz czy pobrane od usera dane sa liczbami
			//czyli mja postac 3423 lub 34.45
		});
		

		btnPLNToGBP = new JButton(">>>");

		btnPLNToGBP.addActionListener(this);

		btnPLNToGBP.setActionCommand("BTN_PLN_GBP");
		
		lGBP = new JLabel("GBP");
		lPLN = new JLabel("PLN");
		
		tfGBP = new JTextField(10);
		tfPLN = new JTextField(10);
		

		add(lPLN);
		add(btnGBPToPLN);
		add(lGBP);
		add(tfPLN);
		add(btnPLNToGBP);
		add(tfGBP);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnPLNToGBP)
		{
			System.out.println("WCISNALES PLN TO GBP");
		}
		

		if(e.getActionCommand().equals("BTN_PLN_GBP"))
		{
			System.out.println("PO NAPISIE PLN TO GBP");
		}
		
	}

}
