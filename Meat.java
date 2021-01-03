/**
 * Below is the meat class for the pizza.
 * 
 * @author Deepali Juneja
 * @version 1 June 2020
 */
public class Meat extends Ingredient{

    /**
     * Below is the superclass constructor.
     * @param newCost meat cost
     * @param newCal  calories in meat
     * @param newDesc meat description
     * @throws PizzaException
     */
    public Meat(Money newCost, int newCal, String newDesc) throws PizzaException {
        super(newCost, newCal, newDesc);
    }

    
}