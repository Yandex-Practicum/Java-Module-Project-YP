import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите данные для автомобиля №" + i + ":");

            String name = readCarName(scanner);
            int speed = readValidSpeed(scanner);

            Auto auto = new Auto(name, speed);
            race.determineNewLeader(auto);
            System.out.println("Победитель гонки: " + race.getLeaderName());
        }
    }

    private static String readCarName(Scanner scanner) {
        System.out.print("Введите название автомобиля: ");
        return scanner.nextLine();
    }

    private static int readValidSpeed(Scanner scanner) {
        int speed = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите скорость автомобиля (0-250 км/ч): ");
            try {
                speed = Integer.parseInt(scanner.nextLine());
                if (speed >= 0 && speed <= 250) {
                    validInput = true;
                } else {
                    System.out.println("Неверная скорость! Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введённое значение не является числом. Попробуйте снова.");
            }
        }

        return speed;
    }
}