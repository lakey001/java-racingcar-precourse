package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarTest {
    @ParameterizedTest(name = "전진 테스트 : 입력값 = {0}, 결과 = {1}")
    @DisplayName("전진 테스트")
    @CsvSource(value = {"4:1", "9:1", "0:0", "3:0"}, delimiter = ':')
    void 전진_테스트(int value, int result){
        RacingCar racingCar = new RacingCar("test");
        racingCar.move(value);
        Assertions.assertThat(racingCar.getPosition()).isEqualTo(result);
    }
}
