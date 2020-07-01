package sonc.quad;

import java.util.HashSet;
import java.util.Set;

public class PointQuadtree<T extends HasPoint> extends java.lang.Object {
	
	NodeTrie<T> node;
	
	PointQuadtree(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
		super();
		node = new NodeTrie<T> (topLeftX, topLeftY, bottomRightX, bottomRightY);
	}
	
	public T find(T point) {
		return node.find(point);
	}
	
	public void insert(T point) {
		node.insert(point);
	}
	
	public void insertReplace(T point) {
		node.insertReplace(point);
	}
	
	public Set<T> findNear(double x,double y,double radius) {
		Set<T> points = new HashSet<T>();
		node.collectNear(x, y, radius, points);
		return points;
	}
	
	public void delete(T point) {
		node.delete(point);
	}
	
	public Set<T> getAll() {
		Set<T> points = new HashSet<T>();
		node.collectAll(points);
		return points;
	}
}
