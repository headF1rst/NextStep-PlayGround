package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class BaseballsTest {

    private static Stream<Arguments> getCorrectBaseballInput() {
        return Stream.of(Arguments.of(Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(3, 6, 9)),
                Arguments.of(Arrays.asList(6, 7, 1)));
    }

    private static Stream<Arguments> getDuplicatedBaseballInput() {
        return Stream.of(Arguments.of(Arrays.asList(7, 7, 1)),
                Arguments.of(Arrays.asList(7, 7, 7)));
    }

    private static Stream<Arguments> getOutOfRangeBaseballInput() {
        return Stream.of(Arguments.of(Arrays.asList(0, 1, 2)),
                Arguments.of(Arrays.asList(1, 1, 10)),
                Arguments.of(Arrays.asList(-1, 0, 0)));
    }

    private static Stream<Arguments> getCaseOfStrike() {
        return Stream.of(Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList()));
    }

    @DisplayName("Balls 객체를 생성하면, 중복되지 않은 3개의 랜덤 숫자가 뽑힘.")
    @Test
    public void pickRandomBallNumber() {
        Baseballs balls = Baseballs.generateRandomBaseballs();
        int strikeCounts = balls.findStrikeCounts(balls);
        assertThat(strikeCounts).isEqualTo(3);
    }

    @DisplayName("사용자가 3자리 숫자를 입력하면 Balls 객체를 정상적으로 수동 생성")
    @ParameterizedTest
    @MethodSource("getCorrectBaseballInput")
    public void createBallsByInput(List<Integer> input) {
        Baseballs balls = Baseballs.generateBallsByInput(input);
        Baseballs sameBalls = Baseballs.generateBallsByInput(input);
        int strikeCounts = balls.findStrikeCounts(sameBalls);
        assertThat(strikeCounts).isEqualTo(3);
    }
}
