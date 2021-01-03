
/**
 * This class represents a circle, with the data x, y, radius and shape.
 *
 * @author Deepali Juneja
 * @version April 15, 2020
 */
public class Circle {
    private int x;
    private int y;
    private double radius;
    private String shape = "O";
   
    /**
     * The first empty constructor, sets the circle to 0.
     */
    public Circle() {
        this(0,0,0);   
    }
   /**
    * This is the second constructor, it takes a x and y as the paramerter and sets the radius to 1.
    * @param x
    * @param y
    */
    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
        radius = 1;
    }
   
    /**
     * This is the third constructor, it takes a x, y, and radius as the parameters.
     */
    public Circle(int x, int y, double rad) {
        this.x = x;
        this.y = y;
        this.radius = rad;
    }
   
    /**
     * This method returns the shape of the circle.
     * @return shape
     */
    public String draw() {
        return this.shape;
    }
   
    /**
     * This method is the getter for x.
     */
    public int getX() {
        return this.x;
    }
   
    /**
     * This is the getter for y
     * @return y value
     */
    public int getY() {
        return this.y;
    }
   
    /**
     * This is the getter for the radius. 
     * @return the radius 
     */
    public double getRadius() {
        return this.radius;
    }
   
    /**
     * This is the getter for the area, it uses pi*r^2 formula to calculate the area.
     * @return the area.
     */
    public double getArea() {
        double area = Math.PI * (radius * radius);
        return area;
    }
    
    /**
     * This is the setter for x
     * @param x
     */
     public void setX(int x) {
        this.x = x;
    }
 
    /**
     * 
     * This is the setter for y.
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
 
    /**
     * This is the setter for the radius.
     */
    public void setRadius(double rad) {
        this.radius = rad;
    }
   
    /**
     * This is the equals method to compare two circles.
     * @param that other circle
     * @return
     */
    public boolean equals(Circle that) {
        if(this.x == that.x && this.y == that.y && this.radius == that.radius){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * This is the toString method for the class.
     */
    @Override
    public String toString() {
        return this.shape;
    }
 }