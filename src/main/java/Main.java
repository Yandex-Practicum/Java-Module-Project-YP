import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[3];

        System.out.println("=== 24 часа Ле-Мана ===");

        // Ввод данных для трех автомобилей
        for (int i = 0; i < 3; i++) {
            System.out.println("— Введите название машины №" + (i + 1) + ":");
            String name = scanner.nextLine();

            int speed = getValidSpeed(scanner, i + 1);

            cars[i] = new Car(name, speed);
        }

        // Определяем победителя
        Race race = new Race(cars);
        Car winner = race.getLeader();

        // Выводим результат
        System.out.println("Самая быстрая машина: " + winner.getName());

        scanner.close();
    }

    /**
     * Метод для получения корректной скорости с проверкой
     */
    private static int getValidSpeed(Scanner scanner, int carNumber) {
        int speed = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.println("— Введите скорость машины №" + carNumber + ":");
            String input = scanner.nextLine();

            try {
                // Проверяем на дробное число
                if (input.contains(".") || input.contains(",")) {
                    System.out.println("— Неправильная скорость");
                    continue;
                }

                speed = Integer.parseInt(input);

                // Проверяем диапазон
                if (speed <= 0 || speed > 250) {
                    System.out.println("— Неправильная скорость");
                } else {
                    isValid = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("— Неправильная скорость");
            }
        }

        return speed;
    }
}
