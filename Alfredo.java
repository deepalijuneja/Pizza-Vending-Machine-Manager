/**
 * Alfredo is one of the base sauces for our pizza.
 * 
 * @author Deepali Juneja
 * @version 31 May 2020
 */
public class Alfredo extends Base {
    private final static Money newCost = new Money(5);// cost of the sauce
    private final static int newCal = 230;//this gives the number of calories in the alfredo sauce
    private final static String newDesc = "Our white alfredo sauce is freshly made with best quality milk, butter, and parmesan cheese!";//a short description of the sauce

    /**
     * Below is the base constructor. 
     * @throws PizzaException
     */
    public Alfredo() throws PizzaException {
        super(newCost, newCal, newDesc);
    }

}