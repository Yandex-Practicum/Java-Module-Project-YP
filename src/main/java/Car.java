public class Car {
    private final String name;
    private final int speed;
    public Car(String name, int speed) {
        if (speed<=0 || speed > 250) {
            throw new IllegalArgumentException("Скорость должна быть от 1 до 250 км/ч");
        }
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
