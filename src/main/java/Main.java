import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();

        System.out.println("Введите данные 3 автомобилей:");

        for (int i = 1; i <= 3; i++) {
            System.out.print("Автомобиль " + i + ". Название: ");
            String name = scanner.nextLine();

            int speed = 0;
            boolean isValidSpeed = false;

            while (!isValidSpeed) {
                System.out.print("Скорость (1-250 км/ч): ");
                try {
                    speed = Integer.parseInt(scanner.nextLine());
                    if (speed > 0 && speed <= 250) {
                        isValidSpeed = true;
                    } else {
                        System.out.println("Ошибка: скорость должна быть от 1 до 250 км/ч!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите число!");
                }
            }

            cars.add(new Car(name, speed));
        }

        Race race = new Race(cars);
        Car winner = race.determineWinner();

        System.out.println("\nСамая быстрая машина: " + winner.getName());
    }
}
