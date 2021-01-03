/**
 * Below is the mozarella subclass that comes under cheese which is in turn a subclass of ingredient class.
 * 
 * @author Deepali Juneja
 * @version 1 June 2020
 */
public class Mozzarella extends Cheese {
     private final static Money newCost = new Money(2); //cost of the mozarella cheese
    private final static int newCal = 80;// this gives the number of calories in mozarella cheese
    private final static String newDesc = "Our mozarella cheese comes with local and best quality milk."; // a short description of the cheese

    /**
     *
     * Below is a constructor that calls the constructor of the superclass.
     * @throws PizzaException
     */
     public Mozzarella() throws PizzaException {
        super(newCost, newCal, newDesc);
    }

}