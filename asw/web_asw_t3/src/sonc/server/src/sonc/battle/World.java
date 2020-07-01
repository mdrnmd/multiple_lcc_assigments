package sonc.server.src.sonc.battle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sonc.shared.Movie;

public class World extends java.lang.Object{

	int rounds;
	double margin;
	double width,height;
	int currentRound;
	double collisionDistance;
	Set<MovingObject> movingObjects = new HashSet<MovingObject>();

	public World() {

	}

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	public double getMargin() {
		return margin;
	}

	public void setMargin(double margin) {
		this.margin = margin;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getCurrentRound() {
		return currentRound;
	}

	public void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}

	public double getCollisionDistance() {
		return collisionDistance;
	}

	public void setCollisionDistance(double collisionDistance) {
		this.collisionDistance = collisionDistance;
	}

	public Set<MovingObject> getMovingObjects() {
		return movingObjects;
	}

	void addMovingObject(MovingObject added) {

	}

	void addShipAtRandom(Ship ship) {

	}
	
	void addShipAt(Ship ship,double x,double y,double heading) {

	}

	public Set<Ship> getShips() {
		return null;
	}

	public Movie battle(List<Ship> ships) {
		return null;
	}
	
	void update() {

	}
}