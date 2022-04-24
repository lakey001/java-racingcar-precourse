package racingcar.controller;

import racingcar.constant.StringConst;
import racingcar.domain.RacingCars;
import racingcar.utils.ValidationUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    public static void start(){
        RacingCars cars = new RacingCars(readCarNames());
        int repeatCount = readRepeatCount();
        race(cars, repeatCount);
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

    private static int readRepeatCount(){
        String repeatCount = InputView.readRepeatCount();
        boolean valid = isValidRepeatCount(repeatCount);
        while(!valid){
            repeatCount = InputView.readRepeatCount();
            valid = isValidRepeatCount(repeatCount);
        }
        return Integer.parseInt(repeatCount);
    }

    private static boolean isValidCarNames(String carNames) {
        String validateResult = ValidationUtils.validateCarNamesInput(carNames);
        if (validateResult.equals(StringConst.RESULT_SUCCESS)) {
            return true;
        }
        OutputView.printError(validateResult);
        return false;
    }

    private static boolean isValidRepeatCount(String repeatCount) {
        String validateResult = ValidationUtils.validateRepeatCountInput(repeatCount);
        if (validateResult.equals(StringConst.RESULT_SUCCESS)) {
            return true;
        }
        OutputView.printError(validateResult);
        return false;
    }

    private static void race(RacingCars cars, int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            cars.moveCars();
            OutputView.printSingleRoundResult(cars);
        }
        OutputView.printFinalResult(cars);
    }
}
