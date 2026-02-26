import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElfTest {
    
    private Elf elf;
    
    @BeforeEach
    void setUp() {
        elf = new Elf(90, 18, 4, 40);
    }
    
    @Test
    void testConstructor() {
        assertEquals(90, elf.getHealth());
        assertEquals(18, elf.getStrength());
        assertEquals(4, elf.getLives());
        assertEquals(40, elf.getSpeed());
    }
    
    @Test
    void testGetSpeed() {
        assertEquals(40, elf.getSpeed());
    }
    
    @Test
    void testSetSpeed() {
        elf.setSpeed(60);
        assertEquals(60, elf.getSpeed());
    }
    
    @Test
    void testGetHealth() {
        assertEquals(90, elf.getHealth());
    }
    
    @Test
    void testSetHealth() {
        elf.setHealth(70);
        assertEquals(70, elf.getHealth());
    }
    
    @Test
    void testGetStrength() {
        assertEquals(18, elf.getStrength());
    }
    
    @Test
    void testSetStrength() {
        elf.setStrength(22);
        assertEquals(22, elf.getStrength());
    }
    
    @Test
    void testGetLives() {
        assertEquals(4, elf.getLives());
    }
    
    @Test
    void testSetLives() {
        elf.setLives(5);
        assertEquals(5, elf.getLives());
    }
    
    @Test
    void testElfAttack() {
        Elf opponent = new Elf(80, 15, 2, 30);
        int initialHealth = opponent.getHealth();
        
        elf.attack(opponent);
        
        assertEquals(initialHealth - elf.getStrength(), opponent.getHealth());
    }
    
    @Test
    void testElfDecrementLive() {
        elf.setHealth(30);
        int initialLives = elf.getLives();
        
        elf.decrementLive();
        
        assertEquals(initialLives - 1, elf.getLives());
        assertEquals(90, elf.getHealth());
    }
    
    @Test
    void testElfCheckHealth() {
        int initialLives = elf.getLives();
        elf.setHealth(-5);
        elf.checkHealth();
        
        assertEquals(initialLives - 1, elf.getLives());
    }
}
