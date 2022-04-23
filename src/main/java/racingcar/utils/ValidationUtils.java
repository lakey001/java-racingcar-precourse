package racingcar.utils;

import racingcar.constant.ErrorMessageConst;
import racingcar.constant.StringConst;

public class ValidationUtils {

    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MIN_CAR_NAME_LENGTH = 1;

    public static String validateCarNamesInput(String carNamesInput) {
        String[] carNames = carNamesInput.split(StringConst.CHAR_COMMA);
        try {
            validateCarNames(carNames);
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
        if(carName.length() <= MAX_CAR_NAME_LENGTH && carName.length() >= MIN_CAR_NAME_LENGTH){
            return true;
        }
        throw new IllegalArgumentException(
                String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_CAR_NAME_LENGTH_FORMAT,
                        MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH)
        );
    }
}
