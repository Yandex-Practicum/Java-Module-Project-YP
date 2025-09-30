import java.util.Scanner;

// Класс Автомобилей
class Car {
    private String name;
    private int speed;

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

    public int calculateDistance() {
        return 24 * speed;
    }
}

// Класс Гонка
class Race {
    private String leaderName;
    private int leaderDistance;

    public Race() {
        this.leaderName = "";
        this.leaderDistance = 0;
    }

    public void determineLeader(Car car) {
        int carDistance = car.calculateDistance();
        if (carDistance > leaderDistance) {
            leaderName = car.getName();
            leaderDistance = carDistance;
        }
    }

    public String getLeader() {
        return leaderName;
    }
}

// Главный класс
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            System.out.println("--- Автомобиль №" + i + " ---");

            // Ввод названия автомобиля
            String carName = inputCarName(i);

            // Ввод скорости
            int carSpeed = inputCarSpeed(i);

            // Создание автомобиля и определение лидера
            Car car = new Car(carName, carSpeed);
            race.determineLeader(car);

            System.out.println(); // строка для читаемости
        }

        // Вывод результата
        String winner = race.getLeader();
        System.out.println("Самая быстрая машина: " + winner);

        scanner.close();
    }

    // Метод для ввода названия автомобиля
    private static String inputCarName(int carNumber) {
        String carName = "";
        while (carName.isEmpty()) {
            System.out.print("Введите название машины №" + carNumber + ": ");
            carName = scanner.nextLine().trim();
            if (carName.isEmpty()) {
                System.out.println("Название машины не может быть пустым!");
            }
        }
        return carName;
    }

    // Метод для ввода скорости автомобиля
    private static int inputCarSpeed(int carNumber) {
        int carSpeed = 0;
        while (true) {
            System.out.print("Введите скорость машины №" + carNumber + " (1-250 км/ч): ");
            if (scanner.hasNextInt()) {
                carSpeed = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
                if (carSpeed > 0 && carSpeed <= 250) {
                    break;
                } else {
                    System.out.println("Неправильная скорость! Скорость должна быть от 1 до 250 км/ч.");
                }
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.nextLine(); // очистка буфера при ошибке
            }
        }
        return carSpeed;
    }
}