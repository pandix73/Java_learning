package netdb.courses.softwarestudio.geomap.spatial;

/**
 * A generalized square in a geometric space.
 *
 */
public class Square extends Rectangle {
	public Square(Point lower, Point upper) {
		super(lower, upper); // must be called first
		double s0 = getSide(0);
		for (int i = 1; i < lower.getDimension(); i++) {
			if (getSide(i) != s0)
				throw new IllegalArgumentException();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		
		if (!(obj instanceof Square)) return false;
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		StringBuffer ret = new StringBuffer("Square@{");
		ret.append(lower.toString());
		ret.append(", " + upper.toString() + "}");
		return ret.toString();
	}
}
