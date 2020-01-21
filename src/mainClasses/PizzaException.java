package mainClasses;

public class PizzaException extends RuntimeException {
	public PizzaException(){
	    super();
    }

    public PizzaException(String errorMessage){
	    super(errorMessage);
    }
}
