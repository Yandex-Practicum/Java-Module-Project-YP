public class Car {
    private String name;
    private int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String carName() {
        return name;
    }

    public int carSpeed() {
        return speed;
    }

    public int distance() {
        return 24 * speed;
    }
}
