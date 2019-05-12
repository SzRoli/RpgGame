package modell;

import modell.Enemy;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Test class for Enemy class.
 **/
public class EnemyTest {

    private Enemy enemy;

    /**
     * Sets up the test.
     **/
    @Before
    public void setUp() {
        enemy = new Enemy();
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

    @Test
    public void setMaxHp() {
        enemy.setMaxHp(10);
        assertEquals(10, enemy.getMaxHp());
    }


}