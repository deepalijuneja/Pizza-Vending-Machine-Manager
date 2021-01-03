import java.awt.*;

/* Class Shape
 *
 * By Rob Nash (with minor edits by David Nixon)
 * 
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

// the superclass in our inheritance hierarchy
// all "common" features, functions and data should go here
// for example, all shapes in Java2D have a x,y that declares their position
// and many of the shapes exposed have a width and a height (but not all, so we didn't put width and height here)
// note that this class is mostly empty, as there is no algorithm generic enough to guess an arbitrary shape's area 
// (future subclasses must override getArea() to provide something reasonable)
// Also, the draw method is empty too, as we don't know what shape to draw here! 
// (again, our subclasses will need to replace this method with one that actually draws things)
/**
 * This is the shape class for the pizza (recycled from lab with few additions and changes).
 * 
 * @author Deepali Juneja
 * @version 2 June 2020
 */
class Shape extends Object implements Cloneable{ // cloneable as per the project requirements
	private int x = 0;
	private int y = 0;
	protected Color col;

	/**
	 * Below is an empty constructor
	 */
	public Shape() {
		this(0, 0, new Color(0));
	}

	/**
	 * Below is the first constructor.
	 * 
	 * @param a  new X
	 * @param b  new Y
	 */
	public Shape(int a, int b) {
		this.setX(a);
		this.setY(b);
		this.col = new Color(0);
	}

	/**
	 * Below is the complete constructor
	 * 
	 * @param a        new X
	 * @param b        new Y
	 * @param newColor
	 */
	public Shape(int a, int b, Color newColor) {
		this.setX(a);
		this.setY(b);
		this.col = newColor;
	}

	/**
	 * Below is the getter for area.
	 * 
	 * @return -1
	 */
	public double getArea() {
		return -1;
	}

	/**
	 * Below method draws the shape
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
	}

	/**
	 * Below is the getter for 'x'
	 * 
	 * @return
	 */
	public int getX() {
		int valueX = this.x;
		return valueX;
	}

	/**
	 * Below is the getter for 'y'
	 * 
	 * @return
	 */
	public int getY() {
		int valueY = this.y;
		return valueY;
	}

	/**
	 * Below is the setter for 'x'
	 * 
	 * @param newX
	 */
	protected void setX(int newX) {
		this.x = newX;
	}

	/**
	 * Below is the setter for 'y'
	 * 
	 * @param newY
	 */
	protected void setY(int newY) {
		this.y = newY;
	}

	@Override
	 public Shape clone(){
	      Shape value = null;
		try {
			value = (Shape) super.clone();
		} catch (CloneNotSupportedException e) {
             throw new InternalError("Sorry, the clone did not work!");
        }
		return value;
	}
}