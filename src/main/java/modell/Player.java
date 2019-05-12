package modell;

import dao.PlayerEntity;
import dao.PlayerEntityDAOImpl;
/**
 * The Player class represents the player in the game.
 */
public class Player {
    /**
     * Player's name.
     */
    private String name;
    /**
     * Player's dmg value.
     */
    private int dmg;
    /**
     * Player's money.
     */
    private int money;
    /**
     * Player's lvl.
     */
    private int lvl;
    /**
     * AI dmg who help the player.
     */
    private int aiDmg;
    /**
     * Ai's critical chance.
     */
    private int critical;
    /**
     * Ai's critical damage multipler.
     */
    private int criticalDmg;
    /**
     * Player's reset count.
     */
    private int resetCount;



    /**
     * The constructor of the Player class.
     */
    public Player() { }

    /**
     * The constructor of the Player class with a name string input.
     * @param name of settings
     */
    public Player(String name) {

        PlayerEntityDAOImpl playerEntityDAO =
                PlayerEntityDAOImpl.getPlayerEntityDAOImpl();

        PlayerEntity playerEntity = playerEntityDAO.findPlayerByName(name);

        this.name = playerEntity.getName();
        this.dmg = playerEntity.getDmg();
        this.money = playerEntity.getMoney();
        this.lvl = playerEntity.getLvl();
        this.aiDmg = playerEntity.getAiDmg();
        this.critical = playerEntity.getCritical();
        this.criticalDmg = playerEntity.getCriticalDmg();
        this.resetCount = playerEntity.getResetCount();
    }
    /**
     * Save nethod to save player's data.
     */
    public void save () {

        PlayerEntityDAOImpl playerEntityDAO = PlayerEntityDAOImpl.getPlayerEntityDAOImpl();

        PlayerEntity playerEntity = playerEntityDAO.findPlayerByName(name);

        playerEntity.setName(this.name);
        playerEntity.setDmg(this.dmg);
        playerEntity.setMoney(this.money);
        playerEntity.setLvl(this.lvl);
        playerEntity.setAiDmg(this.aiDmg);
        playerEntity.setCritical(this.critical);
        playerEntity.setCriticalDmg(this.criticalDmg);
        playerEntity.setResetCount(this.resetCount);

        playerEntityDAO.save(playerEntity);

    }

    /**
     * Critical plus method to plus the player's critical
     * @param critChanceGoldAmount of settings
     */
    public void critPlus(double critChanceGoldAmount) {
        if((int)(getCritical()*critChanceGoldAmount) <= getMoney()){
            setMoney((getMoney()-(int)(getCritical()*critChanceGoldAmount)));

            setCritical(getCritical()+1);
        }
    }
    /**
     * Critical Damage plus method to plus player's critical damage
     */
    public void critDmgPlus(double critDmgGoldAmount)
    {
        if((int)(getCriticalDmg()*critDmgGoldAmount) <= getMoney()){
            setMoney((getMoney()-(int)(getCriticalDmg()*critDmgGoldAmount)));
            setCriticalDmg(getCriticalDmg()+1);

        }
    }
    /**
     * Ai damage plus method to plus the player's ai damage
     */
    public void aiDmgPlus(double aiDmgGoldAmount)
    {
        if((int)(getAiDmg()*aiDmgGoldAmount) <= getMoney()){
            setMoney((getMoney()-(int)(getAiDmg()*aiDmgGoldAmount)));
            setAiDmg(getAiDmg()+1);
        }
    }
    /**
     * Stat reset count method to reset the player's stat and give the players some boost.
     */
    public void statReset()
    {
        if((getResetCount()*100000+100000) <= getMoney()){
            setResetCount(getResetCount()+1);
            setMoney(0);
            setCriticalDmg(2);
            setCritical(8);
            setLvl(1);
            setDmg(16);
            setAiDmg(20);


        }
    }
    /**
     * Damage plus method to plus Player's Damage.
     */
    public void dmgPlus(double dmgGoldAmount)
    {
        if ((int) (getDmg() * dmgGoldAmount) <= getMoney()) {
            setMoney((getMoney() - (int) (getDmg() * dmgGoldAmount)));

            setDmg(getDmg() + 1);
        }
    }

    /**
     * Method to get back the player's name.
     * @return string of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name.
     * @param name string of settings
     */
    public void setName(String name) { this.name = name; }
    /**
     * Method to get back the player's damage.
     * @return number of damage
     */
    public int getDmg() { return dmg; }

    /**
     * Setter method for damage
     * @param dmg
     */
    public void setDmg(int dmg) { this.dmg = dmg; }
    /**
     * Method to get back the player's Money.
     * @return number of money
     */
    public int getMoney() { return money; }

    /**
     * Setter method for money
     * @param money
     */
    public void setMoney(int money) { this.money = money; }
    /**
     * Method to get back the player's lvl.
     * @return number of lvl
     */
    public int getLvl() { return lvl; }

    /**
     * Setter method for lvl.
     * @param lvl
     */
    public void setLvl(int lvl) { this.lvl = lvl; }
    /**
     * Method to get back the player's Ai Damage.
     * @return number of Ai Damage
     */
    public int getAiDmg() { return aiDmg; }

    /**
     * Setter method for Ai Damage.
     * @param aiDmg
     */
    public void setAiDmg(int aiDmg) { this.aiDmg = aiDmg; }
    /**
     * Method to get back the player's Critical chance.
     * @return number of Critical chance.
     */
    public int getCritical() { return critical; }

    /**
     * Setter method for Critical Chance
     * @param critical
     */
    public void setCritical(int critical) { this.critical = critical; }
    /**
     * Method to get back the player's Critical Damage.
     * @return number of Critical Damage
     */
    public int getCriticalDmg() { return criticalDmg; }

    /**
     * Setter method for Critical Damage
     * @param criticalDmg
     */
    public void setCriticalDmg(int criticalDmg) { this.criticalDmg = criticalDmg; }
    /**
     * Method to get back the player's Reset Count.
     * @return number of Reset Count
     */
    public int getResetCount() { return resetCount; }

    /**
     * Setter method for Reset Count.
     * @param resetCount
     */
    public void setResetCount(int resetCount) { this.resetCount = resetCount; }
}
