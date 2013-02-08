package algs.model;


/**
 * A circle point has an IPoint origin and a radius >= 0.
 * 
 * @author George Heineman
 * @version 1.0, 6/15/08
 * @since 1.0
 */
public interface ICircle {
	
	/** Return the x-coordinate value of the circle origin. */
	double getX();
	
	/** Return the y-coordinate value of the circle origin. */
	double getY();
	
	/** Return origin as an IPoint. */
	public IPoint getOrigin();
	
	/** return the radius of the circle. */
	double getRadius();
	
	/** return bounding rectangle for this circle. */
	IRectangle boundingRectangle();
	
	/** 
	 * Must properly compute equals(Object) to compare based 
	 * origin and radius
	 * 
	 * @see Object#equals(Object)
	 */
	boolean equals (Object o);
}
