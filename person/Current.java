package person;

import interfaces.GetSet;

public class Current implements GetSet, Comparable{
	
	private static Current inst=null;
	private String user;
	private String pass;

	private Current(){};

	public static Current getInstance(){
		if(inst==null){
			inst=new Current();
		}
		return inst;
	}

	
	public void setUser(String user){
		this.user=user;
	} 

	public void setPass(String pass){
		this.pass=pass;
	}

	public String getUser(){
		return user;
	}

	public String getPass(){
		return pass;
	}

	public String toString(){
		return "User:"+user+" password:"+pass;
	}

	public int compareTo(Object o){
		if(o instanceof Current){
			Current curr = (Current) o;
			if(user.compareTo(curr.user)>0)
				return 1;
			else if(user.compareTo(curr.user)<0)
				return -1;
			else
				return 0;
		}
		else
			return -1;
	}

	public boolean equals(Object o){
		if(o instanceof Current){
			Current curr = (Current) o;
			if(user.equals(curr.user)==true)
				return true;
			else
				return false;
		}
		else{
			return false;
		}
	}
}