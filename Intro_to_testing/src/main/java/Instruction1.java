public class Instruction1 {

    public static int[] generate(int n) {

        if (n < 1) {
            return new int[0];
        }

        int size = (n + 1) / 2;
        int[] result = new int[size];

        int index = 0;
        for (int i = 1; i <= n; i += 2) {
            result[index++] = i;
        }

        return result;
    }
}