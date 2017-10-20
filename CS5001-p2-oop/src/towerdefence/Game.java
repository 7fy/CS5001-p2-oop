package towerdefence;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	ArrayList<Tower> towers = new ArrayList<Tower>();
	public int budget = 16;
	public int corridorLength;

	public static void main(String[] args) {
		// try {
		int corridorLength = new Integer(args[0]);
		if (corridorLength < 1 || corridorLength > 20) {
			System.out.println("the corridor should be >1 and <20");
		} else {
			Game game = new Game();
			game.corridorLength = corridorLength;
			game.advance();
		}
		// } catch (Exception e) {
		// System.out.println("Usage: java Game <corridorLength>");
		// }

	}

	public void advance() {

		for (int round = 1; round < 15; round++) {
			System.out.println("do you want to build a new tower? Y/N");
			System.out.println("budget: " + budget);
			Scanner buildTower = new Scanner(System.in);
			String inputOne = buildTower.next();
			while (!inputOne.equals("Y") && !inputOne.equals("N")) {
				System.out.println("you should input Y or N");
				buildTower = new Scanner(System.in);
				inputOne = buildTower.next();
			}
			if (inputOne.equals("Y")) {
				System.out.println("please choose the position of the tower.");
				System.out.println("position: 1 - " + corridorLength);

				Scanner positionTower = new Scanner(System.in);
				double inputTwo = positionTower.nextDouble();
				while (inputTwo > corridorLength || inputTwo < 1) {
					System.out.println("the tower position should in the corridor");
					positionTower = new Scanner(System.in);
					inputTwo = positionTower.nextDouble();
				}
				int towerPosition = (int) inputTwo;

				System.out.println("please select the type of the tower.");
				System.out.println("1-Catapult 	cost:10 damage:5  reload time:3 ");
				System.out.println("2-Slingshot cost:5 	damage:1  reload time:1 ");
				System.out.println("3-Cannon 	cost:20 damage:10 reload time:3  *Aoe attack *Attack range > 5");
				System.out.println("4-None");

				Scanner typeTower = new Scanner(System.in);
				double inputThree = typeTower.nextDouble();
				while (inputThree != 1 && inputThree != 2 && inputThree != 3 && inputThree != 4) {
					System.out.println("you should input 1 or 2 or 3");
					typeTower = new Scanner(System.in);
					inputThree = typeTower.nextDouble();
				}
				if (inputThree == 1) {
					Catapult catapult = new Catapult(towerPosition);
					while (budget < catapult.cost) {
						System.out.println("no enough money");
						typeTower = new Scanner(System.in);
						inputThree = typeTower.nextDouble();
					}
					budget -= catapult.cost;
					towers.add(catapult);
				} else if (inputThree == 2) {
					Slingshot slingshot = new Slingshot(towerPosition);
					while (budget < slingshot.cost) {
						System.out.println("no enough money");
						typeTower = new Scanner(System.in);
						inputThree = typeTower.nextDouble();
					}
					budget -= slingshot.cost;
					towers.add(slingshot);
				} else if (inputThree == 3) {
					Cannon cannon = new Cannon(towerPosition);
					while (budget < cannon.cost) {
						System.out.println("no enough money");
						typeTower = new Scanner(System.in);
						inputThree = typeTower.nextDouble();
					}
					budget -= cannon.cost;
					towers.add(cannon);
				} else if (inputThree == 4) {
				}
			} else if (inputOne.equals("N")) {

			}
			System.out.println("------------ROUND----------" + round);
			System.out.println('\n');
			// PICTURE
			ArrayList<String> towerLine = new ArrayList();
			for (int o = 0; o < corridorLength + 1; o++) {
				towerLine.add(" ");
			}
			for (int p = 0; p < towers.size(); p++) {
				towerLine.set(towers.get(p).position, towers.get(p).symbol);
			}
			for (int q = 0; q < towerLine.size(); q++) {
				System.out.print(towerLine.get(q));
			}
			System.out.println("|");

			// int spaceNum = corridorLength;
			// String[] corridorLength =
			// for (int i = 0; i < towers.size(); i++) {
			// Tower tower = towers.get(i);
			// int spaceNum =tower.position;
			//
			// }
			Random rand = new Random();
			int Num_Rat = rand.nextInt();
			Num_Rat = rand.nextInt(5);
			int Num_Elephant = rand.nextInt();
			Num_Elephant = rand.nextInt(2);
			for (int a = 0; a < Num_Rat; a++) {
				Rat rat = new Rat();
				enemies.add(rat);
			}
			for (int b = 0; b < Num_Elephant; b++) {
				Elephant elephant = new Elephant();
				enemies.add(elephant);
			}
			//
			ArrayList<String> enemyLine = new ArrayList();
			for (int o = 0; o < corridorLength + 1; o++) {
				enemyLine.add("-");
			}
			for (int p = 0; p < enemies.size(); p++) {
				enemyLine.set(enemies.get(p).position, "#");
			}
			for (int q = 0; q < enemyLine.size(); q++) {
				System.out.print(enemyLine.get(q));
			}
			System.out.println("|");
			//
			for (int i = 0; i < enemies.size(); i++) {
				Enemy enemy = enemies.get(i);
				enemy.advance();
				if (enemy.position >= corridorLength) {
					System.out.println("Defeat");
					System.exit(0);
				}
			}
			// TOWER ATTACK
			for (int w = 0; w < towers.size(); w++) {
				Tower tower = towers.get(w);
				if (tower.reloadTime != 1) {
					tower.reloadTime = tower.reloadTime - 1;
				} else if (tower.type == 3) {
					for (int i = 0; i < enemies.size(); i++) {
						Enemy enemy = enemies.get(i);
						if (enemy.health > 0 && enemy.position <= tower.position
								&& tower.position - enemy.position > 5) {
							enemies.get(i).hit(tower);
						}
					}
				} else {
					int proximate = 0;
					int aim = enemies.size() + 1;
					for (int i = 0; i < enemies.size(); i++) {
						Enemy enemy = enemies.get(i);
						if (enemy.health > 0 && enemy.position <= tower.position && enemy.position > proximate) {
							proximate = enemy.position;
							aim = i;
						}
					}
					enemies.get(aim).hit(tower);
					if (enemies.get(aim).health <= 0) {
						enemies.remove(aim);
						budget += enemies.get(aim).money;
						System.out.println("get " + enemies.get(aim).money + " coins");
					}

				}
			}
		}
		System.out.println("WARNING! DARGON IS COMING!");
		enemies.clear();
		Dragon dragon = new Dragon();
		enemies.add(dragon);
		while (enemies.size() != 0) {
			Enemy enemy = enemies.get(0);
			enemy.advance();
			ArrayList<String> enemyLine = new ArrayList();
			for (int o = 0; o < corridorLength + 1; o++) {
				enemyLine.add("-");
			}
			for (int p = 0; p < enemies.size(); p++) {
				enemyLine.set(enemies.get(p).position, "£");
			}
			for (int q = 0; q < enemyLine.size(); q++) {
				System.out.print(enemyLine.get(q));
			}
			System.out.println("|");
			if (enemy.position >= corridorLength) {
				System.out.println("Defeat");
				System.exit(0);
			}
			for (int j = 0; j < towers.size(); j++) {
				Tower towerfinal = towers.get(j);
				if (towerfinal.reloadTime != 1) {
					towerfinal.reloadTime = towerfinal.reloadTime - 1;
				} else {
					enemies.get(0).hit(towerfinal);
				}
			}
			if (enemies.get(0).health <= 0) {
				enemies.remove(0);
				System.out.println("Victory!");
			} else {
				System.out.println("dragon HP:" + enemies.get(0).health);
			}

		}
	}
}
// boolean reachTerminal;
//
// if (reachTerminal = true){
// System.out.println("Defeat!");
// break;}
//
// System.out.println("Victory!");
// }
// public Game(int corridorLength){
// }
//
// }
//
//
