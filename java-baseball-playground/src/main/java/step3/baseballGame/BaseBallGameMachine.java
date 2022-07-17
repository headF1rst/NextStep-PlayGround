package step3.baseballGame;

public class BaseBallGameMachine {

    private final Balls balls;

    public BaseBallGameMachine(Balls balls) {
        this.balls = balls;
    }

    public BallStatus play(Ball number) {
        return BallStatus.BALL;
    }
}
