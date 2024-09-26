public class Race {

    String leader = ""; // марка автомобиля
    int distance = 0; // Скорость автомобиля
    int newDistance;

    void distanceCar(Car car) {
        newDistance = 24 * car.speed; // Расчет пройденной дистанции
        if (newDistance > distance) {
            leader = car.name; // присвоение переменой значения марки лидера
            distance = newDistance; // перезаписываем наибольшую пройденную дистанцию автомобилем

        }

    }

}