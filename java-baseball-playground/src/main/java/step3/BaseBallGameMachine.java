package step3;

public class BaseBallGameMachine {

    private final Baseballs baseballs;

    public BaseBallGameMachine(Baseballs baseballs) {
        this.baseballs = baseballs;
    }

    public BaseballStatus play(Baseball number) {
        return BaseballStatus.BALL;
    }
}
