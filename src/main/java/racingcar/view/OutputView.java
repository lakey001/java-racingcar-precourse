package racingcar.view;

import racingcar.constant.ErrorMessageConst;
import racingcar.constant.StringConst;
import racingcar.constant.ViewMessageConst;
import racingcar.domain.RacingCars;
import java.util.StringJoiner;

public class OutputView {
    public static void printError(String errorMessage) {
        System.out.println(ErrorMessageConst.ERROR_PREFIX + errorMessage);
    }

    public static void printSingleRoundResult(RacingCars cars) {
        System.out.println(ViewMessageConst.MESSAGE_RACE_RESULT);
        String[][] statusList = cars.getCurrentStatus();
        for (String[] status : statusList) {
            printStatus(status);
        }
        System.out.print("\n");
    }
    public static void printFinalResult(RacingCars cars) {
        String[] winnerNames = cars.getWinnerNames();
        System.out.println(
                String.format(ViewMessageConst.MESSAGE_FORMAT_WINNER_NAMES, arrayToStringFormat(winnerNames))
        );
    }

    private static String arrayToStringFormat(String[] winnerNames) {
        StringJoiner sj = new StringJoiner(StringConst.CHAR_COMMA);
        for (String name : winnerNames) {
            sj.add(name);
        }
        return sj.toString();
    }

    private static void printStatus(String[] status) {
        System.out.println(
                String.format(ViewMessageConst.MESSAGE_FORMAT_RACE_STATUS, status[0], printPosition(status[1]))
        );
    }

    private static String printPosition(String status) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(status); i++) {
            sb.append(StringConst.CHAR_HYPHEN);
        }
        return sb.toString();
    }
}
