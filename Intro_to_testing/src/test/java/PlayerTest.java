import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class PlayerTest {
    private Warrior player1;
    private Warrior player2;
    @BeforeEach
    void setUp() {
        player1 = new Warrior(100, 20, 3, 10);
        player2 = new Warrior(80, 15, 2, 5);
    }
    @Test
    void testConstructor() {
        assertEquals(100, player1.getHealth());
        assertEquals(20, player1.getStrength());
        assertEquals(3, player1.getLives());
    }
    @Test
    void testGetHealth() {
        assertEquals(100, player1.getHealth());
    }
    @Test
    void testSetHealth() {
        player1.setHealth(50);
        assertEquals(50, player1.getHealth());
    }
    @Test
    void testGetStrength() {
        assertEquals(20, player1.getStrength());
    }
    @Test
    void testSetStrength() {
        player1.setStrength(30);
        assertEquals(30, player1.getStrength());
    }
    @Test
    void testGetLives() {
        assertEquals(3, player1.getLives());
    }
    @Test
    void testSetLives() {
        player1.setLives(5);
        assertEquals(5, player1.getLives());
    }
    @Test
    void testDecrementLive() {
        player1.setHealth(30);
        player1.decrementLive();
        assertEquals(2, player1.getLives());
        assertEquals(100, player1.getHealth());
    }
    @Test
    void testDecrementLiveWhenDead() {
        player1.setLives(0);
        player1.decrementLive();
        
        assertEquals(0, player1.getLives());
    }
    @Test
    void testAttack() {
        int initialHealth = player2.getHealth();
        player1.attack(player2);
        assertEquals(initialHealth - player1.getStrength(), player2.getHealth());
    }
    @Test
    void testCheckHealthWhenDead() {
        int initialLives = player1.getLives();
        player1.setHealth(-10);
        player1.checkHealth();
        
        assertEquals(initialLives - 1, player1.getLives());
    }
    @Test
    void testCheckHealthWhenAlive() {
        int initialLives = player1.getLives();
        player1.setHealth(50);
        player1.checkHealth();
        
        assertEquals(initialLives, player1.getLives());
    }
    @Test
    void testCheckHealthWhenHealthIsZero() {
        int initialLives = player1.getLives();
        player1.setHealth(0);
        player1.checkHealth();
        
        assertEquals(initialLives - 1, player1.getLives());
    }
    @Test
    void testAttackTriggersCheckHealth() {
        player2.setHealth(10);
        int initialLives = player2.getLives();
        player1.attack(player2);
        assertTrue(player2.getHealth() < 0);
        assertEquals(initialLives - 1, player2.getLives());
    }
}
