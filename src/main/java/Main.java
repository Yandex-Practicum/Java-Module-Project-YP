import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.print("Введите название автомобиля: ");
            String name = scanner.nextLine();

            int speed;
            while (true) {
                System.out.print("Ввведите скорость (0-250): ");
                speed = scanner.nextInt();
                scanner.nextLine();

                if (speed >= 0 && speed <= 250) {
                    break;
                } else {
                    System.out.println("Неверная скорость, введите заново.");
                }
            }

            Car car = new Car(name, speed);
            game.setLeader(car);
        }

        System.out.println("Победитель гонки " + game.getLeaderName());
    }
}