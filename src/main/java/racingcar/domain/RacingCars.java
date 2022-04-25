package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ValueConst;
import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(String[] carNames) {
        racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
    }

    public void moveCars() {
        for (RacingCar car : racingCars) {
            car.move(Randoms.pickNumberInRange(ValueConst.VALUE_RANDOM_MIN, ValueConst.VALUE_RANDOM_MAX));
        }
    }

    public String[][] getCurrentStatus() {
        String[][] status = new String[racingCars.size()][2];
        for (int i = 0; i < racingCars.size(); i++) {
            status[i] = generateStatus(racingCars.get(i));
        }
        return status;
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (RacingCar car : racingCars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<String> getCarNamesByPosition(int winnerPosition) {
        List<String> result = new ArrayList<>();
        for (RacingCar car : racingCars) {
            addCarNamesAtPosition(result, car, winnerPosition);
        }
        return result;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    private String[] generateStatus(RacingCar racingCar) {
        String[] status = {racingCar.getName(), String.valueOf(racingCar.getPosition())};
        return status;
    }

    private void addCarNamesAtPosition(List<String> carNames, RacingCar car, int position) {
        if (car.getPosition() == position) {
            carNames.add(car.getName());
        }
    }
}
