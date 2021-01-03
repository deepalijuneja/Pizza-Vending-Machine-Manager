/**
 * Below is the pepperoni topping subclass under meat subclass.
 * 
 * @author Deepali Juneja
 * @version 2 June 2020
 */
public class Pepperoni extends Meat {
    private final static Money newCost = new Money(4, 30); //cost of the pepperoni topping
    private final static int newCal = 200;// this gives the number of calories in the pepperoni topping
    private final static String newDesc = "The favorite topping of all meat lovers-pepperoni is made from pork or beef.";// a short description of the peperroni topping

     /**
     * Below is a constructor that calls the constructor of the superclass.
     * @throws PizzaException
     */
    public Pepperoni() throws PizzaException {
        super(newCost, newCal, newDesc);
    }
}