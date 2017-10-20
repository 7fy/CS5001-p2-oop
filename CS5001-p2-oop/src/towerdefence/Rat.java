package towerdefence;

public class Rat extends Enemy {

	public Rat() {
		this.type = 1;
		this.health = 1;
		this.money = 1;
	}

	public void advance() {
		position += 2;
	}
}
