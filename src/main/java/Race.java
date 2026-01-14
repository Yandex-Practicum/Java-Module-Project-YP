import java.util.HashSet;
import java.util.Scanner;

public class Race {
    private static final int MIN_CAR_SPEED = 0;
    private static final int MAX_CAR_SPEED = 290;
    private final HashSet<Car> cars = new HashSet<>();

    void addCarToRace(Scanner scanner) {
        String name = getName(scanner);
        int speed = getSpeed(scanner);

        Car newCar = new Car(name, speed);
        cars.add(newCar);
        System.out.println("Машина зарегистрирована на гонку\n");
    }

    private String getName(Scanner scanner) {
        System.out.println("Введите название машины:");
        String name = "";
        while (true) {
            // Чтобы давать названия автомобилям не в одну слитную строку. Например, "Летающий Пегас"
            name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("У машины должно быть непустое имя. Попробуйте еще раз");
            } else {
                break;
            }
        }
        return name;
    }

    private int getSpeed(Scanner scanner) {
        int speed = -1;
        System.out.println("Введите скорость машины.");
        String getSpeedFormat = "Скорость должна быть целым значением больше %d и меньше или равно %d";
        System.out.printf(getSpeedFormat + "\n", MIN_CAR_SPEED, MAX_CAR_SPEED);
        while (true) {
            String speedString = scanner.nextLine();
            if (speedString.isEmpty()) {
                System.out.printf("Пустое значение" + getSpeedFormat + "Попробуйте еще раз\n", MIN_CAR_SPEED, MAX_CAR_SPEED);
                continue;
            }
            try {
                speed = Integer.parseInt(speedString);
                if (speed > MIN_CAR_SPEED && speed <= MAX_CAR_SPEED) {
                    break;
                } else {
                    System.out.printf(getSpeedFormat + ". Попробуйте еще раз\n", MIN_CAR_SPEED, MAX_CAR_SPEED);
                }
            } catch(NumberFormatException nfe) {
                System.out.printf("Кажется, вы ввели не целое число. Попробуйте еще раз: " + getSpeedFormat + "\n", MIN_CAR_SPEED, MAX_CAR_SPEED);
            }
        }
        return speed;
    }

    void whoIsWinner() {
        if (cars.isEmpty()) {
            System.out.println("В гонке нет машин. Добавьте больше машин");
            return;
        }
        // Мы берем случайное значение из Set'а, чтобы проиницилизировать первую переменную
        Car leader = cars.iterator().next();
        for(Car car : cars) {
            // Потому что скорость * время = расстояние. Время для всех одинаково. Значит чем больше скорость, тем больше расстояние
            if (car.speed > leader.speed) {
                leader = car;
            }
        }
        int leaderDistance = leader.speed * 24;
        System.out.printf("Победитель %s, который проехал %d километров за 24 часа", leader.name, leaderDistance);
    }
}
