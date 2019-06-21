package accounts;

public class Accounts{

	private static Accounts inst=null;

	private class Account{
		public String username;
		public String password;
		public double balance;
		public String nume;
		public String prenume;
		public String cnp;
		public Account succ;
	}

	private Accounts(){
		System.out.println("Clasa instantiata");
	}

	public static Accounts getInstance(){
		if(inst==null){
			inst=new Accounts();
		}
		return inst;
	}

	private Account LIST;

	private Account alocate_account(String user, String pass, String nume, String prenume, String cnp){
		Account acc = new Account();
		acc.username=user;
		acc.password=pass;
		acc.balance=0.0;
		acc.nume=nume;
		acc.prenume=prenume;
		acc.cnp=cnp;
		acc.succ=null;

		return acc;
	}

	public void add_account(String user, String pass, String nume, String prenume, String cnp){
		if(LIST==null){
			Account nou = alocate_account(user,pass,nume,prenume,cnp);
			if(nou==null){
				System.out.println("Eroare - memorie insuficienta!");
			}
			else{
				LIST=nou;
				nou.username=user;
				nou.password=pass;
				nou.balance=0.0;
				nou.nume=nume;
				nou.prenume=prenume;
				nou.cnp=cnp;
				nou.succ=null;
			}
		}
		else{
			Account tmp=LIST;

			while(tmp.succ!=null)
				tmp=tmp.succ;

			Account ultim=tmp;
			Account nou=alocate_account(user,pass,nume,prenume,cnp);
			ultim.succ=nou;
			nou.succ=null;

			nou.username=user;
			nou.password=pass;
			nou.balance=0.0;
			nou.nume=nume;
			nou.prenume=prenume;
			nou.cnp=cnp;
		}
	}

	public boolean search_account(String user, String pass){
		Account tmp=LIST;
		while(tmp!=null){
			if(tmp.username.equals(user) && tmp.password.equals(pass))
				return true;
			else
				tmp=tmp.succ;
		}
		return false;
	}

	public Object search_acc(String user, String pass){
		Account tmp=LIST;
		while(tmp!=null){
			if(tmp.username.equals(user) && tmp.password.equals(pass))
				return tmp;
			else
				tmp=tmp.succ;
		}
		return null;
	}

	public Object getIterator(){
		Object list=(Object)LIST;
		return list;
	}	

	
	public Object getNext(Object next){
		Account nod=(Account)next;
		nod=nod.succ;
		return (Object) nod;
	}

	public double getBalance(Object it){
		Account acc=(Account)it;
		return acc.balance;
	}

	public String getPass(Object it){
		Account acc = (Account)it;
		return acc.password;
	}

	public String getNume(Object it){
		Account acc=(Account)it;
		return acc.nume;
	}

	public String getPrenume(Object it){
		Account acc = (Account)it;
		return acc.prenume;
	}

	public String getCNP(Object it){
		Account acc = (Account)it;
		return acc.cnp;
	}

	public void setBalance(Object it, double suma){
		Account acc=(Account)it;
		acc.balance=suma;
	}

	public void setPass(Object it, String pass){
		Account acc = (Account)it;
		acc.password=pass;
	}

	public void setNume(Object it, String nume){
		Account acc = (Account)it;
		acc.nume=nume;
	}

	public void setPrenume(Object it, String prenume){
		Account acc = (Account)it;
		acc.prenume=prenume;
	}

	public void setCNP(Object it, String cnp){
		Account acc = (Account)it;
		acc.cnp=cnp;
	}
}