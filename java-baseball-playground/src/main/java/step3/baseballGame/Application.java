package step3.baseballGame;

import step3.baseballGame.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        startBaseballGame(inputView);
        scanner.close();
    }

    private static void startBaseballGame(InputView inputView) {
        OppositePlayer oppositePlayer = new OppositePlayer();

    }
}
