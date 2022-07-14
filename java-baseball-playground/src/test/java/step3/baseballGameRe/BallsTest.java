package step3.baseballGameRe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallsTest {

    @DisplayName("볼인지 확인하는 테스트")
    @Test
    void ball() {
        BaseBallGameMachine baseBallGameMachine = new BaseBallGameMachine();
        BallStatus status = baseBallGameMachine.play(Ball.valueOf(1));
        assertEquals(status, BallStatus.BALL);
    }
}
