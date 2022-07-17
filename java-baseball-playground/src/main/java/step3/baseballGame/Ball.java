package step3.baseballGame;

import java.util.HashMap;
import java.util.Map;

public class Ball {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final Map<Integer, Ball> CACHE = new HashMap<>();
    private final int number;

    private Ball(int number) {
        this.number = number;
    }
    public static Ball valueOf(int number) {
        validateBallNumberRange(number);
        return CACHE.computeIfAbsent(number, Ball::new);
    }

    private static void validateBallNumberRange(int number) {
        if (MIN_NUMBER > number || number > MAX_NUMBER) {
            throw new IllegalArgumentException("1 ~ 9 안의 값이어야 합니다.");
        }
    }
}
