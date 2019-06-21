package operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import person.*;
import accounts.Accounts;

public class AfisareTitular extends JFrame{
	public AfisareTitular(){
		super("Titular cont");
		setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

		JPanel pnl1 = new JPanel();
		JPanel pnl2 = new JPanel();
		JPanel pnl3 = new JPanel();
		JPanel pnl4 = new JPanel();

		JTextField nume = new JTextField("",15);
		JTextField prenume = new JTextField("",15);
		JTextField cnp = new JTextField("",15); 
		
		JLabel name = new JLabel("Nume:");
		JLabel fname = new JLabel("Prenume:");
		JLabel CNP = new JLabel("CNP:");

		JButton inapoi = new JButton("Inapoi");
		
		Accounts acc = Accounts.getInstance();
		Object nod = acc.getIterator();
		Current c = Current.getInstance(); //returneaza user si parola al persoanei logate in acest moment
		
		while(nod!=null){
			if(acc.search_account(c.getUser(),c.getPass())==true){
				nume.setText(acc.getNume(nod));
				prenume.setText(acc.getPrenume(nod));
				cnp.setText(acc.getCNP(nod));
				break;
			}
			else
				nod=acc.getNext(nod);
		}

		pnl1.add(name);
		pnl1.add(nume);

		pnl2.add(fname);
		pnl2.add(prenume);

		pnl3.add(CNP);
		pnl3.add(cnp);
		
		pnl4.add(inapoi);

		add(pnl1);
		add(pnl2);
		add(pnl3);
		add(pnl4);
		
		setVisible(true);
		setSize(300,300);
		setLocation(600,150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		inapoi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					dispose();
			}
		});
	}
}