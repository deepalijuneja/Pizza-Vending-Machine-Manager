/**
 * The purpose of this class is to decorate the pizza objects, manage the cost, calorie count, and other characteristics like the colors of vegetables.
 * 
 * @author Deepali Juneja
 * @version 31 May 2020
 */
public class Ingredient implements Comparable<Ingredient> {
    private Money cost;// The cost of the ingredient.
    private int calories;// The number of calories in the ingredient
    private String description;// The description of the ingredient

    /**
     * Below is the first constructor. Parameters given-
     * 
     * @param newCost        new cost
     * @param newCal         new calories
     * @param newDesc        new description
     * @throws PizzaException
     */
    public Ingredient(Money newCost, int newCal, String newDesc) throws PizzaException {
        this.setCost(newCost);
        this.setCal(newCal);
        this.setDesc(newDesc);
    }
    
    /**
     * Getter for cost
     * 
     * @return cost
     */
    public Money getCost() {
        Money valueMoney = this.cost.clone();
        return valueMoney;
    }
    
    /**
     * Getter for calories
     * 
     * @return value for calories
     */
    public int getCal() {
        int valueCal = this.calories;
        return valueCal;
    }

    /**
     * Getter for description
     * 
     * @return give description
     */
    public String getDesc() {
        String valueDesc = this.description;
        return valueDesc;
    }

  
    /**
     * Below method gives a new description.
     * 
     * @param newDesc new description
     * @throws PizzaException 
     */
    private final void setDesc(String newDesc) throws PizzaException {
        if (!newDesc.isEmpty()) {
            this.description = newDesc;
        } else {
            throw new PizzaException("Sorry, this is an empty description!");
        }
    }

    /**
     * Setter for cost
     * 
     * @param newCost 
     * @throws PizzaException
     */
    private final void setCost(Money newCost) throws PizzaException {
        if (newCost != null) {
             this.cost = newCost.clone();
        } else {
            throw new PizzaException("Sorry, this is null!");
        }
    }

    /**
     * Setter for calories
     * 
     * @param newCal
     * @throws PizzaException
     */
    private final void setCal(int newCal) throws PizzaException {
         if (newCal >= 0) {
            this.calories = newCal;
        } else {
            throw new PizzaException("Sorry, calories need to be more than 0!");
        }
    }

    @Override
    /**
     * Below is the equals method to compare one object with another.
     * 
     * @param compareObj 
     * @return T/F
     */
    public boolean equals(Object compareObj) {
        boolean output = false;
        Ingredient value = null;
        if (compareObj instanceof Ingredient && compareObj != null) {
            value = (Ingredient) compareObj;
            if (this.getCal() == value.getCal()) {
                if (this.getDesc().equals(value.getDesc())) {
                    if (this.getCost().equals(value.getCost())) {
                        output = true;
                    }
                }
            }
        }
        return output;
    }

    @Override
    /**
     * Below method compares ingredients.
     * 
     * @param o the comparing to ingredient
     * @return -1/0/1
     */
    public int compareTo(Ingredient o) {
        int output = this.getCost().compareTo(o.getCost());
        return output;
    }

    @Override
    /**
     * Finally prints the message!
     */
    public String toString() {
        String output = "This is " + this.getDesc() + ", costs " + this.getCost() + ", and comes with calories:";
        output += this.getCal();
        return output;
    }
}