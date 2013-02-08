package algs.model;

import java.util.Comparator;


/**
 * A point has an x- and y-coordinate over the cartesian plane.
 * 
 * Classes that implement this interface must provide accurate {@link Object#equals(Object)}
 * and {@link Object#hashCode()} methods. To be useful during debugging, one should
 * also have a meaningful {@link Object#toString()} method.
 * 
 * @author George Heineman
 * @version 1.0, 6/15/08
 * @since 1.0
 */
public interface IPoint {
	
	/**
	 * Globally useful sorter, that first sorts by x, and then by y coordinate.
	 * 
	 * Useful for determining full ordering of IPoint objects over a Cartesian Plane.
	 */
	public static Comparator<IPoint> xy_sorter =
		new Comparator<IPoint>() {

			public int compare(IPoint one, IPoint two) {
				double fp = FloatingPoint.value(one.getX() - two.getX());
				if (fp < 0) { return -1; }
				if (fp > 0) { return +1; }
				
				fp = FloatingPoint.value(one.getY() - two.getY());
				if (fp < 0) { return -1; }
				if (fp > 0) { return +1; }
				
				// same exact (x,y) points
				return 0;
			}

	};	
	
	/** return the x-coordinate value for the given point. */
	double getX();
	
	/** return the y-coordinate value for the given point. */
	double getY();
}
