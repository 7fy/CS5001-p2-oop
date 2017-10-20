package towerdefence;

public class Tower {
	protected int damage;
	protected int position;
	protected int type;
	protected int cost;
	protected int reloadTime;
	protected String symbol;

	public int getDamage() {
		return damage;
	}

	public int getPosition() {
		return position;
	}

	public boolean willFire(int timeStep) {
		if (timeStep % reloadTime == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Position = " + position + "\n\nDamage Points = " + damage;
	}
}
