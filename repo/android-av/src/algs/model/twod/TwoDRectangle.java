package algs.model.twod;

import algs.model.FloatingPoint;
import algs.model.IPoint;
import algs.model.IRectangle;

/**
 * Represents a rectangular region in the Cartesian plane.
 * <p>
 * Note that the rectangle could be infinite in none, one, or two of these dimensions
 * by having any of its coordinates set to Double.NEGATIVE_INFINITY or 
 * Double.POSITIVE_INFINITY. A rectangle could be one-dimensional (if either x1==x2 or
 * y1==y2) or zero-dimensional (if both x1==x2 and y1==y2).
 * <p>
 * RectangularRegion is (slightly) incompatible with IHypercube because rectangles are
 * commonly referred to as (left, bottom, right, top). As you can see, the dimensions
 * are intermixed. IHypercube expects a number of dimensions, and to keep things straight
 * they are reported in order: here this means it would be (left, right) (bottom, top).
 * In order to avoid confusion, we make no attempt to have this class conform to both
 * IRectangle and IHypercube.
 * <p>
 * Note that for convenience, there is a method in Hypercube that will create a 
 * two-dimensional Hypercube counterpart given a RectangularRegion. 
 * 
 * @see algs.model.IHypercube
 * 
 * @author George Heineman
 * @version 1.0, 6/15/08
 * @since 1.0
 */
public class TwoDRectangle implements IRectangle {

	/** Left of the region. */
	double left;
	
	/** Bottom of the region. */
	double bottom;
	
	/** Right of the region. */
	double right;
	
	/** Top of the region. */
	double top;
	
	/**
	 * Construct a rectangle from the given cartesian coordinates.
	 * 
	 * @param left
	 * @param bottom
	 * @param right
	 * @param top
	 */
	public TwoDRectangle (double left, double bottom, double right, double top) {
		this.left = left;
		this.bottom = bottom;
		this.right = right;
		this.top = top;
	}
	
	/** Copy constructor. */
	public TwoDRectangle (IRectangle d) {
		this.left = d.getLeft();
		this.right = d.getRight();
		this.bottom = d.getBottom();
		this.top = d.getTop();
	}
	
	/** Return bottom of rectangle. */
	public double getBottom() {
		return bottom;
	}

	/** Return left of rectangle. */
	public double getLeft() {
		return left;
	}

	/** Return right of rectangle. */
	public double getRight() {
		return right;
	}

	/** Return top of rectangle. */
	public double getTop() {
		return top;
	}

	/** Update top of rectangle. */
	public void setTop (double d) {
		top = d;
	}
	
	/** Update bottom of rectangle. */
	public void setBottom (double d) {
		bottom = d;
	}
	
	/** Update left of rectangle. */
	public void setLeft (double d) {
		left = d;
	}
	
	/** Update right of rectangle. */
	public void setRight (double d) {
		right = d;
	}
	
	/**
	 * Determines intersection of the given point within the closed Rectangular region.
	 * @param p   IPoint to be inspected.
	 */
	public boolean intersects(IPoint p) {
		double x = p.getX();
		double y = p.getY();
		
		return (FloatingPoint.greaterEquals(x, left) &&
			FloatingPoint.lesserEquals(x, right) &&
			FloatingPoint.greaterEquals(y, bottom) &&
			FloatingPoint.lesserEquals(y, top));
		
		//return (x >= left) && (x <= right) && (y >= bottom) && (y <= top);
	}
	
	/**
	 * Determines containment of the given rectangle within the closed Rectangular region.
	 * <p>
	 * Handle -INF and +INF equitably.
	 * @param r   Rectangle to be checked for containment within self.
	 */
	public boolean contains (IRectangle r) {
		double rl = r.getLeft();
		double rr = r.getRight();
		if (FloatingPoint.lesserEquals(left, rl) &&
				FloatingPoint.lesserEquals(rl, rr) &&
				FloatingPoint.lesserEquals(rr, right)) {
		//if (left <= rl && rl <= rr && rr <= right) {
			double rb = r.getBottom();
			double rt = r.getTop();
			if (FloatingPoint.lesserEquals(bottom, rb) && 
					FloatingPoint.lesserEquals(rb, rt) &&
					FloatingPoint.lesserEquals(rt, top)) {
			//if (bottom <= rb && rb <= rt && rt <= top) {
				return true;
			}
		}
		
		// nope!
		return false;
	}
	
	/** Reasonable representation of this rectangular region. */
	public String toString () {
		return "[" + left + "," + bottom + " : " + right + "," + top + "]";
	}
	
	/**
	 * Extend to cover .equals() to any object that implements IRectangle.
	 * 
	 * Perform comparison on (left,bottom,right,top) values.
	 * 
	 * @see Object#equals(Object)
	 */
	public boolean equals (Object o) {
		if (o == null) return false;
		if (o instanceof IRectangle) {
			IRectangle other = (IRectangle) o;
			
			return left == other.getLeft() &&
				   bottom == other.getBottom() &&
				   right == other.getRight() &&
				   top == other.getTop();
		}
		
		// nope
		return false;
	}

}
