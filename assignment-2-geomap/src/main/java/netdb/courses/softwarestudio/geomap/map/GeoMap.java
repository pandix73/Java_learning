package netdb.courses.softwarestudio.geomap.map;

import netdb.courses.softwarestudio.geomap.spatial.Point;
import netdb.courses.softwarestudio.geomap.spatial.Rectangle;
import netdb.courses.softwarestudio.geomap.spatial.Shape;

/**
 * A 2D-map. Your assignment is to provide an implementation of this class as
 * netdb.courses.softwarestudio.geomap.map.GeoMapImpl.
 * 
 * To test Your implementation, modify the
 * netdb.courses.softwarestudio.geomap.Tester, right-click and run it as JUnit
 * Test.
 */
public interface GeoMap {
	
	/**
	 * Add a Shape object to the map.
	 * 
	 * @param s the Shape object you want to add
	 */ 
	void addShape(Shape s);
	
	/**
	 * Add a group of Shape objects to the map.
	 * 
	 * @param s a group of Shape objects
	 */
	void addShapes(Shape[] s);
	
	/**
	 * Query Shape objects covered by a specific range in this map.
	 * 
	 * @param rec the range you want to query
	 * @return the Shape objects in the range
	 */
	Shape[] rangeQuery(Rectangle rec);
	
	/**
	 * Query the closest k Shape objects from the point p in this map.
	 * 
	 * @param p a point you want to query from
	 * @param k the number of objects you want to query
	 * @return the closest k Shape objects
	 */
	Shape[] knnQuery(Point p, int k);
	
}
