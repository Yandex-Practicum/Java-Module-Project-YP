public class Car {
    /// Локальные переменные для хранения заданных в конструкторе значений.
    private String _name; // Название машинки.
    private int _speed; //Скорость машинки.

    /// Конструктор, принимает на вход значения: имя машинки, и ее скорость.
    public Car(String name, int speed) {
        _name = name;
        _speed = speed;
    }

    /// Метод доступа к названию машинки.
    public String getName() {
        return _name;
    }

    /// Метод доступа к скорости машинки.
    public int getSpeed() {
        return _speed;
    }

    /// Вычисляет расстояние пройденное машинкой за 24 чсас.
    public int getDistanceIn24Hours() {
        return getSpeed() * 24;
    }
}
