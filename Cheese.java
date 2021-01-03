/**
 * Below is the cheese class for the pizza.
 * 
 * @author Deepali Juneja
 * @version 1 June 2020
 */
public class Cheese extends Ingredient {

    /**
     * Below is the superclass constuctor.
     * @param newCost  cheese cost
     * @param newCal   calories in cheese
     * @param newDesc  cheese description
     * @throws PizzaException
     */
    public Cheese(Money newCost, int newCal, String newDesc) throws PizzaException {
        super(newCost, newCal, newDesc);
    }
    
}