import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[3];

        for (int i = 0; i < 3; i++) {
            String name;
            while (true) {
                System.out.print("Введите название автомобиля #" + (i + 1) + ": ");
                name = scanner.nextLine().trim();

                if (!name.isEmpty()) {
                    break;
                } else {
                    System.out.println("Ошибка: название автомобиля не должно быть пустым. Попробуйте снова.");
                }
            }

            double speed;
            while (true) {
                System.out.print("Введите скорость автомобиля #" + (i + 1) + " (от 0 до 250): ");
                String input = scanner.nextLine();

                try {
                    speed = Double.parseDouble(input);
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Ошибка: скорость должна быть > 0 и <= 250. Попробуйте снова.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введено некорректное значение. Попробуйте снова.");
                }
            }

            cars[i] = new Car(name, speed);
        }

        Race race = new Race(cars);
        Car winner = race.determineWinner();
        System.out.println("Самая быстрая машина: " + winner.getName());

        scanner.close();
    }
}