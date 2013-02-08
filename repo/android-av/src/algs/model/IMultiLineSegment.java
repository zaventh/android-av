package algs.model;

/**
 * A Line Segment between two multidimensional points.
 * 
 * @author George Heineman
 * @version 1.0, 6/15/08
 * @since 1.0
 */
public interface IMultiLineSegment {

	/** Return the dimensionality of this line segment. */
	int dimensionality ();
	
	/** 
	 * Return the coordinate value of the Start of the line segment as an IMultiPoint.
	 */
	IMultiPoint getStartPoint ();
	
	/** 
	 * Return the coordinate value of the End of the line segment as an IMultiPoint. 
	 */
	IMultiPoint getEndPoint ();
}
