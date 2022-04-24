package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.constant.ErrorMessageConst;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingCarsTest {
    RacingCars cars;

    @BeforeEach
    void initialize(){
        String[] carNames = {"car1","car2","car3"};
        cars = new RacingCars(carNames);
    }

    @Test
    @DisplayName("RacingCars 초기화 테스트: 기본")
    void 초기화_테스트(){
        assertThat(cars.getRacingCars()).hasSize(3);
    }

    @Test
    @DisplayName("RacingCars 초기화 테스트: 차이름 5자 초과로 오류 발생")
    void 초기화_테스트_오류발생_5자초과(){
        assertThatIllegalArgumentException().isThrownBy(
                ()->{
                    String[] carNames = {"car1","car2","car333"};
                    RacingCars invalidCars = new RacingCars(carNames);
                }).withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_CAR_NAME_LENGTH_FORMAT, 1, 5));
    }

    @Test
    @DisplayName("RacingCars 초기화 테스트: 차이름 1자 미만으로 오류 발생")
    void 초기화_테스트_오류발생_1자미만(){
        assertThatIllegalArgumentException().isThrownBy(
                ()->{
                    String[] carNames = {"car1","car2","car333"};
                    RacingCars invalidCars = new RacingCars(carNames);
                }).withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_CAR_NAME_LENGTH_FORMAT, 1, 5));
    }

    @ParameterizedTest(name = "라운드별 결과 테스트: 랜덤값=0,4,9 {0}째 Position={1}")
    @CsvSource(value = {"0:0", "1:1", "2:1"}, delimiter = ':')
    void 라운드별_결과_테스트(int idx, String position){
        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveCars();
                    String[][] currentStatus = cars.getCurrentStatus();
                    assertThat(currentStatus[idx][1]).isEqualTo(position);
                },
                0,4,9
        );
    }

    @Test
    @DisplayName("최종 우승자 테스트: 단독우승")
    void 최종_우승자_테스트_단독우승(){
        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveCars();
                    cars.moveCars();
                    String[] winnerNames = cars.getWinnerNames();
                    assertThat(winnerNames).hasSize(1);
                    assertThat(winnerNames[0]).isEqualTo("car2");
                },
                0,4,4,0,4,0
        );
    }

    @Test
    @DisplayName("최종 우승자 테스트: 공동우승")
    void 최종_우승자_테스트_공동우승(){
        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveCars();
                    cars.moveCars();
                    String[] winnerNames = cars.getWinnerNames();
                    assertThat(winnerNames).hasSize(2);
                    assertThat(winnerNames[0]).isEqualTo("car2");
                    assertThat(winnerNames[1]).isEqualTo("car3");
                },
                0,4,4,0,4,4
        );
    }
}
