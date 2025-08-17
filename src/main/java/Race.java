import java.util.ArrayList;
public class Race {
    /// Сптско лидеров, на тот случай если больше одной машинки имеет максимальный, одинаковый пробег.
    private ArrayList<Car> _leaders = new ArrayList<>();

    /// Метод вычисляет лидера или лидеров, и возвращает список лидирующих машинок.
    public ArrayList<Car> getRaceLeaders(Car[] cars){
        int maxDistance = 0; // Первоначальная инициализация максимальной дистанции.
        for (Car car: cars){
            int distance = car.getDistanceIn24Hours(); // Вычисление пройденной дистанции.

            if(distance > maxDistance){ //Если машинка лидер:
                maxDistance = distance;
                _leaders.clear(); // Очищаем список лидеров,
                _leaders.add(car); //Добавляем машинку в лидеры.
            }
            else if (distance == maxDistance){ //Если машинка второй лидер:
                _leaders.add(car); //Добавляем машинку в лидеры.
            }
        }
        return _leaders; //Возвращаем список лидеров.
    }
}
