package modell;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
/**
 * Test class for Enemy class.
 **/
public class EnemyTest {

    Enemy enemy;
    /**
     *Sets up the test.
     **/
    @BeforeEach
    public void setUp() throws Exception {
        enemy = new Enemy();
    }
    /**
     *Clear the enemy class.
     **/
    @AfterEach
    public void tearDown() throws Exception {
        enemy = null;
    }
    /**
     * Test method for Enemy class's getters/setters.
     **/
    @Test
    public void gettersTest(){
        enemy.setMaxHp(10);
        assertEquals(10, enemy.getMaxHp());
        enemy.setLvl(20);
        assertEquals(20,enemy.getLvl());
        enemy.setHp(20);
        assertEquals(20,enemy.getHp());
        enemy.setGold(20);
        assertEquals(20,enemy.getGold());

    }
}