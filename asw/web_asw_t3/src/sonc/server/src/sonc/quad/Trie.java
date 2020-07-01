package sonc.server.src.sonc.quad;

import java.util.Set;
import java.lang.String;

public abstract class Trie<T extends HasPoint> {

	protected double bottomRightX, bottomRightY;
	protected double topLeftX, topLeftY;
	static int capacity;
	protected double midX, midY;

	protected Trie(double bottomRightX, double bottomRightY, double topLeftX, double topLeftY) {
		super();
		this.bottomRightX = bottomRightX;
		this.bottomRightY = bottomRightY;
		this.topLeftX = topLeftX;
		this.topLeftY = topLeftY;
		midX = (bottomRightX + topLeftX)/2;
		midY = (bottomRightY + topLeftY)/2;
	}

	public static int getCapacity() {
		return capacity;
	}

	public static void setCapacity(int capacity) {
		Trie.capacity = capacity;
	}

	public static double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.abs(x2-x1)*Math.abs(x2-x1) + Math.abs(y2-y1)*Math.abs(y2-y1)); 
	}

	boolean overlaps(double x, double y, double radius) {
		/* checks corners 
		 * 9 checks still
		 */
		if(radius > getDistance(bottomRightX,bottomRightY,x,y)) 
			return true;
		else if(radius > getDistance(bottomRightX,topLeftY,x,y))
			return true;
		else if(radius > getDistance(topLeftX,topLeftY,x,y))
			return true;
		else if(radius > getDistance(topLeftX,bottomRightY,x,y))
			return true;
		else return false;
	}

	@Override
	public String toString() {
		return "Trie [bottomRightX=" + bottomRightX + ", bottomRightY=" + bottomRightY + ", topLeftX=" + topLeftX
				+ ", topLeftY=" + topLeftY + "]";
	}

	abstract void collectAll(Set<T> points);
	abstract void delete(T point);
	abstract void collectNear(double x, double y, double radius, Set<T> points);
	abstract T find(T point);
	abstract Trie<T> insert(T point);
	abstract Trie<T> insertReplace(T point);

	static enum Quadrant  {
		NW,
		NE, 
		SE, 
		SW;
	}

	public static Quadrant[] values() {
		Quadrant values[] = {Quadrant.NW,Quadrant.NE,Quadrant.SE,Quadrant.SW};
		return values;
	}

	public static Quadrant valueOf(String name)  
			throws IllegalArgumentException, NullPointerException {
		if(name == null)
			throw new NullPointerException();
		else {
			switch (name) {
			case "NW": 
				return Quadrant.NW;
			case "NE": 
				return Quadrant.NE;
			case "SE": 
				return Quadrant.SE;
			case "SW": 
				return Quadrant.SW;
			default: 
				throw new IllegalArgumentException();	
			}		
		}
	}

}
