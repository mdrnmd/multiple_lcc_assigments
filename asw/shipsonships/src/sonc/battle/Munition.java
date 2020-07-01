package sonc.battle;

abstract class Munition extends MovingObject {
	
	Munition(int status, double heading, double speed) {
		super(status, heading, speed);
	}
	
	void escape() {
	}
	
	abstract int fireDelay(); 
	
	double getMaxSpeedChange() {
		return 0;
	}
	
	double getMaxRotation() {
		return 0;
	}
	
	void setOrigin(Ship origin) {
		
	}
	
	Ship getOrigin() {
		return null;
		
	}
}
