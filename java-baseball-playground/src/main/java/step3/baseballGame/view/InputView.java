package step3.baseballGame.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Integer> inputBaseballNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        String inputNumbers = scanner.nextLine();
        while (!isValidInputNumbers(inputNumbers)) {
            inputNumbers = scanner.nextLine();
        }
        return Arrays.stream(inputNumbers.split("")).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean isValidInputNumbers(String inputNumbers) {
        try {
            validateInputNumbers(inputNumbers);
            return true;
        } catch (IllegalArgumentException err) {
            System.out.print("숫자를 다시 입력해 주세요.");
            return false;
        }
    }

    private void validateInputNumbers(String inputNumbers) {
        if (inputNumbers.length() != 3) {
            throw new IllegalArgumentException();
        }
        boolean isDuplicated = inputNumbers.chars()
                .filter(numb -> '1' <= numb && numb <= '9')
                .distinct()
                .count() != 3;
        if (isDuplicated) {
            throw new IllegalArgumentException();
        }
    }

    public void printWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
