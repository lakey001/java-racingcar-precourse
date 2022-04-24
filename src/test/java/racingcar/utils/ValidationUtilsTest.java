package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessageConst;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidationUtilsTest {
    @Test
    @DisplayName("RepeatCount Validation 테스트: 성공")
    void RepeatCount_Validation_성공(){
        assertThat(ValidationUtils.convertRepeatCountToInteger("1")).isEqualTo(1);
        assertThat(ValidationUtils.convertRepeatCountToInteger(String.valueOf(Integer.MAX_VALUE)))
                .isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    @DisplayName("RepeatCount Validation 테스트: 실패 - 0")
    void RepeatCount_Validation_실패_0(){
        assertThatIllegalArgumentException().isThrownBy(
                ()->ValidationUtils.convertRepeatCountToInteger("0"))
                .withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_REPEAT_COUNT_FORMAT, Integer.MAX_VALUE)
                );
    }

    @Test
    @DisplayName("RepeatCount Validation 테스트: 실패 - 최대값 초과")
    void RepeatCount_Validation_실패_최대값_초과(){
        assertThatIllegalArgumentException().isThrownBy(
                ()->ValidationUtils.convertRepeatCountToInteger("123465789123456789"))
                .withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_REPEAT_COUNT_FORMAT, Integer.MAX_VALUE)
                );
    }

    @Test
    @DisplayName("RepeatCount Validation 테스트: 실패 - 음수")
    void RepeatCount_Validation_실패_음수(){
        assertThatIllegalArgumentException().isThrownBy(
                ()->ValidationUtils.convertRepeatCountToInteger("-1"))
                .withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_REPEAT_COUNT_FORMAT, Integer.MAX_VALUE)
                );
    }
}
