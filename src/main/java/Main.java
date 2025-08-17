import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 0; i < 3; i++) {
            String name = getValidName(scanner, i + 1);
            int speed = getValidSpeed(scanner, i + 1);
            Car car = new Car(name, speed);
            race.determineFastestCar(car);
        }

        System.out.println("Самая быстрая машина: " + race.getFastestCarName());
    }

    private static String getValidName(Scanner scanner, int carNumber) {
        String name;
        while (true) {
            System.out.println("Введите название машины №" + carNumber + ":");
            name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            } else {
                System.out.println("Ошибка: Название машины не может быть пустым. Попробуйте снова.");
            }
        }
    }

    private static int getValidSpeed(Scanner scanner, int carNumber) {
        int speed;
        while (true) {
            System.out.println("Введите скорость машины №" + carNumber + ":");
            try {
                speed = Integer.parseInt(scanner.nextLine());
                if (speed > 0 && speed <= 250) {
                    return speed;
                } else {
                    System.out.println("Ошибка: Скорость должна быть больше 0 и не больше 250. Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный ввод. Скорость должна быть целым числом. Попробуйте снова.");
            }
        }
    }
}