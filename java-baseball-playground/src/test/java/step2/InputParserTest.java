package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class InputParserTest {

    @DisplayName("input이 Null 혹은 Empty면 IllegalArgumentException 발생 여부 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void checkExceptionWhenInputIsNullOrEmpty(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    InputParser.checkNullOrEmpty(input);
                });
    }

    @DisplayName("올바른 연산식이 입력되었는지 IllegalArgumentException 발생 여부 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 + 3 +", "1 * + 2", "1", "1 -"})
    void checkExceptionForInvalidInput(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    String[] parsedInputs = input.split(Constant.FORMULA_SPLITTER);
                    InputParser.checkValidLength(parsedInputs);
                });
    }

    @DisplayName("input이 InputParser를 통해서 공백 기준으로 split 되는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 + 3", "1 * 2 - 3", "1 / 2 * 3 + 1"})
    void checkInputParserCanSplit(String input) {
        assertThat(Arrays.deepEquals(input.split(Constant.FORMULA_SPLITTER),
                InputParser.parseInput(input)))
                .isTrue();
    }
}
