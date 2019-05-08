package modell;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Player player;
    @BeforeEach
    public void setUp() throws Exception {
        player = new Player();
    }

    @AfterEach
    public void tearDown() throws Exception {
        player = null;
    }

    @Test
    public void save() {
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
    public void statReset() {
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
}