import java.util.Scanner;

public class Main {
    private static final int MIN_SPEED = 0;
    private static final int MAX_SPEED = 250;
    private static final int NUMBER_OF_CARS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        System.out.println("Добро пожаловать на гонку \"24 часа Ле-Мана\"!");
        System.out.println();


        for (int i = 1; i <= NUMBER_OF_CARS; i++) {
            System.out.println();
            System.out.println("--- Автомобиль №" + i + " ---");


            String carName = getValidCarName(scanner, i);


            int carSpeed = getValidCarSpeed(scanner, i);


            Automobile car = new Automobile(carName, carSpeed);
            race.determineLeader(car);

            System.out.println("Автомобиль \"" + carName + "\" добавлен в гонку!");
        }


        System.out.println();
        System.out.println("САМАЯ БЫСТРАЯ МАШИНА: " + race.getLeaderName());

        scanner.close();
    }


    private static String getValidCarName(Scanner scanner, int carNumber) {
        String carName = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Введите название машины №" + carNumber + ": ");
            carName = scanner.nextLine().trim();

            // Проверка, что название не пустое
            if (carName.isEmpty()) {
                System.out.println("Ошибка: Название автомобиля не может быть пустым!");
            } else {
                isValid = true;
            }
        }

        return carName;
    }


    private static int getValidCarSpeed(Scanner scanner, int carNumber) {
        int speed = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Введите скорость машины №" + carNumber + " (1-250 км/ч): ");

            // Проверяем, что введено целое число
            if (scanner.hasNextInt()) {
                speed = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера

                // Проверка диапазона скорости
                if (speed > MIN_SPEED && speed <= MAX_SPEED) {
                    isValid = true;
                } else {
                    System.out.println("Неправильная скорость! Скорость должна быть от " +
                            (MIN_SPEED + 1) + " до " + MAX_SPEED + " км/ч.");
                }
            } else {
                // Если введено не число
                String invalidInput = scanner.nextLine();
                System.out.println("Ошибка: \"" + invalidInput + "\" - это не число! Введите целое число.");
            }
        }

        return speed;
    }
}