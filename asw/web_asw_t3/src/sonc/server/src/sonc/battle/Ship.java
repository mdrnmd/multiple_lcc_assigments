package sonc.server.src.sonc.battle;

public class Ship extends MovingObject {

	Ship(int status, double heading, double speed) {
		super(status, heading, speed);
		// TODO Auto-generated constructor stub
	}

	@Override
	double getMaxSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getMaxSpeedChange() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getMaxRotation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int getImpactDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	Ship getOrigin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
