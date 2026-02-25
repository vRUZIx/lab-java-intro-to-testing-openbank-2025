import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class Java_keywordsTest {

    private Java_keywords testSentence;

    @BeforeEach
    public void setUp() {
        testSentence = new Java_keywords();
    }

    @Test
    void ReturnTrue_SentenceContainsKeyword() {
        boolean result = testSentence.Java_Keywords("Don't break the door");
        assertTrue(result);
    }
    @Test
    void ReturnFalse_SentenceHasNoKeyword() {
        boolean result = testSentence.Java_Keywords("Hello world");
        assertFalse(result);
    }

    @Test
    void ReturnFalse_SentenceIsEmpty() {
        boolean result = testSentence.Java_Keywords("");
        assertFalse(result);
    }
    @Test
    void shouldDetectMultipleKeywords() {
        boolean result = testSentence.Java_Keywords("public static void main");
        assertTrue(result);
    }
}