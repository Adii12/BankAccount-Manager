package operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import accounts.Accounts;
import person.Current;
import exceptions.NullNodeException;
import interfaces.Modify;

public class Modificare extends JFrame implements Modify{
	Accounts acc = Accounts.getInstance();
	Current c = Current.getInstance();

	JTextField name;
	JTextField fname;
	JTextField CNP;
	JPasswordField oldPass;
	JPasswordField pass;
	JPasswordField confirmPass;

	Object nod = acc.search_acc(c.getUser(),c.getPass());

	public void modify() throws NullNodeException{
		if(nod==null){  //daca nu s-a gasit nodul
			throw new NullNodeException("Eroare la modificare!");
		}
		
		else if(String.valueOf(pass.getPassword()).equals("") && String.valueOf(confirmPass.getPassword()).equals("")){ //daca campul parolei noi ramane nemodificat, se schimba doar nume,prenume cnp
			
			if(String.valueOf(oldPass.getPassword()).equals(acc.getPass(nod))){ //se schimba doar daca parola din textfield == parola actuala
				acc.setNume(nod,name.getText());
				acc.setPrenume(nod,fname.getText());
				acc.setCNP(nod,CNP.getText());
				JOptionPane.showMessageDialog(null,"Modificat cu succes!","Succes",JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null,"Parola veche incorecta!","Eroare",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else{
			if(String.valueOf(oldPass.getPassword()).equals(acc.getPass(nod))){
				acc.setNume(nod,name.getText());
				acc.setPrenume(nod,fname.getText());
				acc.setCNP(nod,CNP.getText());

				if(String.valueOf(pass.getPassword()).equals(String.valueOf(confirmPass.getPassword()))){ //daca parolele noi coincid
					acc.setPass(nod,String.valueOf(pass.getPassword()));
					JOptionPane.showMessageDialog(null,"Modificat cu succes!","Succes",JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null,"Parolele nu coincid!","Eroare",JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"Parola veche incorecta!","Eroare",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public Modificare(){
		super("Modificare");
		setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

		JPanel pnl1 = new JPanel();
		JPanel pnl2 = new JPanel();
		JPanel pnl3 = new JPanel();
		JPanel pnl4 = new JPanel();
		JPanel pnl5 = new JPanel();
		JPanel pnl6 = new JPanel();

		JLabel nume = new JLabel("Nume:");
		JLabel prenume = new JLabel("Prenume:");
		JLabel cnp = new JLabel("CNP");
		JLabel oPass = new JLabel("Parola veche:");
		JLabel parola = new JLabel("Parola:");

		name=new JTextField(acc.getNume(nod),15);
		fname=new JTextField(acc.getPrenume(nod),15);
		CNP=new JTextField(acc.getCNP(nod),15);
		oldPass = new JPasswordField("",15);
		pass=new JPasswordField("",15);
		confirmPass=new JPasswordField("",15);

		JButton modifica = new JButton("Modificare");
		JButton inapoi = new JButton("Inapoi");

		pnl1.add(nume);
		pnl1.add(name);

		pnl2.add(prenume);
		pnl2.add(fname);

		pnl3.add(cnp);
		pnl3.add(CNP);

		pnl4.add(parola);
		pnl4.add(pass);
		pnl4.add(confirmPass);

		pnl5.add(oPass);
		pnl5.add(oldPass);

		pnl6.add(inapoi);
		pnl6.add(modifica);

		add(pnl1);
		add(pnl2);
		add(pnl3);
		add(pnl4);
		add(pnl5);
		add(pnl6);

		setLocation(600,300);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		modifica.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					modify();
				}catch(NullNodeException nne){
					JOptionPane.showMessageDialog(null,"Eroare la modificare!","Eroare",JOptionPane.ERROR_MESSAGE);
					System.out.println(nne.toString());
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