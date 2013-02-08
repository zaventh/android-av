package algs.model;

/**
 * Represents a rectangle in the Cartesian plane.
 * <p>
 * Classes that implement this interface must provide accurate {@link Object#equals(Object)}
 * and {@link Object#hashCode()} methods. To be useful during debugging, one should
 * also have a meaningful {@link Object#toString()} method.
 * <p>
 * Note that it is an invariant that getLeft() <= getRight() while getBottom() <= getTop() 
 * 
 * @author George Heineman
 * @version 1.0, 6/15/08
 * @since 1.0
 */
public interface IRectangle {
	
	/** return the x-coordinate value for the left-side. */
	double getLeft();
	
	/** return the y-coordinate value for the bottom. */
	double getBottom();
	
	/** return the x-coordinate value for the right-side. */
	double getRight();
	
	/** return the y-coordinate value for the top. */
	double getTop();
	
	/** 
	 * Determine if the given point intersects the rectangle.
	 * 
	 * The rectangle presents closed intervals on both the X and Y dimension.
	 */
	boolean intersects (IPoint p);
	
	/** 
	 * Determine if rectangle contains the given rectangle r.
	 * 
	 * The rectangle presents closed intervals on both the X and Y dimension.
	 */
	boolean contains (IRectangle r);
	
	/** 
	 * Must properly compute equals(Object) to compare based on getXXX() values.
	 * 
	 * @see Object#equals(Object)
	 */
	boolean equals (Object o);
}
