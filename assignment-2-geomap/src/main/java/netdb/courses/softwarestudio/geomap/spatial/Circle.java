package netdb.courses.softwarestudio.geomap.spatial;

/**
 * A circle in a two-dimensional space.
 */
public class Circle extends Shape {
	private Point center;
	private double radius;

	public Circle(Point center, double radius) {
		if (center.getDimension() != 2)
			throw new IllegalArgumentException();
		this.center = center;
		this.radius = radius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		
		if(!(obj instanceof Circle)) return false;
		Circle c = (Circle) obj;
		return c.center.equals(center) && Double.compare(c.radius, radius) == 0;
	}
	
	@Override
	public String toString() {
		StringBuffer ret = new StringBuffer("Circle@{");
		ret.append(center.toString());
		ret.append(", " + radius + "}");
		return ret.toString();
	}

	@Override
	public double getVolume() {
		return Math.PI * radius * radius;
	}
	
	public double getDistance(Point p){
		return center.getDistance(p);
	}
	
	public boolean isCovered(Point p){
		return (this.getDistance(p) > radius) ? false : true;
	}
	
	public boolean isCovered(Rectangle r){
		double[] lu = {r.lower.getCoordinate(0), r.upper.getCoordinate(1)};
		double[] rd = {r.upper.getCoordinate(0), r.lower.getCoordinate(1)};
		Point leftUp = new Point(lu);
		Point rightDown = new Point(rd);
		
		double[] cu = {center.getCoordinate(0), center.getCoordinate(1) + radius};
		double[] cd = {center.getCoordinate(0), center.getCoordinate(1) - radius};
		double[] cl = {center.getCoordinate(0) - radius, center.getCoordinate(1)};
		double[] cr = {center.getCoordinate(0) + radius, center.getCoordinate(1)};
		Point cUp = new Point(cu);
		Point cDown = new Point(cd);
		Point cLeft = new Point(cl);
		Point cRight = new Point(cr);
		
		return (r.isCovered(cUp) || r.isCovered(cDown) || r.isCovered(cRight) ||
				r.isCovered(cLeft) || this.isCovered(r.lower) || this.isCovered(r.upper) ||
				this.isCovered(leftUp) || this.isCovered(rightDown));
	}
	
	public boolean isCovered(Circle c){
		double dis = center.getDistance(c.center);
		return (dis < radius + c.radius);
	}

}
