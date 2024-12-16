import java.util.Scanner;
class Car {
    private final String name;
    private final int speed;

    // Конструктор
    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    // Метод для расчёта пройденного расстояния за 24 часа
    public int getDistanceIn24Hours() {
        return speed * 24;
    }
}

// Класс, отвечающий за логику гонки
class Race {
    private Car leader;

    // Метод для определения лидера гонки
    public void findLeader(Car[] cars) {
        for (Car car : cars) {
            if (leader == null || car.getDistanceIn24Hours() > leader.getDistanceIn24Hours()) {
                leader = car;
            }
        }
    }

    public Car getLeader() {
        return leader;
    }
}

// Главный класс
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[3];

        // Считывание данных об автомобилях
        for (int i = 0; i < cars.length; i++) {
            System.out.println("Введите данные для автомобиля " + (i + 1) + ":");

            System.out.print("Название: ");
            String name = scanner.nextLine();

            int speed;
            while (true) {
                System.out.print("Скорость (от 1 до 250): ");
                speed = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера

                if (speed > 0 && speed <= 250) {
                    break;
                } else {
                    System.out.println("Ошибка: скорость должна быть больше 0 и меньше или равна 250. Повторите ввод.");
                }
            }

            cars[i] = new Car(name, speed);
        }

        // Определение лидера
        Race race = new Race();
        race.findLeader(cars);

        // Вывод лидера
        Car leader = race.getLeader();
        System.out.println("Самая быстрая машина: " + leader.getName());

        scanner.close();
    }
}
