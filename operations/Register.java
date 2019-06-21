package operations;

import accounts.Accounts;
import person.*;
import exceptions.ExistingUserException;
import interfaces.Inregistrare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Register extends JFrame implements Inregistrare{
	JTextField user;
	JPasswordField password;
	JTextField nume;
	JTextField prenume;
	JTextField cnp;

	public void inregistrare() throws ExistingUserException{
		Accounts acc = Accounts.getInstance();

		if(acc.search_account(user.getText(),String.valueOf(password.getPassword()))==true){
			throw new ExistingUserException("User sau parola deja existente!");
		}
		else{
			acc.add_account(user.getText(),String.valueOf(password.getPassword()),nume.getText(),prenume.getText(),cnp.getText());
			JOptionPane.showMessageDialog(null,"Utilizator inregistrat cu succes!","Succes",JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
	}

	public Register(){
		super("Register");
		setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

		JPanel pnl1 = new JPanel();
		JPanel pnl2 = new JPanel();
		JPanel pnl3 = new JPanel();
		JPanel pnl4 = new JPanel();
		JPanel pnl5 = new JPanel();
		JPanel pnl6 = new JPanel();

		nume = new JTextField("Introduceti numele",15);
		prenume = new JTextField("Introduceti prenumele",15);
		cnp = new JTextField("Introduceti CNP",15);
		user = new JTextField("Introduceti username",15);
		password = new JPasswordField("Introduceti parola",15);
		

		JLabel name = new JLabel("Nume:");
		JLabel fname= new JLabel("Prenume:");
		JLabel CNP =  new JLabel("CNP:");
		JLabel us = new JLabel("Username:");
		JLabel pass = new JLabel("Password:");

		JButton register = new JButton("Register");
		JButton back = new JButton("Inapoi");

		pnl1.add(name);
		pnl1.add(nume);

		pnl2.add(fname);
		pnl2.add(prenume);
		
		pnl3.add(CNP);
		pnl3.add(cnp);

		pnl4.add(us);
		pnl4.add(user);

		pnl5.add(pass);
		pnl5.add(password);

		pnl6.add(register);
		pnl6.add(back);

		add(pnl1);
		add(pnl2);
		add(pnl3);
		add(pnl4);
		add(pnl5);
		add(pnl6);

		pack();
		setLocation(600,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					dispose();
			}
		});

		register.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					inregistrare();
				}catch(ExistingUserException eux){
					JOptionPane.showMessageDialog(null,"User sau parola deja existente!","Error",JOptionPane.ERROR_MESSAGE);
					System.out.println(eux.toString());
				}	
			}
		});
	}
}