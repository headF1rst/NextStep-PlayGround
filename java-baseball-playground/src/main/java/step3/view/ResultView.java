package step3.view;

public class ResultView {

    private int strike;
    private int ball;

    public void printCount() {
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return;
        }

        if (strike != 0) {
            System.out.println(strike + "스트라이크");
            return;
        }

        if (ball != 0) {
            System.out.println(ball + "볼");
            return;
        }
        System.out.println("낫싱");
    }
}
