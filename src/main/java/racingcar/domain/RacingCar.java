package racingcar.domain;

import racingcar.constant.ValueConst;

public class RacingCar {
    private String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = ValueConst.VALUE_CAR_INITIAL_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= ValueConst.VALUE_CAR_GO_FORWARD) {
            goForward();
        }
    }

    private void goForward() {
        position ++;
    }
}
