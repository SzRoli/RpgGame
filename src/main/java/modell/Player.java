package modell;

import dao.PlayerEntity;
import dao.PlayerEntityDAOImpl;

public class Player {

    private String name;
    private int dmg;
    private int money;
    private int lvl;
    private int aiDmg;
    private int critical;
    private int criticalDmg;
    private int resetCount;




    public Player(){


    }

    public Player(String name){

        PlayerEntityDAOImpl playerEntityDAO = PlayerEntityDAOImpl.getPlayerEntityDAOImpl();

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

    public void save (){

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

    public void critPlus(double critChanceGoldAmount){
        if((int)(getCritical()*critChanceGoldAmount) <= getMoney()){
            setMoney((getMoney()-(int)(getCritical()*critChanceGoldAmount)));

            setCritical(getCritical()+1);
        }
    }

    public void critDmgPlus(double critDmgGoldAmount){
        if((int)(getCriticalDmg()*critDmgGoldAmount) <= getMoney()){
            setMoney((getMoney()-(int)(getCriticalDmg()*critDmgGoldAmount)));
            setCriticalDmg(getCriticalDmg()+1);

        }
    }

    public void aiDmgPlus(double aiDmgGoldAmount){
        if((int)(getAiDmg()*aiDmgGoldAmount) <= getMoney()){
            setMoney((getMoney()-(int)(getAiDmg()*aiDmgGoldAmount)));
            setAiDmg(getAiDmg()+1);
        }
    }

    public void statReset(){
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

    public void dmgPlus(double dmgGoldAmount) {
        if ((int) (getDmg() * dmgGoldAmount) <= getMoney()) {
            setMoney((getMoney() - (int) (getDmg() * dmgGoldAmount)));

            setDmg(getDmg() + 1);
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getAiDmg() {
        return aiDmg;
    }

    public void setAiDmg(int aiDmg) {
        this.aiDmg = aiDmg;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getCriticalDmg() {
        return criticalDmg;
    }

    public void setCriticalDmg(int criticalDmg) {
        this.criticalDmg = criticalDmg;
    }

    public int getResetCount() {
        return resetCount;
    }

    public void setResetCount(int resetCount) {
        this.resetCount = resetCount;
    }
}
