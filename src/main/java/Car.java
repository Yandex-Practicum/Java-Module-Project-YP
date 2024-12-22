public class Car {
    private String name;
    private double speed;

    public Car(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double calculateDistance(double hours) {
        return speed * hours;
    }
}