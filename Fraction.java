/**
 * Below class comes from old homework and simplifies fractions. Some changes have been made/added based on this project's requirements.
 * 
 * @author Deepali Juneja
 * @version 2 June 2020
 */
public class Fraction implements Comparable, Cloneable {
    private int Num;
    private int Den;

    /**
     * The contructor below holds no argument.
     */
    public Fraction() {
        this.Num = 0;
        this.Den = 1;
    }

     /**
     *  In the constructor below, the division between the two numbers (numerator and denominator) occurs to derive the fraction in its reduced form using the greatest common denominator.
     * 
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        int greatestCD = 0;
        for (int i = 1; i <= numerator && i <= denominator; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                greatestCD = i;
            }
        }
        if (denominator != 0) {
            this.Num = Math.abs(numerator) / greatestCD;
            this.Den = Math.abs(denominator) / greatestCD;
        } else {
            throw new IllegalArgumentException("Division by zero is invalid, try a different number");
        }
    }

    /**
     * The getter below reads the value of the numerator.
     * 
     * @return value of the numerator 
     */
    public int getNum() {
        return this.Num;
    }

    /**
     * The getter below reads the value of the denominator.
     * 
     * @return value of the denominator
     */
    public int getDen() {
        return this.Den;
    }

    /**
     * The setter below updates the value of the numerator 'n'.
     * 
     * @param n numerator.
     */
    public void setNum(int n) {
        this.Num = n;
    }

    /**
     * The setter below updates the value of the denominator 'd'.
     * 
     * @param d denominator.
     */
    public void setDen(int d) {
        if (d!= 0) {
            this.Den = d;
        } else {
            throw new IllegalArgumentException("The denominator cannot be 0");
        }
    }

    /**
     * The final output/fraction class gets printed as a string.
     */
    @Override
    public String toString() {
         String output = "Fraction: " + getNum() + "/" + getDen();
        return output;
    }

    /**
     * Below is the method that compares 'this' or the current fraction to the 'other' fraction which is the input.
     * 
     * @param compareFrac 
     * @return true or false.
     */
    public boolean equals(Fraction compareFrac) {
        boolean output;
        double reducedFrac1 = this.getNum() / this.getDen();
        double reducedFrac2 = compareFrac.getNum() / compareFrac.getDen();
        if (reducedFrac1 == reducedFrac2) {
            output = true;
        } else {
            output = false;
        }
        return output;
    }

     @Override
    /**
     * Below method compares the cost of the ingredient.
     */
    public int compareTo(Object o) {
        int output = -1;
        Fraction obj = (Fraction) o;
        if (this.getNum() > obj.getNum()) {
            if (this.getNum() > obj.getNum()) {
                output= 1;
            }
        } else if (this.equals(obj)) {
            output = 0;
        }
        return output;
    }

    /**
     * Final clone method.
     */
    public Fraction clone() {
        Fraction value = null;
        try {
            value= (Fraction) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError("Sorry! The clone did not work!");
        }
        return value;
    }
}