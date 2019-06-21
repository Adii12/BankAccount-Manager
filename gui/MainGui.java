package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import operations.*;

public class MainGui extends JFrame{
	public MainGui(){
		super("ATM Menu");
		setLayout(new GridLayout(3,2,100,30));

		JButton depunere = new JButton("Depunere");
		JButton retragere = new JButton("Retragere");
		JButton modificare = new JButton("Modificare");
		JButton afisare = new JButton("Afisare titular");
		JButton interogare = new JButton("Interogare sold");
		JButton iesire = new JButton("Iesire"); 

		add(depunere);
		add(retragere);
		add(modificare);
		add(afisare);
		add(interogare);
		add(iesire);

		pack();
		//setSize(600,600);
		
		setVisible(true);
		setLocation(600,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		depunere.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					Depunere d = new Depunere();
			}
		});

		retragere.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					Retragere r = new Retragere();
			}
		});

		modificare.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					Modificare m = new Modificare();
			}
		});
		
		afisare.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					AfisareTitular af = new AfisareTitular();
			}
		});
		
		interogare.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					Interogare in = new Interogare();
			}
		});
		
			
		iesire.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					dispose();
			}
		});
	}
}