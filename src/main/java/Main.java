import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Auto[] auto = new Auto[3];

        for (int i = 0; i < 3; i++) {
            String name = "";
            int speed = 0;

            while (true) {
                System.out.print("Введите название машины №" + (i + 1) + ": ");
                name = scanner.nextLine().trim();
                if (!name.isEmpty()) {
                    break;
                } else {
                    System.out.println("Ошибка: название не может быть пустым. Попробуйте снова.");
                }
            }

            while (true) {
                System.out.print("Введите скорость машины №" + (i + 1) + ":");
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    scanner.nextLine();
                    if (speed >= 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Некорректный ввод, введите целое число от 0 до 250");
                    }
                } else {
                    System.out.println("Некорректный ввод, введите целое число.");
                    scanner.nextLine();
                }
            }
            auto[i] = new Auto(name, speed);
        }
        scanner.close();

        Race race = new Race();
        race.setCars(auto[0], auto[1], auto[2]);
        Auto winner = race.findWinner();
        System.out.println("Самая быстрая машина: " + winner.getName());
    }
}
