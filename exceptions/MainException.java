package exceptions;

public class MainException extends Exception{
	public MainException(String message){
		super(message);
	}

	public String toString(){
		return super.toString();
	}
}