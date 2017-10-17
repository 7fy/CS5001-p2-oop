public class Enemy  {
    /**
     * @param enemyHp is the healthy point in a game
     * @param eposition is the current postion of the enemy
     * */
    int eposition = 0;
    int enemyHp = 0;
    public Enemy(int enemyHp, int eposition) {
        this.enemyHp = enemyHp;
        this.eposition = eposition;
    }
    int getHealth () {
        return enemyHp;
    }
    int getPosition () {
        return eposition;
    }
    void hit (Tower t) {
    }
    void advance () {
    }
}
