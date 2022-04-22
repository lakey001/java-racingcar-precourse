package racingcar.domain.RacingCar;

public class RacingCar {
    public static final int VALUE_CAR_GO_FORWARD = 4;
    private String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= VALUE_CAR_GO_FORWARD) {
            goForward();
        }
    }

    private void goForward() {
        position ++;
    }
}
