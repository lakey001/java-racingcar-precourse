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
        assertThat(ValidationUtils.convertRepeatCountToInteger(String.valueOf(Integer.MIN_VALUE)))
                .isEqualTo(Integer.MIN_VALUE);
        assertThat(ValidationUtils.convertRepeatCountToInteger(String.valueOf(Integer.MAX_VALUE)))
                .isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    @DisplayName("RepeatCount Validation 테스트: 실패 - Integer 변환 실패: 최대값 초과")
    void RepeatCount_Validation_실패_최대값_초과(){
        assertThatIllegalArgumentException().isThrownBy(
                ()->ValidationUtils.convertRepeatCountToInteger("123465789123456789")).withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_NUMBER_FORMAT)
                );
    }

    @Test
    @DisplayName("RepeatCount Validation 테스트: 실패 - Integer 변환 실패: Invalid 문자")
    void RepeatCount_Validation_실패_Invalid_문자(){
        assertThatIllegalArgumentException().isThrownBy(
                ()->ValidationUtils.convertRepeatCountToInteger("abc")).withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_NUMBER_FORMAT)
                );
    }

    @Test
    @DisplayName("RepeatCount Validation 테스트: 실패 - Empty String")
    void RepeatCount_Validation_실패_Empty_String(){
        assertThatIllegalArgumentException().isThrownBy(
                ()->ValidationUtils.convertRepeatCountToInteger("")).withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_NUMBER_FORMAT)
                );
    }

    @Test
    @DisplayName("RepeatCount Validation 테스트: 실패 - null")
    void RepeatCount_Validation_실패_null(){
        assertThatIllegalArgumentException().isThrownBy(
                ()->ValidationUtils.convertRepeatCountToInteger(null)).withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_NUMBER_FORMAT)
                );
    }
}
