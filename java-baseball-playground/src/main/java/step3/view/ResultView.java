package step3.view;

import step3.Counter;

public class ResultView {

    private Counter counter;

    public ResultView(Counter counter) {
        this.counter = counter;
    }

    public void printCount() {
        if (counter.strikeAndBallCounted()) {
            System.out.println(counter.getBall() + "볼 " + counter.getStrike() + "스트라이크");
            return;
        }

        if (counter.strikeCounted()) {
            System.out.println(counter.getStrike() + "스트라이크");
            return;
        }

        if (counter.ballCounted()) {
            System.out.println(counter.getBall() + "볼");
            return;
        }
        System.out.println("낫싱");
    }
}
