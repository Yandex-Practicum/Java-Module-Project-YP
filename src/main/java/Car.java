public class Car {
    //Новый пулл
    private final String name;
    private final double speed;

    public Car(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    // Геттер для названия
    public String getName() {
        return name;
    }

    // Геттер для скорости
    public double getSpeed() {
        return speed;
    }
}
