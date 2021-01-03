/**
 * Below class is from a previous hw class-Linkedlist exception but has been modified for this project.
 * 
 * @author Deepali Juneja
 * @version 3 June 2020
 */
public class PizzaException extends Exception{

    private static final long serialVersionUID = 1L;

    /**
     * Below is the first, empty constructor.
     */
    public PizzaException() {
        super("Uh-oh! There is a problem!");
    }

    /**
     * Below is the final constructor. The person using the machine gets to pick it.
     * @param message
     */
    public PizzaException(String message){
        super(message);
    }
}