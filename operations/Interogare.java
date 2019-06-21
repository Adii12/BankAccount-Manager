 package operations;

import accounts.Accounts;
import person.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interogare extends JFrame{
	public Interogare(){
		super("Interogare sold");
		setLayout(new BorderLayout());
		
		JPanel pnl = new JPanel();
		JPanel pnl2 = new JPanel();

		Accounts acc = Accounts.getInstance();

		JLabel label = new JLabel("Sold actual:");
		JTextField txt = new JTextField("",15);

		Current c = Current.getInstance();
		

		Object tmp = acc.search_acc(c.getUser(),c.getPass());
		
		
		String bal=String.valueOf(acc.getBalance(tmp));
		txt.setText(bal);	
			
		
		

		JButton back = new JButton("Inapoi");

		pnl.add(label);
		pnl.add(txt);
		pnl2.add(back);

		add(pnl,BorderLayout.CENTER);
		add(pnl2,BorderLayout.PAGE_END);

		setLocation(600,300);
		setSize(300,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					dispose();
				}
		});
	}

}
