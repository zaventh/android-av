package algs.model;

/**
 * Represents a hypercube in the n-dimensional Cartesian plane.
 * 
 * Note that it is an invariant that getLeft(d) <= getRight(d) for all dimensions d 
 * 
 * @author George Heineman
 * @version 1.0, 6/15/08
 * @since 1.0
 */
public interface IHypercube {
	
	/** return the dimensionality of this hypercube. */
	int dimensionality();
	
	/** 
	 * return the coordinate value for the left-side of the given dimension.
	 * 
	 * @param d    dimension value in the range 1 <= d <= dimensionality()
	 */
	double getLeft(int d);
	
	/** 
	 * return the coordinate value for the right-side of the given dimension.
	 * 
	 * @param d    dimension value in the range 1 <= d <= dimensionality()
	 */
	double getRight(int d);
	
	/** 
	 * Determine if the given point intersects the hypercube.
	 * 
	 * The hypercube presents closed intervals on all dimensions.
	 * @exception   If dimensions are not the same
	 */
	boolean intersects (IMultiPoint p) throws IllegalArgumentException;

	/** Optimized version of {@link IHypercube#intersects(IMultiPoint)}. */
	boolean intersects(double[] coords);
	
	/**
	 * Determine if the hypercube intersects the given hypercube h.
	 * @param h     The target hypercube.
	 * @exception   If dimensions are not the same
	 */
	boolean intersects (IHypercube h) throws IllegalArgumentException;
	
	/** 
	 * Determine if the hypercube wholly contains the given hypercube h.
	 * 
	 * The hypercube presents closed intervals on all dimensions.
	 * @param h     The target hypercube.
	 * @exception   If dimensions are not the same
	 */
	boolean contains (IHypercube h) throws IllegalArgumentException;
}
