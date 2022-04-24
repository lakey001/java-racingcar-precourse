package racingcar.utils;

import racingcar.constant.ErrorMessageConst;
import racingcar.constant.StringConst;
import racingcar.constant.ValueConst;

public class ValidationUtils {
    public static String validateCarNamesInput(String carNamesInput) {
        String[] carNames = carNamesInput.split(StringConst.CHAR_COMMA);
        try {
            validateCarNames(carNames);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return StringConst.RESULT_SUCCESS;
    }

    public static String validateRepeatCountInput(String repeatCount) {
        try {
            validateRepeatCount(repeatCount);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return StringConst.RESULT_SUCCESS;
    }

    private static boolean validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
        return true;
    }

    private static boolean validateCarNameLength(String carName) {
        if(carName.length() <= ValueConst.VALUE_CARNAME_MAX_LENGTH
                && carName.length() >= ValueConst.VALUE_CARNAME_MIN_LENGTH){
            return true;
        }
        throw new IllegalArgumentException(
                String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_CAR_NAME_LENGTH_FORMAT,
                        ValueConst.VALUE_CARNAME_MIN_LENGTH, ValueConst.VALUE_CARNAME_MAX_LENGTH)
        );
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
