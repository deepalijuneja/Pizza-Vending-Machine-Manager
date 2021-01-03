
import java.io.Serializable;

/**
 * The money class below comes from the homework done in the class before and it used to represent the amount in dollars and cents.
 * 
 * @author Deepali Juneja
 * @version 2 June 2020
 */
public class Money implements Cloneable, Comparable, Serializable {
    
    private int dollars;
    private int cents;

    /**
     * Below is the first, empty constructor.
     */
    public Money() {
        this(0, 0);
    }

    /**
     * Below is the second constructor
     * 
     * @param dol $ dollars
     */
    public Money(int dol) {
        this.setCents(0);
        this.setDollars(dol);
    }

    /**
     * Below is the third constructor.
     * 
     * @param dol  $ dollars
     * @param cent $ cents
     */
    public Money(int dol, int cent) {
        this.setDollars(dol);
        this.setCents(cent);
    }

    /**
     * Final copy constructor
     * 
     * @param anotherObj 
     */
    public Money(Money anotherObj) {
        if (anotherObj != null) {
            this.setCents(anotherObj.getCents());
            this.setDollars(anotherObj.getDollars());
        } else {
            throw new IllegalArgumentException("Null!");
        }
    }

    /**
     * Getter for dollars
     * 
     * @return dollars $
     */
    public int getDollars() {
        int tempDol = this.dollars;
        return tempDol;
    }

    /**
     * Getter for cents
     * 
     * @return cents $
     */
    public int getCents() {
        int tCent = this.cents;
        return tCent;
    }

    /**
     * Setter for dollar
     * 
     * @param newDollar The amount of dollars.
     */
    public void setDollars(int newDollar) {
        if (newDollar >= 0) {
            this.dollars = newDollar;
        } else {
            throw new IllegalArgumentException(" KEEP dollars in limits!");
        }
    }

    /**  
     * Setter for cents.
     * 
     * @param newCent The amount of cents
     */
    public void setCents(int newCent) {
        if (newCent >= 0 && newCent < 100) {
            this.cents = newCent;
        } else {
            throw new IllegalArgumentException("KEEP cents in limits!");
        }
    }

    
    /** 
     * Below is the set method for money
     * 
     */public void setMoney(int dol, int cent) {
        if (dol >= 0 && cent >= 0 && cent < 100) {
            this.dollars = dol;
            this.cents = cent;
        } else {
            throw new IllegalArgumentException("Null!");
        }
    }

    /**
     * Below is the return method
     * 
     * @return totalAmt  total money
     */
    public double getMoney() {
        double totalAmt = (this.getCents()) / 100.0;
        totalAmt += this.getDollars();
        return totalAmt;
    }

    /**
     * Below method adds money.
     * 
     * @param dol
     */
    public void add(int dol) {
        this.setDollars(this.getDollars() + dol);
    }

    /**
     * Below method adds money to the original amount.
     * 
     * @param dol
     * @param cent
     */
    public void add(int dol, int cent) {
        int tDol = this.getDollars();
        int tCent = this.getCents();

        tDol += dol;
        tCent += cent;

        if (tCent >= 100) {
            tDol++;
            tCent -= 100;
        }
        this.setDollars(tDol);
        this.setCents(tCent);
    }

    /**
     * Below is the add method to add money.
     * 
     * @param anotherObj
     */
    public void add(Money anotherObj) {
        if (anotherObj != null) {
            int tDol = this.getDollars() + anotherObj.getDollars();
            int tCent = this.getCents() + anotherObj.getCents();

            if (tCent >= 100) {
                tCent -= 100;
                tDol++;
            }
            this.setDollars(tDol);
            this.setCents(tCent);
        }
    }

    /**
     * Below is the equals method which compares money to another object.
     *
     * @param other
     */
    public boolean equals(Money anotherObj) {
        boolean output = false;
        if (anotherObj != null) {
            if (this.getDollars() == anotherObj.getDollars()) {
                if (this.getCents() == anotherObj.getCents()) {
                    output= true;
                }
            } else {
                output = false;
            }
        } else {
            throw new IllegalArgumentException("Sorry! This is a null value.");
        }

        return output;
    }

    /**
     * The string method prints the money.
     */
    @Override
    public String toString() {
        String output = "The amount is $" + this.getMoney();
        return output;
    }

    @Override
    /**
     * The compareTo method below returns 1 or -1 based on the ingredient.
     */
    public int compareTo(Object o) {
        int output = -1;
        Money value = (Money) o;
        if (this.getDollars() > value.getDollars()||this.getDollars()==value.getDollars() && this.getCents() > value.getCents()) {
            output = 1;
        } else if (this.equals(value)) {
            output = 0;
        }
        return output;
    }

    @Override
    /**
     * Below is the final 'clone' method.
     */
    public Money clone() {
        Money value = null;
        try {
            value = (Money) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError("Sorry! The clone isn't working!");
        }
        return value;
    }

}