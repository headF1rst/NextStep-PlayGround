package step3.baseballGame;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {

    private static final int NECESSARY_BALL_NUMBER_COUNT = 3;
    private static final int FIRST_BALL_INDEX = 0;
    private static final int LAST_BALL_INDEX = 2;
    private final List<Ball> balls;
    Balls(List<Ball> balls) {
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
        return randomNumbers.size() == NECESSARY_BALL_NUMBER_COUNT;
    }

    public int findStrikeCounts(Balls balls) {
        return (int) IntStream.rangeClosed(FIRST_BALL_INDEX, LAST_BALL_INDEX)
                .filter(index -> isStrike(index, balls))
                .count();
    }

    private boolean isStrike(int index, Balls targetBalls) {
        Ball ball = this.balls.get(index);
        Ball targetBall = targetBalls.balls.get(index);
        return ball.equals(targetBall);
    }
}
