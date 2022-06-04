package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

/**
 * Set Collection 대한 학습 테스트
 */
public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("크기 확인 테스트")
    @Test
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("값 존재여부 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("입력에 따라 true, false 반환 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsWithInput(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
