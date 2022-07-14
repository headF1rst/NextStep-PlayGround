package step3.baseballGameRe;

import java.util.Random;

public class RandomGenerator {

    private static final Random random = new Random();
    private static final int MAX_BOUND = 9;

    public static int generateNumber() {
        return random.nextInt(MAX_BOUND) + 1;
    }
}
