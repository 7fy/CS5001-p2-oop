package towerdefence;

public class Catapult extends Tower {

	public Catapult(int position) {
		this.damage = 5;
		this.type = 2;
		this.cost = 10;
		this.reloadTime = 3;
		this.position = position;
		this.symbol = "C";
	}

}
