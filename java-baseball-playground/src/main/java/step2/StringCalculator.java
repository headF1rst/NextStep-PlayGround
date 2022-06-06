package step2;

public class StringCalculator {

    public int calculate(String input) {
        String[] parsedInputs = InputParser.parseInput(input);
        int result = Integer.parseInt(parsedInputs[0]);
        int length = parsedInputs.length;

        for (int i = 1; i < length; i += 2) {
            Operator operator = Operator.findOperator(parsedInputs[i]);
            int nextNumber = Integer.parseInt(parsedInputs[i + 1]);
            result = operator.operate(result, nextNumber);
        }
        return result;
    }
}
