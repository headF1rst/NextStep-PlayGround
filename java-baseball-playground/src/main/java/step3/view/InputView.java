package step3.view;

public class InputView {

    public void printGuide() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public void printWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
