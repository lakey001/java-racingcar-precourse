package racingcar.utils;

import racingcar.constant.ErrorMessageConst;
import racingcar.constant.StringConst;

public class ValidationUtils {
    public static String validateRepeatCountInput(String repeatCount) {
        try {
            validateRepeatCount(repeatCount);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return StringConst.RESULT_SUCCESS;
    }

    private static void validateRepeatCount(String repeatCount) {
        try {
            Integer.parseInt(repeatCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_REPEAT_COUNT_FORMAT, Integer.MAX_VALUE)
            );
        }
    }
}
