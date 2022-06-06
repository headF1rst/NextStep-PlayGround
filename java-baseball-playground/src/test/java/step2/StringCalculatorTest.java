package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("사칙 연산 모두 포함한 문자열 계산 테스트")
    @ParameterizedTest
    @MethodSource("provideStringsForCalculate")
    void stringCalculateTest(String input, int output) {
        assertThat(stringCalculator.calculate(input)).isEqualTo(output);
    }

    private static Stream<Arguments> provideStringsForCalculate() {
        return Stream.of(
                Arguments.of("2 + 3 * 4 / 2", 10)
        );
    }

    @DisplayName("정수를 0으로 나누면 ArithmMeticException 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2 / 0", "0 / 0"})
    void divideByZeroTest() {
        assertThatExceptionOfType(ArithmeticException.class);
    }

    @DisplayName("올바르지 않은 input에 대한 calculate 메서드 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3 -- 2, 313, 1 ++ 2, 2 ** 2"})
    void wrongInputTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    stringCalculator.calculate(input);
                });
    }

}
