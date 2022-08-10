package step3;

import java.util.HashMap;
import java.util.Map;

public class Baseball {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final Map<Integer, Baseball> CACHE = new HashMap<>();
    private final int number;

    private Baseball(int number) {
        this.number = number;
    }
    public static Baseball valueOf(int number) {
        validateBallNumberRange(number);
        return CACHE.computeIfAbsent(number, Baseball::new);
    }

    private static void validateBallNumberRange(int number) {
        if (MIN_NUMBER > number || number > MAX_NUMBER) {
            throw new IllegalArgumentException("1 ~ 9 안의 값이어야 합니다.");
        }
    }
}
