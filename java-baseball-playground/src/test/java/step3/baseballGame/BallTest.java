package step3.baseballGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BallTest {

    @DisplayName("1 ~ 9 범위의 값에서만 Ball 객체가 생성 성공")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 9})
    public void successBallNumber(int input) {
        assertThatCode(() -> {
            Ball.valueOf(input);
        }).doesNotThrowAnyException();
    }

    @DisplayName("1 ~ 9범위 밖의 값이면 Ball 객체 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    void outOfRangeBallNumber(int input) {
        assertThatThrownBy(() ->
                Ball.valueOf(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 ~ 9 안의 값이어야 합니다.");
    }
}
