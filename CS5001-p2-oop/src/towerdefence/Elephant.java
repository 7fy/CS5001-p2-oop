package towerdefence;

public class Elephant extends Enemy {
	int load = 2;

	public Elephant() {
		this.type = 2;
		this.health = 10;
		this.money = 5;
	}

	public void advance() {
		if (load == 2) {
			load--;
		} else if (load == 1) {
			position += 1;
			load = 2;
		}
	}
}
