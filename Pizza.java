import java.util.Random;

/**
 * The below Pizza class is the most important class of this project as its purpose is to manage the Pizzas.
 * 
 * @author Deepali Juneja
 * @version 4 June 2020
 */
public class Pizza implements PizzaComparable {
    private ArrayList<Ingredient> listOfIngredients;// The total list of ingrdients for the pizza
    private int calorieCounter; // the total calories counter for the pizza
    private Money totalCost;// The total amount of the pizza
    private Shape pShape;// The pizza shape
    private Fraction remPizza;// the remaining pizza
    private int radius = 30;// for the circle (in cm)
    private int length = 30;// for the square pizza (in cm)

    /**
     * Below is the first, random constructor 
     * 
     * @throws PizzaException
     */
    public Pizza() throws PizzaException {
        listOfIngredients = new ArrayList<>();

        this.totalCost = new Money();

        this.selectShape(this.randomNum());

        this.remPizza = new Fraction(1, 1);

        Ingredient baseSauce = this.generateSauce(this.randomNum());
        Ingredient cheese = this.generateCheese(this.randomNum());
        Ingredient meat = this.generateMeat(this.randomNum());
        Ingredient veggies = this.generateVegetable(this.randomNum());

        this.addIngredient(baseSauce);
        this.addIngredient(cheese);
        this.addIngredient(meat);
        this.addIngredient(veggies);

    }

    /**
     * Below method tells us how much pizza is remaining
     * 
     * @return
     */
    public Fraction getRemainingPizza() {
        Fraction value = this.remPizza.clone();
        return value;
    }//checkpoint

    /**
     * Below pizza gives the pizza left after someone has taken some of it.
     * 
     * @param fraction
     * @throws PizzaException
     */
    public void setRemaining(Fraction f) throws PizzaException {
        if (f.compareTo(new Fraction(1, 100000)) == -1) {
            throw new PizzaException("Please keep values greater than zero!");//gives close to zero. i saw problems trying to make it 0
        } else if (f.compareTo(new Fraction(1, 1)) == 1) {
            throw new PizzaException("Uh-oh, this is going more than 1, sorry!");
        } else {
            this.remPizza = f.clone();
        }
    }//checkpoint

    /**
     * Below method gives calories in pizza.
     * 
     * @return
     */
    public int getCalorieCounter() {
        int value = this.calorieCounter;
        return value;
    }//checkpoint

    /**
     * Below method gives cost of pizza.
     * 
     * @return
     */
    public Money getTotalCost() {
        Money value = this.totalCost.clone();
        return value;
    }//checkpoint
    
    /**
     * Getter for pizza shape.
     * 
     * @return
     */
    public Shape getPizzaShape() {
        Shape s = this.pShape.clone();
        return s;
    }//checkpoint
    
    /**
     * Below method gives the remaining area as pizza is eaten.
     * 
     * @return
     */
    public double getArea() {
        double a = (double) this.getRemainingPizza().getNum() * (this.getPizzaShape().getArea());
        a /= (double) this.getRemainingPizza().getDen();
        return a;
    }//checkpoint

    /**
     * Setter for pizza shape.
     */
    public void setShape(Shape newShape) throws PizzaException {
        if (newShape != null) {
            this.pShape = newShape.clone();
        } else {
            throw new PizzaException("Null!");
        }
    }//checkpoint

    /**
     * Below methods adds and ingredient. The price and calories change accordingly!
     * 
     * @param newIngredient
     * @throws PizzaException
     */
    public void addIngredient(Ingredient newIngredient) throws PizzaException {
        if (newIngredient != null) {
            listOfIngredients.add(newIngredient);
            this.calorieCounter += newIngredient.getCal();
            this.totalCost.add(newIngredient.getCost());
        } else {
            throw new PizzaException("Null!");
        }
    }//checkpoint

    /**
     * Below method gives the fraction of pizza left as slices are eaten.

     * 
     * @param atePizza
     * @throws PizzaException
     */
    public void eatSomePizza(Fraction atePizza) throws PizzaException {
        if (atePizza != null) {
            if (this.getRemainingPizza().getNum() == 0) {
                throw new PizzaException("Hurry! We need more pizza!");
            }
            if (atePizza.getNum() < 0) {
                throw new PizzaException("Null!");
            }
            int firstPFrac = this.getRemainingPizza().getNum() * atePizza.getDen();
            int secondPFrac = this.getRemainingPizza().getDen() * atePizza.getNum();
            int diff = firstPFrac - secondPFrac;
            if (diff > 0) {
                int denom = this.getRemainingPizza().getDen() * atePizza.getDen();
                this.setRemaining(new Fraction(diff, denom));
            }
            if (diff == 0) {
                throw new PizzaException("Done, all pizza is gone!");
            }
            if (diff < 0) {
                throw new PizzaException("This is less than zero");
            }
        }
    }//checkpoint

