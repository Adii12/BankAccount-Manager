package operations;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import accounts.Accounts;
import person.Current;
import exceptions.DepositException;
import interfaces.Deposit;

public class Depunere extends JFrame implements Deposit{
	JTextField dep;

	public void deposit() throws DepositException{
		Accounts acc = Accounts.getInstance();
		Current c = Current.getInstance();

		Object tmp = acc.search_acc(c.getUser(),c.getPass());
		
		if(tmp==null){
			throw new DepositException("Eroare la depunere!");
		}
		Double suma = Double.parseDouble(dep.getText());
		acc.setBalance(tmp,suma+acc.getBalance(tmp));
		JOptionPane.showMessageDialog(null,"Suma depusa cu succes!","Succes",JOptionPane.INFORMATION_MESSAGE);
		dispose();
	}

	public Depunere(){
		super("Depunere");
		setLayout(new BorderLayout());
		

		JPanel pnl1 = new JPanel();
		JPanel pnl2 = new JPanel();

		JLabel depunere = new JLabel("Introduceti suma pe care doriti sa o depuneti:");
		dep = new JTextField("",15);
		JButton depune = new JButton("Depunere");
		JButton inapoi = new JButton("Inapoi");

		pnl1.add(depunere);
		pnl1.add(dep);
		
		pnl2.add(depune);
		pnl2.add(inapoi);

		add(pnl1,BorderLayout.CENTER);
		add(pnl2,BorderLayout.PAGE_END);

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setLocation(600,300);


		depune.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					deposit();
				}catch(DepositException de){
					JOptionPane.showMessageDialog(null,"Eroare la depunere","Eroare",JOptionPane.ERROR_MESSAGE);
					System.out.println(de.toString());
				}
			}		
		});

		inapoi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					dispose();
			}
		});
	}
}