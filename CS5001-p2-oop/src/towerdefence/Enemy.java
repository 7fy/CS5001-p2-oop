package towerdefence;

public class Enemy {
	protected int health;
	protected int position = 0;
	protected int type;
	protected int money;

	public int getHealth() {
		return this.health;
	}

	public int getPosition() {
		return position;
	}

	public void hit(Tower t) {
		if (getHealth() > 0 && getPosition() <= t.getPosition()) {
			health -= t.getDamage();
		}
	}

	public void advance() {
	}

	public void getMoney() {
	}

	@Override
	public String toString() {
		return ("Type: " + this.type + " HP: " + health + " Postion: " + position + " ** ");
	}
}
