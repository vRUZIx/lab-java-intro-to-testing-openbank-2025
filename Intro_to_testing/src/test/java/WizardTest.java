import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class WizardTest {
    
    private Wizard wizard;
    
    @Mock
    private SpellLibrary mockSpellLibrary;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        wizard = new Wizard(95, 20, 3, 100);
    }
    
    @Test
    void testConstructor() {
        assertEquals(95, wizard.getHealth());
        assertEquals(20, wizard.getStrength());
        assertEquals(3, wizard.getLives());
        assertEquals(100, wizard.getSpell());
    }
    @Test
    void testConstructorWithSpellLibrary() {
        Wizard wizardWithLibrary = new Wizard(95, 20, 3, 100, mockSpellLibrary);
        assertNotNull(wizardWithLibrary);
        assertEquals(95, wizardWithLibrary.getHealth());
    }
    @Test
    void testGetSpell() {
        assertEquals(100, wizard.getSpell());
    }
    @Test
    void testSetSpell() {
        wizard.setSpell(150);
        assertEquals(150, wizard.getSpell());
    }
    @Test
    void testSetSpellLibrary() {
        wizard.setSpellLibrary(mockSpellLibrary);
        assertNotNull(wizard);
    }
    @Test
    void testConvertToElf() {
        Elf elf = wizard.convertToElf();
        assertNotNull(elf);
        assertEquals(wizard.getHealth(), elf.getHealth());
        assertEquals(wizard.getStrength(), elf.getStrength());
        assertEquals(wizard.getLives(), elf.getLives());
    }
    
    @Test
    void testConvertToElfUsesSpellAsSpeed() {
        Elf elf = wizard.convertToElf();
        assertEquals(wizard.getSpell(), elf.getSpeed());
    }
    @Test
    void testConvertToElfCreatesNewInstance() {
        Elf elf = wizard.convertToElf();
        assertNotSame(wizard, elf);
    }
    @Test
    void testWizardAttack() {
        Wizard opponent = new Wizard(80, 15, 2, 80);
        int initialHealth = opponent.getHealth();
        wizard.attack(opponent);
        assertEquals(initialHealth - wizard.getStrength(), opponent.getHealth());
    }
    @Test
    void testWizardDecrementLive() {
        wizard.setHealth(30);
        int initialLives = wizard.getLives();
        wizard.decrementLive();
        assertEquals(initialLives - 1, wizard.getLives());
        assertEquals(95, wizard.getHealth());
    }
    @Test
    void testCastRandomSpellCallsSpellLibrary() {
        wizard.setSpellLibrary(mockSpellLibrary);
        when(mockSpellLibrary.getRandomSpell()).thenReturn("Fireball");
        wizard.castRandomSpell();
        verify(mockSpellLibrary, times(1)).getRandomSpell();
    }
    @Test
    void testCastRandomSpellReturnsCorrectFormat() {
        wizard.setSpellLibrary(mockSpellLibrary);
        when(mockSpellLibrary.getRandomSpell()).thenReturn("Fireball");
        String result = wizard.castRandomSpell();
        assertEquals("Casting Fireball", result);
    }
    @Test
    void testCastRandomSpellCallsGetRandomSpellExactlyOnce() {
        wizard.setSpellLibrary(mockSpellLibrary);
        when(mockSpellLibrary.getRandomSpell()).thenReturn("Lightning");
        wizard.castRandomSpell();
        verify(mockSpellLibrary, times(1)).getRandomSpell();
    }
    @Test
    void testCastRandomSpellWithDifferentSpells() {
        wizard.setSpellLibrary(mockSpellLibrary);
        when(mockSpellLibrary.getRandomSpell()).thenReturn("Blizzard");
        String result1 = wizard.castRandomSpell();
        assertEquals("Casting Blizzard", result1);
        when(mockSpellLibrary.getRandomSpell()).thenReturn("Thunderbolt");
        String result2 = wizard.castRandomSpell();
        assertEquals("Casting Thunderbolt", result2);
        verify(mockSpellLibrary, times(2)).getRandomSpell();
    }
    @Test
    void testCastRandomSpellWithEmptyString() {
        wizard.setSpellLibrary(mockSpellLibrary);
        when(mockSpellLibrary.getRandomSpell()).thenReturn("");
        String result = wizard.castRandomSpell();
        assertEquals("Casting ", result);
    }
}
