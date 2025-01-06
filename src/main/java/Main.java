import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название машины №" + i + ":");
            String name = scanner.next();

            int speed;
            while (true) {
                try {
                    System.out.println("Введите скорость машины №" + i + ":");
                    speed = scanner.nextInt();

                    if (speed <= 0 || speed > 250) {
                        System.out.println("Неправильная скорость");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Неправильная скорость");
                    scanner.next();
                }
            }

            Car car = new Car(name, speed);
            race.checkForNewLeader(car);
        }

        System.out.println("Самая быстрая машина: " + race.getWinner());
        scanner.close();
    }
}