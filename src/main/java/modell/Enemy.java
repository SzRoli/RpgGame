package modell;

/**
 * The Enemy class represents the enemy in the game.
 */
public class Enemy {
    /**
     * Enemy's current hp value.
     */
    private int hp;
    /**
     * Enemy's max hp value.
     */
    private int maxHp;
    /**
     * Enemy's lvl.
     */
    private int lvl;
    /**
     * This value is what you will get if you kill them.
     */
    private int gold;

    /**
     * The constructor of the Enemy class.
     */
    public Enemy() { }

    /**
     * Method to get back the enemy's lvl.
     * @return a number of lvl
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * Setter method for lvl.
     * @param lvl value of setting.
     */
    public void setLvl(  int lvl) { this.lvl = lvl; }

    /**
     * Method to get back the gold value what you will get.
     * @return a number of gold.
     */
    public int getGold() {
        return gold;
    }

    /**
     * Setter method for gold amount.
     * @param gold amount of setting.
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * Method to get back enemy's max hp.
     * @return a number of enemy's max hp.
     */
    public int getMaxHp() {
        return maxHp;
    }

    /**
     * Setter method for maxHp value.
     * @param maxHp value of setting.
     */
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    /**
     * Method to get back enemy's hp.
     * @return a number of hp.
     */
    public int getHp() {
        return hp;
    }

    /**
     * Setter method for hp value.
     * @param hp value of setting.
     */
    public void setHp(int hp) {
        this.hp = hp;
    }


}
