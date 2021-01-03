import java.awt.*;

/**
 * The square class is a subclass of shape class for the pizza. I added a few changes from the lab submission. 
 * 
 * @author Deepali Juneja
 * @version 2 June 2020
 */
public class Square extends Shape {// from the lab

    private int sideLength;

    /**
     * Below is the empty constructor of the class.
     */
    public Square() {
        super();
    }

    /**
     * Below is the setter constructor.
     */
    public Square(int x, int y) {
        super(x, y);
        this.setSideLength(0);
    }

    /**
     * Below is the size setter.
     */
    public Square(int x, int y, int sLen) {
        super(x, y);
        this.setSideLength(sLen);
    }

    /**
     * Below is the full constructor
     * @param x
     * @param y
     * @param sLen
     * @param col
     */
    public Square(int x, int y, int sLen, Color col) {
        super(x, y, col);
        this.setSideLength(sLen);
    }

    /**
     * Below is the getter for length
     * @return
     */
    public int getSideLength() {
        int valueSL = this.sideLength;
        return valueSL;
    }

    /**
     * Below is the setter for length
     */
    public void setSideLength(int sLen) {
        if (sLen >= 0) {
            this.sideLength = sLen;
        } else {
            throw new ArithmeticException("Sorry, length is not less than 0!");
        }
    }

    /**
     * Below is the getter for area
     */
    @Override
    public double getArea() {
        double a = Math.pow((double) this.getSideLength(), 2);
        return a;
    }

    /**
     * Finally, the method below draws the shape- square.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(super.col);
        g.drawRect(getX(), getY(), this.getSideLength(), this.getSideLength());
    }
}