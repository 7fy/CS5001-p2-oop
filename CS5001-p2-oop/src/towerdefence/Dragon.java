package towerdefence;

public class Dragon extends Enemy {

	public Dragon() {
		this.type = 3;
		this.health = 100;
		this.money = 0;
	}

	public void advance() {
		position += 1;

	}
}
