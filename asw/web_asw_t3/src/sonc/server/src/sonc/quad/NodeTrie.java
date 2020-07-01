package sonc.server.src.sonc.quad;

import java.util.HashMap;
import java.util.Map;

import sonc.quad.Trie.Quadrant;

public class NodeTrie<T extends HasPoint> extends Trie<T>{
	
	Map<Trie.Quadrant,Trie<T>> tries;

	NodeTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
		super(topLeftX, topLeftY, bottomRightX, bottomRightY);
		
		tries = new HashMap<Trie.Quadrant,Trie<T>>();
		tries.put(Trie.Quadrant.NE,new LeafTrie<T>(midX,topLeftY,bottomRightX,midY));
		tries.put(Trie.Quadrant.NW,new LeafTrie<T>(topLeftX,topLeftY,midX,midY));
		tries.put(Trie.Quadrant.SE,new LeafTrie<T>(midX,midY,bottomRightX,bottomRightY));
		tries.put(Trie.Quadrant.SW,new LeafTrie<T>(topLeftX,midY,midX,bottomRightY));

	}

	T find(T point) {
		Trie.Quadrant quad = quadrantOf(point);
		return tries.get(quad).find(point);
	}

	Trie.Quadrant quadrantOf(T point) {
		double x = point.getX();
		double y = point.getY();

		if(midX - x >= 0) {
			if(midY - y >= 0)
				return Quadrant.SW;
			else return Quadrant.NW;
		}
		else if(midY - y >= 0)	
			return Quadrant.SE;	
		else return Quadrant.NE;	
	}

	Trie<T> insert(T point) {
		Trie.Quadrant quad = quadrantOf(point);
		return tries.get(quad).insert(point);
	}

	Trie<T> insertReplace(T point) {
		Trie.Quadrant quad = quadrantOf(point);
		return tries.get(quad).insertReplace(point);
	}

	void delete(T point) {
		Trie.Quadrant quad = quadrantOf(point);
		tries.get(quad).delete(point);
	}

	void collectNear(double x,double y, double radius, java.util.Set<T> nodes) {
		for(Trie.Quadrant quad : Trie.Quadrant.values()) {
			tries.get(quad).collectNear(x,y,radius,nodes);
		}
	}

	void collectAll(java.util.Set<T> points) {
		for (Trie.Quadrant quad : Trie.Quadrant.values()) {
			tries.get(quad).collectAll(points);
		}
	}

	@Override
	public String toString() {
		return "NodeTrie [tries=" + tries + "]";
	}
}