    /**
     * Below method helps choose the base sauce.
     * 
     * @param choice
     * @return
     * @throws PizzaException
     */
    private Ingredient generateSauce(int option) throws PizzaException {
        Base baseSauce = null;
        if (option == 0) {
            baseSauce = new Marinara();
        }
        if (option == 1) {
            baseSauce = new Alfredo();
        }
        return baseSauce;
    }//checkpoint
    
    /**
     * Below method helps choose the vegetable topping.
     * 
     * @param choice
     * @return
     * @throws PizzaException
     */
    private Ingredient generateVegetable(int choice) throws PizzaException {
        Vegetable veggies = null;
        if (choice == 0) {
            veggies = new Olive();
        }
        if (choice== 1) {
            veggies = new Pepper();
        }
        return veggies;
    }//checkpoint

    /**
     * Below method helps choose the meat.
     * 
     * @param choice
     * @return
     * @throws PizzaException
     */
    private Ingredient generateMeat(int choice) throws PizzaException {
        Meat meat = null;
        if (choice == 0) {
            meat = new Pepperoni();
        }
        if (choice == 1) {
            meat = new Sausage();
        }
        return meat;
    }//checkpoint

    /**
     * Below method is for the cheese type.
     * 
     * @param choice
     * @return
     * @throws PizzaException
     */
    private Ingredient generateCheese(int choice) throws PizzaException {
        Cheese cheese = null;
        if (choice == 0) {
            cheese = new Mozzarella();
        }
        if (choice == 1) {
            cheese = new Goat();
        }
        return cheese;

    }//checkpoint

    
    /**
     * Below method is to randomly pick a veggie.
     * 
     * @return
     */
    private int randomNum() {
        Random ranVeggie = new Random();
        int value = ranVeggie.nextInt(2);
        return value;
    }//checkpoint 

    /**
     * Below method is to randomly pick a shape.
     * 
     * @param choice
     * @throws PizzaException
     */
    private void selectShape(int choice) throws PizzaException {
        if (choice == 0) {
            this.setShape(new Circle(0, 0, this.radius));
        }
        if (choice == 1) {
            this.setShape(new Square(0, 0, this.length));
        }
    }//checkpoint

    /**
     * Finally printing the message!
     */
    @Override
    public String toString() {
        String output = "Pizza has a price: " + this.getTotalCost() + " and calories: " + this.getCalorieCounter();
        output += " area left: = " + this.getArea() + ", Fraction remaining: " + this.getRemainingPizza() + "\ningredients:\n";
        for (int i = 0; i < this.listOfIngredients.size(); i++) {
            output += listOfIngredients.get(i) + "\n";
        }
        return output;
    }//checkpoint

    @Override
    /**
     * Below compareTo method compares pizzas' cost.
     * 
     * @return -1/0/1
     */
    public int compareTo(Object o) {
        Pizza compObj = (Pizza) o;
        int output = this.getTotalCost().compareTo(compObj.getTotalCost());
        return output;
    }//checkpoint

    @Override
    /**
     * Below compare compareToBySize methods compares pizzas' sizes.
     * 
     * @return -1/0/1
     */
    public int compareToBySize(Object o) {
        int output = -1;
        Pizza value = null;
        if (o != null && o instanceof Pizza) {
            value = (Pizza) o;
            if (this.getArea() > value.getArea()) {
                output = 1;
            }
            if (this.getArea() < value.getArea()) {
                output = -1;
            }
            if (this.getArea() == value.getArea()) {
                output= 0;
            }
        }
        return output;
    }//checkpoint

    @Override
    /**
     * Below compareToByCalories method compares pizzas' calories.
     * 
     * @return -1/0/1
     */
    public int compareToByCalories(Object o) {
        int output = -1;
        Pizza value = null;
        if (o != null && o instanceof Pizza) {
            value = (Pizza) o;
            if (this.getCalorieCounter() > value.getCalorieCounter()) {
                output= 1;
            }
            if (this.getCalorieCounter() < value.getCalorieCounter()) {
                output = -1;
            }
            if (this.getCalorieCounter() == value.getCalorieCounter()) {
                output= 0;
            }
        }
        return output;
    }//checkpoint
}