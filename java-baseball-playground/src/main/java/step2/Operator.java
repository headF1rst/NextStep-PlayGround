package step2;

import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", (firstNumber, secondNumber) -> firstNumber + secondNumber),
    MINUS("-", (firstNumber, secondNumber) -> firstNumber - secondNumber),
    MULTIPLY("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),
    DIVIDE("/", (firstNumber, secondNumber) -> firstNumber / secondNumber)
    ;

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operation;

    private static final Map<String, Operator> FIND_OPERATOR = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(operator -> operator.getSymbol(), operator -> operator)));

    public static Operator findOperator(String symbol) {
        return FIND_OPERATOR.get(symbol);
    }
    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public int operate(int firstNumber, int secondNumber) {
        return operation.apply(firstNumber, secondNumber);
    }

    public String getSymbol() {
        return symbol;
    }
}
