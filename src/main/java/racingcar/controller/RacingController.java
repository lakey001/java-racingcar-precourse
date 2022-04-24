package racingcar.controller;

import racingcar.constant.StringConst;
import racingcar.domain.RacingCars;
import racingcar.utils.ValidationUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    public static void start(){
        RacingCars cars = createRacingCars();
        int repeatCount = readRepeatCount();
        race(cars, repeatCount);
    }

    private static RacingCars createRacingCars() {
        try {
            RacingCars cars = new RacingCars(readCarNames());
            return cars;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return createRacingCars();
        }
    }

    private static String[] readCarNames(){
        return InputView.readCarNames().split(StringConst.CHAR_COMMA);
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
