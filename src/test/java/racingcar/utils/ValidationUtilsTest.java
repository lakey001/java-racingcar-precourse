package racingcar.utils;

import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessageConst;
import racingcar.constant.StringConst;
import racingcar.constant.ValueConst;

import static org.assertj.core.api.Assertions.*;

public class ValidationUtilsTest {
    @Test
    void 차_이름_검증_성공(){
        assertThat(ValidationUtils.validateCarNamesInput("car1,car2")).isEqualTo(StringConst.RESULT_SUCCESS);
    }

    @Test
    void 차_이름_검증_실패() {
        assertThat(ValidationUtils.validateCarNamesInput("car1,car234")).isEqualTo(
                String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_CAR_NAME_LENGTH_FORMAT,
                        ValueConst.VALUE_CARNAME_MIN_LENGTH, ValueConst.VALUE_CARNAME_MAX_LENGTH)
        );
        assertThat(ValidationUtils.validateCarNamesInput("car,,car2")).isEqualTo(
                String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_CAR_NAME_LENGTH_FORMAT,
                        ValueConst.VALUE_CARNAME_MIN_LENGTH, ValueConst.VALUE_CARNAME_MAX_LENGTH)
        );
    }
}
