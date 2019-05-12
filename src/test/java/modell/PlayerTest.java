package modell;

import dao.PlayerEntity;
import dao.PlayerEntityDAOImpl;
import modell.Enemy;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import static org.junit.Assert.*;

public class PlayerTest {
    Player player;
    @Before
    public void setUp() throws Exception {
        player = new Player();
    }

    @Test
    public void critPlus() {
        player.setMoney(1000);
        player.setCritical(10);
        player.critPlus(5);
        assertEquals(11,player.getCritical());

        player.setMoney(0);
        player.setCritical(10);
        player.critPlus(5);
        assertEquals(10,player.getCritical());
    }

    @Test
    public void critDmgPlus() {
        player.setMoney(1000);
        player.setCriticalDmg(10);
        player.critDmgPlus(5);
        assertEquals(11,player.getCriticalDmg());

        player.setMoney(0);
        player.setCriticalDmg(10);
        player.critDmgPlus(5);
        assertEquals(10,player.getCriticalDmg());
    }

    @Test
    public void aiDmgPlus() {
        player.setMoney(1000);
        player.setAiDmg(10);
        player.aiDmgPlus(5);
        assertEquals(11,player.getAiDmg());

        player.setMoney(0);
        player.setAiDmg(10);
        player.aiDmgPlus(5);
        assertEquals(10,player.getAiDmg());
    }

    @Test
    public void dmgPlus() {
        player.setMoney(1000);
        player.setDmg(10);
        player.dmgPlus(5);
        assertEquals(11,player.getDmg());

        player.setMoney(0);
        player.setDmg(10);
        player.dmgPlus(5);
        assertEquals(10,player.getDmg());
    }



    @Test
    public void statReset() {
        player.setMoney(100000);
        player.setResetCount(0);
        player.statReset();
        assertEquals(1,player.getResetCount());
        assertEquals(0,player.getMoney());
        assertEquals(2,player.getCriticalDmg());
        assertEquals(8,player.getCritical());
        assertEquals(16,player.getDmg());
        assertEquals(1,player.getLvl());
        assertEquals(20,player.getAiDmg());

    }


    @Test
    public void gettersTest() {
        player.setMoney(10);
        assertEquals(10, player.getMoney());
        player.setLvl(20);
        assertEquals(20, player.getLvl());
        player.setCriticalDmg(20);
        assertEquals(20, player.getCriticalDmg());
        player.setCritical(20);
        assertEquals(20, player.getCritical());
        player.setAiDmg(20);
        assertEquals(20, player.getAiDmg());
        player.setDmg(20);
        assertEquals(20, player.getDmg());
        player.setResetCount(20);
        assertEquals(20, player.getResetCount());
        player.setName("Roland");
        assertEquals("Roland", player.getName());

    }
    @Test
    public void PlayerTest(){
       /* Player player = new Player("Roland");


        assertEquals("Roland", player.getName());
        assertEquals( 20,player.getDmg());
        assertEquals(2, player.getMoney());*/

    }
    @Test
    public void save(){

       /* PlayerEntity playerEntity = new PlayerEntity();
        PlayerEntityDAOImpl playerEntityDAO = PlayerEntityDAOImpl.getPlayerEntityDAOImpl();


        String name = "Test";
        player.setMoney(20);
        player.setLvl(20);
        player.setCriticalDmg(20);
        player.setCritical(20);
        player.setAiDmg(20);
        player.setDmg(20);
        player.setResetCount(20);
        player.setName(name);


        player.save();

        playerEntity = playerEntityDAO.findPlayerByName(name);



        assertEquals("Test", playerEntity.getName());
        assertEquals("20", playerEntity.getAiDmg());*/

    }
}