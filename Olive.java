import java.awt.Color;

/**
 * Below is the pepper topping subclass under vegetable subclass.
 * 
 * @author Deepali Juneja
 * @version 2 June 2020
 */
public class Olive extends Vegetable {
    private final static Money newCost = new Money(2); //cost of the olive topping
    private final static int newCal = 8;// this gives the number of calories in olive topping
    private final static String newDesc = "Olives go great with all the pizza toppings!";// a short description of the olive topping
    private final static Color newCol = Color.black;// color of the olive topping

   /**
     * Below is a constructor that calls the constructor of the superclass.
     * @throws PizzaException
     */
    public Olive() throws PizzaException {
        super(newCost, newCal, newDesc, newCol);
    }

}