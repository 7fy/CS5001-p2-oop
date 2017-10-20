package towerdefence;

public class Slingshot extends Tower {

	public Slingshot(int position) {
		this.damage = 1;
		this.type = 1;
		this.cost = 5;
		this.reloadTime = 1;
		this.position = position;
		this.symbol = "S";

	}

	@Override
	public String toString() {
		return "Slingshot:\n\n" + super.toString();
	}
}
