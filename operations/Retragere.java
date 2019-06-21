package operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import accounts.Accounts;
import person.Current;
import exceptions.*;

public class Retragere extends JFrame{
	JTextField ret;

	public void withdraw() throws InsufficientFundsException{
		Accounts acc = Accounts.getInstance();
		Current c = Current.getInstance();

		Object tmp = acc.search_acc(c.getUser(),c.getPass());
		double suma = Double.parseDouble(ret.getText());
		if(suma>acc.getBalance(tmp)){
			throw new InsufficientFundsException("Fonduri insuficiente!");
		}
		else{
			acc.setBalance(tmp,acc.getBalance(tmp)-suma);
			JOptionPane.showMessageDialog(null,"Suma retrasa cu succes!","Succes",JOptionPane.INFORMATION_MESSAGE);
			dispose();	
		}
	}

	public Retragere(){
		super("Retragere");
		setLayout(new BorderLayout());

		JLabel retragere = new JLabel("Introduceti suma pe care doriti sa o retrageti:");

		ret = new JTextField("",15);

		JButton inapoi = new JButton("Inapoi");
		JButton retras = new JButton("Retragere");

		JPanel pnl1 = new JPanel();
		JPanel pnl2 = new JPanel();

		pnl1.add(retragere);
		pnl1.add(ret);

		pnl2.add(inapoi);
		pnl2.add(retras);

		add(pnl1,BorderLayout.CENTER);
		add(pnl2,BorderLayout.PAGE_END);

		pack();
		setVisible(true);
		setLocation(600,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	

		retras.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					withdraw();
				}catch(InsufficientFundsException ife){
					JOptionPane.showMessageDialog(null,"Fonduri insuficiente!","Eroare",JOptionPane.ERROR_MESSAGE);
					System.out.println(ife.toString());
					//ife.printStackTrace();
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