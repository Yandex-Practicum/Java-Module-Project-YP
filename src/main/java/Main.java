import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Auto[] autoArray = new Auto[3];
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название машины №" + i);

            String name = scanner.next();

            int speed = 0;

            while (true) {
                System.out.println("Введите скорость машины №" + i);
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    if ((speed > 0) && (speed <= 250)) {
                        break;
                    } else {
                        System.out.println("Неправильная скорость");
                    }
                } else {
                    System.out.println("Неправильная скорость");
                    scanner.next();
                }
            }

            autoArray[i - 1] = new Auto(name, speed);
            race.calculateDistance(name, speed);
        }
        System.out.println("Самая быстрая машина: " + race.name);
    }
}

