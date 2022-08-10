package step3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Baseballs {

    private static final int NECESSARY_BALL_NUMBER_COUNT = 3;
    private static final int FIRST_BALL_INDEX = 0;
    private static final int LAST_BALL_INDEX = 2;
    private final List<Baseball> baseballs;
    Baseballs(List<Baseball> baseballs) {
        this.baseballs = baseballs;
    }

    public static Baseballs generateRandomBaseballs() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (!pickedThreeBalls(randomNumbers)) {
            int randomNumber = RandomGenerator.generateNumber();
            randomNumbers.add(randomNumber);
        }
        List<Baseball> balls = randomNumbers.stream()
                .map(Baseball::valueOf)
                .collect(Collectors.toList());
        return new Baseballs(balls);
    }

    private static boolean pickedThreeBalls(Set<Integer> randomNumbers) {
        return randomNumbers.size() == NECESSARY_BALL_NUMBER_COUNT;
    }

    public static Baseballs generateBallsByInput(List<Integer> input) {
        validateDuplication(input);
        List<Baseball> balls = input.stream()
                .map(Baseball::valueOf)
                .collect(Collectors.toList());
        return new Baseballs(balls);
    }

    private static void validateDuplication(List<Integer> input) {
        int distinctCounts = (int) input.stream()
                .distinct()
                .count();
        if (distinctCounts != NECESSARY_BALL_NUMBER_COUNT) {
            throw new IllegalArgumentException("유효하지 않은 중복된 번호 개수입니다.");
        }
    }

    public int findStrikeCounts(Baseballs baseballs) {
        return (int) IntStream.rangeClosed(FIRST_BALL_INDEX, LAST_BALL_INDEX)
                .filter(index -> isStrike(index, baseballs))
                .count();
    }

    private boolean isStrike(int index, Baseballs targetBalls) {
        Baseball ball = this.baseballs.get(index);
        Baseball targetBall = targetBalls.baseballs.get(index);
        return ball.equals(targetBall);
    }
}
