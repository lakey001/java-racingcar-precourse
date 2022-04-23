package racingcar.utils;

import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessageConst;
import racingcar.constant.StringConst;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class ValidationUtilsTest {
    @Test
    void 차_이름_검증(){
        assertThat(ValidationUtils.validateCarNamesInput("car1,car2")).isEqualTo(StringConst.RESULT_SUCCESS);
        assertThat(ValidationUtils.validateCarNamesInput("car1,car234")).isEqualTo(
                String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_CAR_NAME_LENGTH_FORMAT,
                        ValidationUtils.MIN_CAR_NAME_LENGTH, ValidationUtils.MAX_CAR_NAME_LENGTH)
        );
        assertThat(ValidationUtils.validateCarNamesInput("car,,car2")).isEqualTo(
                String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_CAR_NAME_LENGTH_FORMAT,
                        ValidationUtils.MIN_CAR_NAME_LENGTH, ValidationUtils.MAX_CAR_NAME_LENGTH)
        );
    }

}
