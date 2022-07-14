package step3.baseballGameRe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BallsTest {

    @DisplayName("볼인지 확인하는 테스트")
    @Test
    void ball() {
        BaseBallGameMachine baseBallGameMachine = new BaseBallGameMachine();
        Balls balls = Balls.generateRandomBalls();
        BallStatus status = baseBallGameMachine.play(Ball.valueOf(1));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @DisplayName("1 ~ 9범위 밖의 공 숫자가 주어졌을때 예외발생 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    void outOfRangeBallNumber(int input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Ball.valueOf(input));
        assertThat("1 ~ 9 안의 값이어야 합니다.").isEqualTo(exception.getMessage());
    }
}
