/**
 * The purpose of this class is to function as the inherited base class from the pizza class.
 * 
 * @author Deepali Juneja
 * @version 31 May 2020
 */
public class Base extends Ingredient {
    
    /**
     * Below is the superclass constructor.
     *
     * @throws PizzaException
     */
    public Base(Money newCost, int newCal, String newDesc) throws PizzaException {
        super(newCost, newCal, newDesc);
    }
    
}