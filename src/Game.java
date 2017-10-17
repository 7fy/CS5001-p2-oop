import java.util.ArrayList;

public class Game {
    public static void main (String[] args) {
        try {
            int corridorLength = Integer.parseInt(args[1]);
            if (corridorLength <1) {
                System.out.println ("The corridorLength should be longer than 1 position");
                exit(0);
            } else {
                Game game = new Game (corridorLength);
                game.createEnemy();
                game.createTower();
                game.advance();
                System.out.println ("Ready? Go!");
            }
        } catch {
            System.out.println ("Usage: java Game <CorridorLength>");
        }
    }
    public Game (int corridorLength) {
        this.corridorLength = corridorLength;
    }
    public void advance () {
        int round = 1;
        for (;;){
            System.out.println ("Round: " + round);
            attackEnemies();
            advanceEnemies();
        }
    }
    public void createEnemy () {
        ArrayList<Enemy> enemies;
        enemies.add( new Rat());
    }
    public void createTower () {
        ArrayList<Tower> towers;
        towers.add( new Slingshot());
    }
    public void attackEnemies () {
    }
    public void advanceEnemies () {
    }
}
