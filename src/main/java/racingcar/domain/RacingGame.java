package racingcar.domain;

import java.util.List;

public class RacingGame {
    private RacingCars cars;
    private int repeatCount;
    private int finishCount;
    private boolean gameEnd;

    public RacingGame(RacingCars cars, int repeatCount) {
        this.cars = cars;
        this.repeatCount = repeatCount;
        this.finishCount = 0;
        this.gameEnd = false;
    }

    public boolean isGameEnd() {
        return this.gameEnd;
    }

    public void playSingleRound() {
        cars.moveCars();
        updateSingleRound();
    }

    private void updateSingleRound() {
        finishCount ++;
        if (finishCount == repeatCount) {
            gameEnd = true;
        }
    }

    public String[][] getCurrentCarsStatus() {
        return cars.getCurrentStatus();
    }

    public List<String> getWinnerNames() {
        int winnerPosition = cars.getMaxPosition();
        return cars.getCarNamesByPosition(winnerPosition);
    }
}
