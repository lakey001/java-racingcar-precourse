package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @Test
    void 전진_테스트(){
        RacingCar racingCar = new RacingCar("test");
        racingCar.move(4);
        racingCar.move(9);
        Assertions.assertThat(racingCar.getPosition()).isEqualTo(2);
    }

    @Test
    void 정지_테스트(){
        RacingCar racingCar = new RacingCar("test");
        racingCar.move(0);
        racingCar.move(3);
        Assertions.assertThat(racingCar.getPosition()).isEqualTo(0);
    }
}
