/**
 * Below class is for the pizza manarger binary search by calories method
 * 
 * @author Deepali Juneja
 * @version 4 June 2020
 */
public class BinarySearch {

    /**
     * Below is the method for Recursion
     * 
     * @param Pizzas  arraylist
     * @param calo    calories
     * @throws PizzaException
     */
    public int recSearch(ArrayList<Pizza> pizzas, int calo) throws PizzaException {
        int l = pizzas.size();
        return recSearch(pizzas, calo, 0, l);
    }

    /**
     * Below is the method for recursion search
     * 
     * @param <T>
     * @param calo    calories
     * @param left    left
     * @param right   right
     * @throws PizzaException
     * 
     */
    private <T> int recSearch(ArrayList<Pizza> pizzas, Integer calo, int left, int right) throws PizzaException {
        int output = -1;
        if (left > right) {
            throw new PizzaException();
        } else {
            int centre = (left + right) / 2;
            if (pizzas.get(centre).getCalorieCounter() == calo) {
                output = centre;
            } else if (pizzas.get(centre).getCalorieCounter() > calo) {
                output= recSearch(pizzas, calo, left, centre - 1);
            } else if (pizzas.get(centre).getCalorieCounter() < calo) {
                output = recSearch(pizzas, calo, centre + 1, right);
            } else {

            }
        }
        return output;
    }
}