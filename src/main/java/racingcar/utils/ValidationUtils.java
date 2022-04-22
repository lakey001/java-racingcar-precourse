package racingcar.utils;

public class ValidationUtils {

    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MIN_CAR_NAME_LENGTH = 1;
    public static final String CAR_NAME_SPLITTER = ",";

    public static boolean validateCarNamesInput(String carNamesInput) {
        String[] carNames = carNamesInput.split(CAR_NAME_SPLITTER);
        try {
            validateCarNames(carNames);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
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
        throw new IllegalArgumentException();
    }
}
