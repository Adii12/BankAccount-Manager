package exceptions;

public class ExistingUserException extends MainException{
	public ExistingUserException(String message){
		super(message);
	}

	public String toString(){
		return super.toString();
	}
}