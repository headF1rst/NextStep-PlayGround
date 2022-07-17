package step3.baseballGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BallsTest {

    @DisplayName("Balls 객체를 생성하면, 중복되지 않은 3개의 랜덤 숫자가 뽑혀야 한다.")
    @Test
    public void pickRandomBallNumber() {
        Balls balls = Balls.generateRandomBalls();
        int strikeCounts = balls.findStrikeCounts(balls);
        assertThat(strikeCounts).isEqualTo(3);
    }


}
