public class Race {
    String fastestCarName;
    int fastestSpeed;

    public Race() {
        this.fastestCarName = "";
        this.fastestSpeed = 0;
    }

    public void determineFastestCar(Car car) {
        if (car.getSpeed() > fastestSpeed) {
            fastestCarName = car.getName();
            fastestSpeed = car.getSpeed();
        }
    }

    public String getFastestCarName() {
        return fastestCarName;
    }
}