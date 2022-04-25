package racingcar.view;

import racingcar.constant.ErrorMessageConst;
import racingcar.constant.StringConst;
import racingcar.constant.ViewMessageConst;
import racingcar.domain.RacingGame;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    public static void printError(String errorMessage) {
        System.out.println(ErrorMessageConst.ERROR_PREFIX + errorMessage);
    }

    public static void printRacingGameSingleRoundResult(RacingGame game) {
        System.out.println(ViewMessageConst.MESSAGE_PRINT_RACE_RESULT);
        List<String[]> currentCarsStatus = game.getCurrentCarsStatus();
        for (String[] status : currentCarsStatus) {
            printStatus(status);
        }
        System.out.print(StringConst.ESC_NEW_LINE);
    }

    public static void printRacingGameFinalResult(RacingGame game) {
        List<String> winnerNames = game.getWinnerNames();
        System.out.println(
                String.format(ViewMessageConst.MESSAGE_PRINT_WINNER_NAMES_FORMAT, convertArrayListToString(winnerNames))
        );
    }

    private static String convertArrayListToString(List<String> names) {
        StringJoiner sj = new StringJoiner(StringConst.CHAR_COMMA);
        for (String name : names) {
            sj.add(name);
        }
        return sj.toString();
    }

    private static void printStatus(String[] status) {
        System.out.println(
                String.format(ViewMessageConst.MESSAGE_PRINT_RACE_STATUS_FORMAT, status[0], printPosition(status[1]))
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
