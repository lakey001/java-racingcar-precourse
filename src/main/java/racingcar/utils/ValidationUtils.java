package racingcar.utils;

import racingcar.constant.ErrorMessageConst;

public class ValidationUtils {
    public static int convertRepeatCountToInteger(String repeatCount) {
        try {
            int result = Integer.parseInt(repeatCount);
            return validateNaturalNumber(result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_REPEAT_COUNT_FORMAT, Integer.MAX_VALUE)
            );
        }
    }

    private static int validateNaturalNumber(int number) {
        if( number > 0){
            return number;
        }
        throw new IllegalArgumentException(
                String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_REPEAT_COUNT_FORMAT, Integer.MAX_VALUE)
        );
    }
}
