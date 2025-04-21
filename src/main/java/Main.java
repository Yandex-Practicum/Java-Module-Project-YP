import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("🏁 Добро пожаловать на Гонки суперкаров!");

        Race race = new Race();
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            String nameCar;

            // Ввод названия автомобиля
            while (true) {
                System.out.print("Введите название автомобиля " + i + ": ");
                nameCar = scanner.nextLine().trim();

                if (nameCar.isEmpty()) {
                    System.out.println("❗ Название не может быть пустым. Попробуйте снова.");
                } else {
                    break;
                }
            }

            int speedCar;

            // Ввод скорости автомобиля
            while (true) {
                System.out.print("Введите скорость автомобиля " + i + " (от 0 до 250, кратна 10): ");
                if (scanner.hasNextInt()) {
                    speedCar = scanner.nextInt();
                    scanner.nextLine(); // очистка буфера после nextInt()

                    if (speedCar < 0 || speedCar > 250) {
                        System.out.println("❗ Скорость должна быть в диапазоне от 0 до 250 км/ч.");
                    } else if (speedCar % 10 != 0) {
                        System.out.println("❗ Скорость должна быть кратна 10. Примеры: 60, 100, 240.");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("❗ Введите корректное числовое значение!");
                    scanner.nextLine(); // очистка некорректного ввода
                }
            }

            // Создание и обработка автомобиля
            SportCar car = new SportCar(nameCar, speedCar);
            race.returnPath(car);
        }

        scanner.close();

        System.out.println("\n🏆 Самая быстрая машина: " + race.getLeader());
    }
}
