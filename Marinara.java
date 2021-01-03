/**
 * Marinara is one of the base sauces for our pizza.
 * 
 * @author Deepali Juneja
 * @version 31 May 2020
 */
public class Marinara extends Base {

    private final static Money newCost = new Money(1, 40); //cost
    private final static int newCal = 34;// this gives the number of calories in the marinara sauce
    private final static String newDesc = "Our freshly made marinara sauce is made fresh in house from San Marzano tomatoes!";// a short description of the sauce

    /**
     * Below is the base constructor. 
     * @throws PizzaException
     */
    public Marinara() throws PizzaException {
        super(newCost, newCal, newDesc);
    }

}