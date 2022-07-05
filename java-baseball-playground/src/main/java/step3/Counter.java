package step3;

public class Counter {

    private int strike;
    private int ball;

    private Counter(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Counter of(int strike, int ball) {
        return new Counter(strike, ball);
    }

    public void countStrike() {
        this.strike += 1;
    }

    public void countBall() {
        this.ball += 1;
    }
    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean strikeCounted() {
        return strike != 0;
    }

    public boolean ballCounted() {
        return ball != 0;
    }

    public boolean strikeAndBallCounted() {
        return ball != 0 && strike != 0;
    }
}
