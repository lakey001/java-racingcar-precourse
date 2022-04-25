package racingcar.utils;

import racingcar.constant.ErrorMessageConst;

public class ValidationUtils {
    public static int convertRepeatCountToInteger(String repeatCount) {
        try {
            return Integer.parseInt(repeatCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_NUMBER_FORMAT)
            );
        }
    }
}
