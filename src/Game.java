import java.util.ArrayList;
import static java.lang.System.exit;

public class Game {
    ArrayList<Enemy> enemies;
    ArrayList<Tower> towers;
    int EnemyMax = 10;
    int TowerMax = 10;
    int EnemyNum = 1;
    int TowerNum = 0;
    public static void main (String[] args) {
        try {
            int corridorLength = Integer.parseInt(args[0]);
            if (corridorLength <1) {
                System.out.println ("The corridorLength should be longer than 1 position");
                exit(0);
            } else {
                Game game = new Game (corridorLength);
                game.advance();
            }
        } catch (Exception e) {
            System.out.println ("Usage: java Game <CorridorLength>");
            e.printStackTrace();
        }
    }
    public Game (int corridorLength) {
        System.out.println ("Ready? Go!");
        for (int i = 0; i < corridorLength; i++) {
            System.out.print("*");
        }
        System.out.println ("");
    }
    public void advance () {
        int round = 1;
        for (;;) {
            System.out.println ("Round: " + round);
            Enemy e1 = new Enemy(10,10);
            
       }
    }
    public void attackEnemy () {
    }
}
