package sonc.battle;

import sonc.quad.HasPoint;
import sonc.quad.Trie;

public abstract class MovingObject extends java.lang.Object 
implements HasPoint {
	double x, y;
	int status;
	double heading;
	double speed;
	
	MovingObject(int status,double heading,double speed) {
		super();
		this.status = status;
		this.heading = heading;
		this.speed = speed;
	}
	
	@Override
	public double getX() {
		return x;
	}
	
	void setX(double x) {
		this.x = x;
	}

	@Override
	public double getY() {
		return y;
	}
	
	void setY(double y) {
		this.y = y;
	}
	
	public double getHeading() {
		return heading;
	}
	
	void setHeading(double heading) {
		this.heading = heading;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	protected double normalizeAngle(double angle) {
		return Math.asin(Math.sin(angle));
	}

	protected double distanceTo(MovingObject other) {
		return Trie.getDistance(x, y, other.getX(), other.getY());
	}
	
	protected double headingTo(MovingObject other) {
		double deltax = x - other.getX();
		double deltay = y - other.getY();
		
		return Math.atan2(deltax,deltay);
	}
	
	final void updatePosition() {
		
		setX(0);
		setY(0);
		
	
	}
	
	final void doRotate(double delta) {
		
	}
	
	final void doChangeSpeed(double delta) {
		
	}
	
	void move() {
	
	}
	
	
	void hitdBy(MovingObject moving) {
		
	}
	
	public boolean isDestroyed() {
		return false;
	}
	
	public int getStatus() {
		return status;
	}
	
	abstract double getMaxSpeed();
	abstract double getMaxSpeedChange();
	abstract double getMaxRotation();
	abstract int getImpactDamage(); 
	abstract Ship getOrigin();
	public abstract int getSize();
	public abstract java.lang.String getColor();
}
