package step3;

import java.util.Random;

public class RandomGenerator {

    private Random random = new Random();
    private static final int MAX_BOUND = 9;

    public int getRandomInteger() {
        return random.nextInt(MAX_BOUND) + 1;
    }
}
