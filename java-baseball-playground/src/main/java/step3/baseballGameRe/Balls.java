package step3.baseballGameRe;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Balls {

    private final List<Ball> balls;
    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls generateRandomBalls() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (!pickedThreeBalls(randomNumbers)) {
            int randomNumber = RandomGenerator.generateNumber();
            randomNumbers.add(randomNumber);
        }
        List<Ball> balls = randomNumbers.stream()
                .map(Ball::valueOf)
                .collect(Collectors.toList());
        return new Balls(balls);
    }

    private static boolean pickedThreeBalls(Set<Integer> randomNumbers) {
        return randomNumbers.size() == 3;
    }
}
