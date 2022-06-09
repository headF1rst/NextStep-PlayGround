package step2;

public class InputParser {

    private InputParser() {}

    static String[] parseInput(String input) {
        checkNullOrEmpty(input);
        String[] parsedInputs = input.split(Constant.FORMULA_SPLITTER);
        checkValidLength(parsedInputs);
        return parsedInputs;
    }

    static void checkNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 비어있습니다.");
        }
    }

    static void checkValidLength(String[] parsedInputs) {
        int parsedInputLength = parsedInputs.length;
        if (parsedInputLength < 3 || parsedInputLength % 2 == 0) {
            throw new IllegalArgumentException("올바른 식이 아닙니다.");
        }
    }

}
