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
        try {
            String repeatCount = InputView.readRepeatCount();
            return ValidationUtils.convertRepeatCountToInteger(repeatCount);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return readRepeatCount();
        }
    }

    private static void race(RacingCars cars, int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            cars.moveCars();
            OutputView.printSingleRoundResult(cars);
        }
        OutputView.printFinalResult(cars);
    }
}
