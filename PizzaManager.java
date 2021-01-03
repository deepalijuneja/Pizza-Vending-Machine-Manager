import java.util.Random;
import java.util.Scanner;

/**
 * PizzaManager Skeleton File CSS 162, Final Project
 * 
 * This class is a starting point for your final project and is incomplete. Note
 * that if there are any inconsistencies between this skeleton and the
 * assignment description, the assignment description controls.
 * 
 * Author: Rob Nash with edits by Johnny Lin
 * 
 * @author Deepali Juneja (editor)
 * @version 4 June 2020
 */
public class PizzaManager {
    private static ArrayList<Pizza> pizzaList = new ArrayList<>();
    /*
     * TODO: Data definitions here.
     */

    /**
     * The console interface is defined in the start method You can exit or extend
     * the code below to accomplish all of the outcomes defined in the homework
     * document
     * 
     * @throws PizzaException
     */
    public void start() throws PizzaException {
        char selection = 'q';

        Scanner foo = new Scanner(System.in);

        while (true) {
            displayAllPizzas();
            displayInstructions();

            // foo.nextChar() doesn't exist, so now what?
            selection = foo.next().charAt(0);//done

            switch (selection) {
                case 'A':
                case 'a':
                    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                    addRandomPizza();//done
                    break;
                case 'H':
                case 'h':
                    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                    for (int i = 0; i < 100; i++) {
                        addRandomPizza();//done
                    }
                    break;
                case 'E':
                case 'e':
                    System.out.println("Eating a fraction of a pizza. How much? (a/");
                    eatSomePizza(foo);//done
                    break;
                case 'P':
                case 'p':
                    System.out.println("Sorting pizzas by (P)rice");
                    sortByPrice();//done
                    break;
                case 'S':
                case 's':
                    System.out.println("Sorting pizzas by (S)ize");
                    sortBySize();//done
                    break;
                case 'C':
                case 'c':
                    System.out.println("Sorting pizzas by (C)alories");
                    sortByCalories();//done
                    break;
                case 'B':
                case 'b':
                    System.out.println(
                            "(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
                try {
                        int c = foo.nextInt();//calories
                         if (c >= 0) {
                           int found = binarySearchByCalories(c);
                            if (found != -1) {
                                System.out.println("This pizza " + c + " at " + found);
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Null!");
                    }//done
                    foo.nextLine();
                    break;
                case 'I'://this is an extra case added
                case 'i':
                    System.out.println("Please enter the pizza index:");
                    int indexPos = foo.nextInt();
                    addNewIngredient(indexPos);
                    break;
                case 'Q':
                case 'q':
                    System.out.println("(Q)uitting!");
                    System.out.println("Bye! Have a great day! :) ");//done
                    return;
                default:
                    System.out.println("Unrecognized input - try again");
            }
        }

    }

    /**
     * Below method is useful because it helps the user add ingredients
     * 
     * @param indexPos
     * @throws PizzaException
     */
    private static void addNewIngredient(int indexPos) throws PizzaException {
        Random x = new Random();
        int opt = x.nextInt(2);
        Vegetable veg = null;
        if (opt == 0) {
            veg = new Olive();
        } else if (opt == 1) {
            veg = new Pepper();
        }
        pizzaList.get(indexPos).addIngredient(veg);
    }//check

    /**
     * From doc. Below method tells how much pizza is left after some is eaten.
     * 
     * @param keys
     */
    private void eatSomePizza(Scanner keys) {
        int pizzaF;
        if (pizzaList.size() == 0) {
            System.out.println("Hurry! We need more peace");
            return;
        }
        System.out.println("Choose pizza: 0 to " + (pizzaList.size() - 1));
        pizzaF = keys.nextInt();
        System.out.println();
        if (pizzaF >= 0 || pizzaF>= pizzaList.size()) {
            Pizza newPizza = (Pizza) pizzaList.get(pizzaF);
            System.out.println("Numerator: ");
            int pNum = keys.nextInt();
            System.out.println();
            System.out.println("Denominator: ");
            int pDen = keys.nextInt();
            if (pNum / pDen == 0) {
                Fraction atePizza = new Fraction(pNum, pDen);
                try {
                    newPizza.eatSomePizza(atePizza);
                } catch (PizzaException pe) {
                    if (newPizza.getRemainingPizza().getNum() == 0) {
                        pizzaList.remove(pizzaF);
                    } else {
                        pe.printStackTrace();
                    }
                }
            }//check

        }
    }

    /**
     * Below method adds pizza.
     */
    private void addRandomPizza() throws PizzaException {
        Pizza newPizza = new Pizza();
        pizzaList.add(newPizza);
    }//CHECK

    /**
     * Below method displays pizza
     */
    private void displayAllPizzas() {
        for (int i = 0; i < pizzaList.size(); i++) {
            System.out.println(pizzaList.get(i));
        }
    }//CHECK

    /**
     * Below method sorts pizza by price.
     */
    private void sortByPrice() {
        int smallSize;
        for (int i = 0; i < pizzaList.size(); i++) {
            smallSize = i;
            for (int j = i; j < pizzaList.size(); j++) {
                if (((Pizza) pizzaList.get(j)).compareTo(pizzaList.get(smallSize)) == -1) {
                    smallSize = j;
                }
            }
            Pizza verySmall = pizzaList.get(smallSize);
            Pizza valuePizza = pizzaList.set(verySmall, i);
            pizzaList.set(valuePizza, smallSize);
        }//check
    }

    /**
     * Below method sorts pizza by size.
     */
    private void sortBySize() {
        int smallSize;
        for (int i = 0; i < pizzaList.size(); i++) {
            smallSize= i;
            for (int j = i; j < pizzaList.size(); j++) {
                if (((Pizza) pizzaList.get(j)).compareToBySize(pizzaList.get(smallSize)) == -1) {
                    smallSize = j;
                }
            }
            Pizza verySmall = pizzaList.get(smallSize);
            Pizza valuePizza = pizzaList.set(verySmall, i);
            pizzaList.set(valuePizza, smallSize);

        }
    }

    /**
     * Below method sorts pizzas by calories
     */
    private void sortByCalories() {
        int smallSize;
        for (int i = 0; i < pizzaList.size(); i++) {
            smallSize = i;
            for (int j = i; j < pizzaList.size(); j++) {
                if (((Pizza) pizzaList.get(j)).compareToByCalories(pizzaList.get(smallSize)) == -1) {
                    smallSize = j;
                }
            }
            Pizza verySmall = pizzaList.get(smallSize);
            Pizza valuePizza = pizzaList.set(verySmall, i);
            pizzaList.set(valuePizza, smallSize);

        }
    }

    /**
     * Below binary search method helps to find similar pizzas by calories.
     * 
     * @param calo
     * @return
     * @throws PizzaException
     */
    private int binarySearchByCalories(int calo) throws PizzaException {
        sortByCalories();
        BinarySearch bin = new BinarySearch();
        int output = bin.recSearch(pizzaList, calo);
        return output;
    }//check

    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\nAdd a new (i)ngredient\n(Q)uit\n";

    private void displayInstructions() {//from doc
        System.out.println(instructions);
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) throws PizzaException {//from doc
        new PizzaManager().start();
    }
}