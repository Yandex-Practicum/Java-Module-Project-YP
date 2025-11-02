/**
 * Класс автомобиля - участника гонки
 */
public class Car {
    private String name;    // Название автомобиля
    private int speed;      // Скорость в км/ч

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    /**
     * Расчет расстояния за 24 часа
     */
    public double calculateDistance() {
        return speed * 24;  // 24 часа гонки
    }
}
