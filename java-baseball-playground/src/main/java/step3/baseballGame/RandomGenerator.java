package step3.baseballGame;

import java.util.Random;

public class RandomGenerator {

    private Random random;
    private static final int MAX_BOUND = 9;

    public RandomGenerator(Random random) {
        this.random = random;
    }

    public int getRandomInteger() {
        return random.nextInt(MAX_BOUND) + 1;
    }
}
