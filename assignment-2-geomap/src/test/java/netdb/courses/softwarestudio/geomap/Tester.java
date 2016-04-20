package netdb.courses.softwarestudio.geomap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.Logger;

import netdb.courses.softwarestudio.geomap.map.GeoMap;
import netdb.courses.softwarestudio.geomap.map.GeoMapImpl;
import netdb.courses.softwarestudio.geomap.spatial.Circle;
import netdb.courses.softwarestudio.geomap.spatial.Point;
import netdb.courses.softwarestudio.geomap.spatial.Rectangle;
import netdb.courses.softwarestudio.geomap.spatial.Shape;

import org.junit.Before;
import org.junit.Test;

public class Tester {
	private static Logger logger = Logger.getLogger(Tester.class.getName());

	private GeoMap map;

	@Before
	public void initGeoMap() {
		if (logger.isLoggable(Level.INFO))
			logger.info("Initiating geomap");

		double[] cor1 = { 1, 1 };
		double[] cor2 = { 2, 5 };
		double[] cor3 = { 3, 2 };
		double[] cor4 = { 5, 3 };
		// double[] cor5 = { 4, 4 };
		Point p1 = new Point(cor1);
		Point p2 = new Point(cor2);
		Point p3 = new Point(cor3);
		Point p4 = new Point(cor4);
		// Point p5 = new Point(cor5);
		Circle A = new Circle(p1, 2);
		Circle B = new Circle(p2, 1);
		Rectangle C = new Rectangle(p3, p4);
		Shape[] shapes = { B, C };

		/*
		 * TODO: You should implement
		 * netdb.courses.softwarestudio.geomap.map.GeoMapImpl then uncomment the
		 * following lines.
		 */
		 map = new GeoMapImpl();
		 map.addShape(A);
		 map.addShapes(shapes);
	}

	@Test
	public void testRangeQuery() {
		if (logger.isLoggable(Level.INFO))
			logger.info("Testing range queries");

		Point p1 = new Point(new double[] { 1, 1 });
		Point p2 = new Point(new double[] { 5, 3 });
		Rectangle range = new Rectangle(p1, p2);
		Shape[] results = map.rangeQuery(range);
		if (logger.isLoggable(Level.FINE)) {
			String debug = "Range query results:";
			for (Shape result : results)
				debug += "\n" + result;
			logger.fine(debug);
		}
		assertTrue("Wrong range query results", 2 == results.length);
		Circle expected0 = new Circle(new Point(new double[] { 1.0, 1.0 }), 2.0);
		assertTrue("Wrong range query results", results[0] instanceof Circle);
		assertEquals("Wrong range query results", expected0, results[0]);
		Rectangle expected1 = new Rectangle(
				new Point(new double[] { 3.0, 2.0 }), new Point(new double[] {
						5.0, 3.0 }));
		assertTrue("Wrong range query results", results[1] instanceof Rectangle);
		assertEquals("Wrong range query results", expected1, results[1]);
	}

	@Test
	public void testKnnQuery() {
		if (logger.isLoggable(Level.INFO))
			logger.info("Testing KNN queries");
		int k = 2;
		Point p = new Point(new double[] { 4, 4 });
		Shape[] results = map.knnQuery(p, k);
		if (logger.isLoggable(Level.FINE)) {
			String debug = "KNN query results:";
			for (Shape result : results)
				debug += "\n" + result;
			logger.fine(debug);
		}
		assertTrue("Wrong knn query results", 2 == results.length);
		Rectangle expected0 = new Rectangle(
				new Point(new double[] { 3.0, 2.0 }), new Point(new double[] {
						5.0, 3.0 }));
		assertTrue("Wrong knn query results", results[0] instanceof Rectangle);
		assertEquals("Wrong knn query results", expected0, results[0]);
		Circle expected1 = new Circle(new Point(new double[] { 2.0, 5.0 }), 1.0);
		assertTrue("Wrong knn query results", results[1] instanceof Circle);
		assertEquals("Wrong range query results", expected1, results[1]);

	}
}
