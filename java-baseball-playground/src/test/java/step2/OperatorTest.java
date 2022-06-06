package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class OperatorTest {

    @DisplayName("올바른 사칙연산자의 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"+ : +", "- : -", "* : *", "/ : /"}, delimiter = ':')
    void correctOperators(String input, String output) {
        assertThat(Operator.findOperator(input).getSymbol()).isEqualTo(output);
    }

    @DisplayName("잘못된 사칙연산자의 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"++", "--", "1", "$!"})
    void inCorrectOperators(String input) {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> {
                    Operator.findOperator(input).getSymbol();
                });
    }
}
