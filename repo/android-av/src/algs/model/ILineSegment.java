package algs.model;

/**
 * A Line Segment between two-dimensional points.
 * <p>
 * The common etiquette is that the start of a line segment has the higher y-value
 * than the end of the line segment; note for horizontal line segments the start
 * will be the one whose x-value is smaller (i.e., left-to-right).
 * 
 * @author George Heineman
 * @version 1.0, 6/15/08
 * @since 1.0
 */
public interface ILineSegment {

	/** Types of intersecting line segments. */
	public static final int PARALLEL = 0;
	public static final int COINCIDENT = 1;
	public static final int INTERSECTING = 2;
	public static final int NON_INTERSECTING = -1;
	
	/** 
	 * Return the coordinate value of the Start of the line segment as a two-dimensional IPoint.
	 * 
	 * The start point will have a higher y-value than the end line, except for
	 * horizontal lines.
	 */
	IPoint getStart ();
	
	/** 
	 * Return the coordinate value of the End of the line segment as a two-dimensional IPoint.
	 * 
	 * The end point will have a lower y-value than the end line, except for
	 * horizontal lines.
	 */
	IPoint getEnd ();
	
	/** Determine if this line segment is simply a point (same start & end). */
	boolean isPoint();
	
	/**
	 * Return the slope of the line segment. For vertical lines, Double.NaN
	 */
	double slope();
	
	/**
	 * Return the sign of the slope of the line segment. 
	 * 
	 * Vertical lines return 1. Horizontal lines return 0. Lines with positive
	 * slope return +1 while lines with negative slope return -1.
	 */
	int sign();
	
	/** Determine if horizontal line. */
	boolean isHorizontal();
	
	/** Determine if vertical line. */
	boolean isVertical();
	
	/**
	 * Return the intersection point with the given Line Segment, or null if no such intersection.
	 * 
	 * Note that for overlapping line segments, it is unclear WHAT should be returned. 
	 */
	IPoint intersection (ILineSegment other);
	
	/**
	 * Determine if Line Segment intersects the given point.
	 */
	boolean intersection(IPoint p);	
	
	/**
	 * Determine if the given point is to the right of the line segment,
	 * if we view the line segment from the lower (end) point to the upper
	 * (start) point.
	 */
	public boolean pointOnRight(IPoint p);
	
	/**
	 * Determine if the given point is to the left of the line segment,
	 * if we view the line segment from the lower (end) point to the upper
	 * (start) point.
	 */
	public boolean pointOnLeft(IPoint p);
	
	/**
	 * Return the y-intercept of the line segment if it were extended to be a full line.
	 * For vertical lines, Double.NaN
	 */
	double yIntercept();
}
