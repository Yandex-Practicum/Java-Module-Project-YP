public class Automobile {
    private final String name;
    private final int speed;

    // Конструктор
    public Automobile(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    // Метод для расчета дистанции за 24 часа
    public int calculateDistance() {
        return speed * 24;
    }
}