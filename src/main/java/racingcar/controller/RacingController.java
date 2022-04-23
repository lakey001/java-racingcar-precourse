package racingcar.controller;

import racingcar.constant.StringConst;
import racingcar.domain.RacingCars;
import racingcar.utils.ValidationUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    public static void start(){
        RacingCars cars = new RacingCars(readCarNames());
    }

    private static String[] readCarNames(){
        String carNames = InputView.readCarNames();
        boolean valid = isValidCarNames(carNames);
        while(!valid){
            carNames = InputView.readCarNames();
            valid = isValidCarNames(carNames);
        }
        return carNames.split(StringConst.CHAR_COMMA);
    }

    private static boolean isValidCarNames(String carNames) {
        String validateResult = ValidationUtils.validateCarNamesInput(carNames);
        if (validateResult.equals(StringConst.RESULT_SUCCESS)) {
            return true;
        }
        OutputView.printError(validateResult);
        return false;
    }
}
