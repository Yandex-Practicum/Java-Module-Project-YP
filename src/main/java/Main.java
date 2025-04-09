import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int carNumber = 1; carNumber <= 3; carNumber++) {

            String name = askCarName(scanner, carNumber);
            int speed = askCarSpeed(scanner, carNumber);

            Car car = new Car(name, speed);
            race.checkNewLeader(car);
        }

        System.out.println("Самая быстрая машина: " + race.leaderName);
        scanner.close();

    }


    public static String askCarName(Scanner scanner, int carNumber) {
        System.out.print("Введите название машины №" + carNumber + ": ");
        return scanner.nextLine();
    }


    public static int askCarSpeed(Scanner scanner, int carNumber) {

        while (true) {
            System.out.print("Введите скорость машины №" + carNumber + " (от 1 до 250): ");
            String input = scanner.nextLine();

            int speed = Integer.parseInt(input);

            if (speed >= 1 && speed <= 250) {
                return speed;
            } else {
                System.out.println("Ошибка: скорость должна быть в диапазоне от 1 до 250. Попробуйте снова.");
            }
        }
    }


}