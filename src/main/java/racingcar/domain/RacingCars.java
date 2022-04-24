package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
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
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }
    public String[][] getCurrentStatus() {
        String[][] status = new String[racingCars.size()][2];
        for (int i = 0; i < racingCars.size(); i++) {
            status[i] = generateStatus(racingCars.get(i));
        }
        return status;
    }

    private String[] generateStatus(RacingCar racingCar) {
        String[] status = {racingCar.getName(), String.valueOf(racingCar.getPosition())};
        return status;
    }
}
