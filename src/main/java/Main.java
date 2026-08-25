import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String name = getValidName(scanner, i + 1);
            int speed = getValidSpeed(scanner, i + 1);
            cars.add(new Car(name, speed));
        }

        Race race = new Race();
        race.calculateFastestCar(cars);
    }

    private static String getValidName(Scanner scanner, int carNumber) {
        while (true) {
            System.out.printf("Введите название машины №%d:%n", carNumber);
            String name = scanner.nextLine().trim();
            if (name.isBlank()) {
                System.out.println("Пустое название");
                continue;
            }
            return name;
        }
    }

    private static int getValidSpeed(Scanner scanner, int carNumber) {
        while (true) {
            System.out.printf("Введите скорость машины №%d:%n", carNumber);
            try {
                int speed = Integer.parseInt(scanner.nextLine());
                if (speed <= 0 || speed > 250) {
                    System.out.println("Неправильная скорость");
                    continue;
                }
                return speed;
            } catch (NumberFormatException e) {
                System.out.println("Неправильная скорость");
            }
        }
    }
}