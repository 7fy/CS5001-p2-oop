import java.util.ArrayList;
import static java.lang.System.exit;

public class Game {
    ArrayList<Enemy> enemies;
    ArrayList<Tower> towers;
    public static void main (String[] args) {
        try {
            int corridorLength = Integer.parseInt(args[1]);
            if (corridorLength <1) {
                System.out.println ("The corridorLength should be longer than 1 position");
                exit(0);
            } else {
                Game game = new Game (corridorLength);
                game.advance();
                System.out.println ("Ready? Go!");
            }
        } catch (Exception e) {
            System.out.println ("Usage: java Game <CorridorLength>");
        }
    }
    public Game (int corridorLength) {
        int timestrap = 0;
    }
    public void advance () {
        int round = 1;
        for (;;){
            System.out.println ("Round: " + round);
        }
    }
}
