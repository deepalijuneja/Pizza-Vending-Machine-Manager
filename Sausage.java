/**
 * Below is the sausage topping subclass under meat subclass.
 * 
 * @author Deepali Juneja
 * @version 2 June 2020
 */
public class Sausage extends Meat {
    private final static Money newCost = new Money(2, 30);// the cost of sausage meat
    private final static int newCal = 300;// this gives the number of calories in sausage meat
    private final static String newDesc = "Another favorite of meat lovers is the sausage meat topping made from ground meat with salts and spices";// a short description of the sausage meat

    /**
     * Below is a constructor that calls the constructor of the superclass.
     * @throws PizzaException
     */
    public Sausage() throws PizzaException {
        super(newCost, newCal, newDesc);
    }
}