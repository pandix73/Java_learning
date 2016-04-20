package netdb.courses.softwarestudio.geomap.map;

import java.util.*;
import netdb.courses.softwarestudio.geomap.spatial.*;
	
public class GeoMapImpl implements GeoMap{
	List<Shape> shapes = new ArrayList<Shape>();

	public void addShape(Shape s){
		shapes.add(s);
	}
	
	public void addShapes(Shape[] s){
		for(Shape i : s)
			shapes.add(i);
	}
	
	public Shape[] rangeQuery(Rectangle rec){
		List<Shape> cover = new ArrayList<Shape>();
		for(Shape i : shapes){
			if(i instanceof Circle)
				if(((Circle)i).isCovered(rec))cover.add(i);
			else if(i instanceof Rectangle)
				if(((Rectangle)i).isCovered(rec))cover.add(i);
			else if(i instanceof Square)
				if(((Square)i).isCovered(rec))cover.add(i);
		}
		Shape[] result = new Shape[cover.size()];
		for(int i = 0; i < cover.size(); i++)
			result[i] = cover.get(i);
		return result;
	}
	
	public Shape[] knnQuery(Point p, int k){
		Shape[] result = new Shape[shapes.size()];
		for(int i = 0; i < shapes.size(); i++)
			result[i] = shapes.get(i);
		return result; 
	}
	
}
