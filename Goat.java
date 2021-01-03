/**
 * This is a cheese ingredient that goes on the pizza.
 * 
 * @author Deepali Juneja
 * @version 1 June 2020
 */
public class Goat extends Cheese{

    //data members
    private final static Money newCost = new Money(2);//cost of the mozarella cheese
    private final static int newCal = 75; //this gives the number of calories in goat cheese
    private final static String newDesc = "Also called chèvre in French, our goat cheese is creamy!";// a short description of the cheese

    /**
     *
     * Below is a constructor that calls the constructor of the superclass.
     * @throws PizzaException
     */
    public Goat() throws PizzaException {
        super(newCost, newCal, newDesc);
    }

    
}