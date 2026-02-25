import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Instruction1Test {

    @Test
    void IF_nIs10() {
        int[] expected = {1, 3, 5, 7, 9};
        assertArrayEquals(expected, Instruction1.generate(10));
    }

    @Test
    void if_NIs1() {
        int[] expected = {1};
        assertArrayEquals(expected, Instruction1.generate(1));
    }

    @Test
    void if_NIs0() {
        int[] expected = {};
        assertArrayEquals(expected, Instruction1.generate(0));
    }

    @Test
    void if_OddN() {
        int[] expected = {1, 3, 5};
        assertArrayEquals(expected, Instruction1.generate(5));
    }
}