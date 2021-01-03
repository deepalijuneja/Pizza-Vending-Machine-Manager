import java.awt.*;

/**
 * Below is the pepper topping subclass under vegetable subclass.
 * 
 * @author Deepali Juneja
 * @version 2 June 2020
 */
public class Pepper extends Vegetable{
    private final static Money newCost = new Money(2);// cost of the pepper topping
    private final static int newCal = 10;// the gives the number of calories in the pepper topping
    private final static String newDesc = "The yellow bell paper brings out a crunchy flavor and a tropical color to the pizza";// a short description of the pepper topping
    private final static Color newCol = Color.YELLOW; // color of the pepper topping
    
    /**
     * Below is a constructor that calls the constructor of the superclass.
     * @throws PizzaException
     */
    public Pepper() throws PizzaException {
        super(newCost, newCal, newDesc, newCol);
    }
    
}