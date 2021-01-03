import java.awt.*;

/**
 * Below is the vegetable class for the pizza.
 * 
 * @author Deepali Juneja
 * @version 1 June 2020
 */
public class Vegetable extends Ingredient {
    private Color col;

    /**
     * Below is the first constructor of the class (here it doesn't take a vegetable color)
     */
    public Vegetable(Money newCost, int newCal, String newDesc) throws PizzaException {
        super(newCost, newCal, newDesc);
    }

    /**
     * Below is the second constructor that does take the color.
     * 
     * @param newCost vegetable cost
     * @param newCal  calories in vegetable
     * @param newDesc vegetable description
     * @param newCol  vegetable color
     * @throws PizzaException
     */
    public Vegetable(Money newCost, int newCal, String newDesc, Color newCol) throws PizzaException {
        super(newCost, newCal, newDesc);
        this.setColor(newCol);
    }

    /**
     * @return color of vegetable
     */
    public Color getColor() {
        Color valueColor = this.col;
        return valueColor;
    }

    /**
     * Below is the setter for the vegetable color.
     * 
     * @param newCol
     * @throws PizzaException
     */
    private final void setColor(Color newCol) throws PizzaException {
        if (newCol != null) {
            this.col = newCol;
        } else {
            throw new PizzaException("Sorry, null color!");
        }
    }

    @Override
    /**
     * Below method compares two vegetables.
     */
    public boolean equals(Object compareObj) {
        boolean output = false;
        if (compareObj instanceof Vegetable) {
            Vegetable value = (Vegetable) compareObj;
            if (this.getColor().equals(value.getColor())) {
                output = super.equals(value);
            }
        }
        return output;
    }

    @Override
    /**
     * Below is the final string method.
     */
    public String toString() {
        String output= super.toString() + ". The color is " + this.getColor();
        return output;
    }

}