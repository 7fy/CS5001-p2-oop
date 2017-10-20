package towerdefence;

public class Cannon extends Tower {

	public Cannon(int position) {
		this.damage = 10;
		this.type = 3;
		this.cost = 20;
		this.reloadTime = 3;
		this.position = position;
		this.symbol = "0";

	}

}
