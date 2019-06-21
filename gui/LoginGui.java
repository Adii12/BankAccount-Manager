package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import accounts.Accounts;

import operations.Register;
import person.*;
import exceptions.LoginException;
import interfaces.Logare;

public class LoginGui extends JFrame implements Logare{
	JTextField id;
	JPasswordField pa;
	Accounts acc = Accounts.getInstance();

	public void login() throws LoginException{
		if(acc.search_account(id.getText(),String.valueOf(pa.getPassword()))==true){				
			Current c = Current.getInstance();
			c.setUser(id.getText());
			c.setPass(String.valueOf(pa.getPassword()));
			new MainGui();
		}
		else{
			throw new LoginException("User sau parola inexistente!");
		}
	}

	public LoginGui(){
		super("Login");
		setLayout(new BorderLayout());

		JLabel user = new JLabel("Username:");
		JLabel pass = new JLabel("Password:");

		JPanel pnl1 = new JPanel();
		JPanel pnl2 = new JPanel();
		JPanel pnl3 = new JPanel();

		id = new JTextField("Introduceti username",15);

		pa = new JPasswordField("Introduceti parola",15);
		

		JButton login = new JButton("Login");
		JButton exit = new JButton("Exit");
		JButton register = new JButton("Register");

		pnl1.add(user);
		pnl1.add(id);

		pnl2.add(pass);
		pnl2.add(pa);

		pnl3.add(login);
		pnl3.add(register);
		pnl3.add(exit);

		add(pnl1,BorderLayout.PAGE_START);
		add(pnl2,BorderLayout.CENTER);
		add(pnl3,BorderLayout.PAGE_END);

		setSize(300,150);
		setLocation(600,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					login();
				}catch(LoginException le){
					JOptionPane.showMessageDialog(null,"User sau parola inexistente. Va rugam sa va inregistrati.","Error",JOptionPane.ERROR_MESSAGE);
					System.out.println(le.toString());
				}
			}
		});

		register.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Register reg = new Register();	
			}
		});		

		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
}