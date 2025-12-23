import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;

public class Race {
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
        System.out.println("Скорость должна быть целым значением в пределах от 1 до 250 включительно");
        while (true) {
            String speedString = scanner.nextLine();
            if (speedString.isEmpty()) {
                System.out.println("Пустое значение. Скорость должна быть целым значением в пределах от 1 до 250 включительно. Попробуйте еще раз");
                continue;
            }
            try {
                speed = Integer.parseInt(speedString);
                if (speed > 0 && speed <= 250) {
                    break;
                } else {
                    System.out.println("Скорость должна быть целым значением в пределах от 1 до 250 включительно. Попробуйте еще раз");
                }
            } catch(NumberFormatException nfe) {
                System.out.println("Кажется, вы ввели не целое число. Попробуйте еще раз: Введите скорость от 1 до 250 включительно");
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
