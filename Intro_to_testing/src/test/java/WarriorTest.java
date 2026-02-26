import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WarriorTest {
    
    private Warrior warrior;
    
    @BeforeEach
    void setUp() {
        warrior = new Warrior(100, 25, 3, 50);
    }
    
    @Test
    void testConstructor() {
        assertEquals(100, warrior.getHealth());
        assertEquals(25, warrior.getStrength());
        assertEquals(3, warrior.getLives());
        assertEquals(50, warrior.getForce());
    }
    @Test
    void testGetForce() {
        assertEquals(50, warrior.getForce());
    }
    @Test
    void testSetForce() {
        warrior.setForce(75);
        assertEquals(75, warrior.getForce());
    }
    @Test
    void testConvertToElf() {
        Elf elf = warrior.convertToElf();
        assertNotNull(elf);
        assertEquals(warrior.getHealth(), elf.getHealth());
        assertEquals(warrior.getStrength(), elf.getStrength());
        assertEquals(warrior.getLives(), elf.getLives());
    }
    @Test
    void testConvertToElfUsesForceAsSpeed() {
        Elf elf = warrior.convertToElf();
        assertEquals(warrior.getForce(), elf.getSpeed());
    }
    @Test
    void testConvertToElfCreatesNewInstance() {
        Elf elf = warrior.convertToElf();
        assertNotSame(warrior, elf);
    }
    @Test
    void testWarriorAttack() {
        Warrior opponent = new Warrior(80, 15, 2, 30);
        int initialHealth = opponent.getHealth();
        warrior.attack(opponent);
        assertEquals(initialHealth - warrior.getStrength(), opponent.getHealth());
    }
    @Test
    void testWarriorDecrementLive() {
        warrior.setHealth(30);
        int initialLives = warrior.getLives();
        warrior.decrementLive();
        assertEquals(initialLives - 1, warrior.getLives());
        assertEquals(100, warrior.getHealth());
    }
}
