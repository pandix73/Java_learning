package netdb.courses.softwarestudio.geomap.spatial;

/**
 * A generalized rectangle in a geometric space.
 */
public class Rectangle extends Shape {
	protected Point lower;
	protected Point upper;

	public Rectangle(Point lower, Point upper) {
		if (lower.getDimension() < 2
				|| lower.getDimension() != upper.getDimension())
			throw new IllegalArgumentException();
		this.lower = lower;
		this.upper = upper;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		
		if(!(obj instanceof Rectangle)) return false;
		Rectangle rec = (Rectangle) obj;
		return rec.lower.equals(lower) && rec.upper.equals(upper);
	}
	
	@Override
	public String toString() {
		StringBuffer ret = new StringBuffer("Circle@{");
		ret.append(lower.toString());
		ret.append(", " + upper.toString() + "}");
		return ret.toString();
	}

	public double getSide(int dim) {
		return upper.getCoordinate(dim) - lower.getCoordinate(dim);
	}
	
	@Override
	public double getVolume() {
		double sum = 1d;
		for (int i = 0; i < upper.getDimension(); i++) {
			sum *= getSide(i);
		}
		return sum;
	}
	
	public boolean isCovered(Point p){
		double leftX = lower.getCoordinate(0);
		double rightX = upper.getCoordinate(0);
		double upY = upper.getCoordinate(1);
		double downY = lower.getCoordinate(1);
		double x = p.getCoordinate(0);
		double y = p.getCoordinate(1);
		return (leftX <= x && x <= rightX && downY <= y && y <= upY);
	}
	
	public boolean isCovered(Rectangle r){
		double[] lu = {lower.getCoordinate(0), upper.getCoordinate(1)};
		double[] rd = {upper.getCoordinate(0), lower.getCoordinate(1)};
		Point leftUp = new Point(lu);
		Point rightDown = new Point(rd);
		return (r.isCovered(leftUp) || r.isCovered(rightDown) ||
				r.isCovered(upper) || r.isCovered(lower));
	}
	
	public boolean isCovered(Circle c){
		return c.isCovered(this);
	}
}
