
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите название для авто " + (i + 1) + ":");
            String name = scanner.next();

            System.out.println("Введите скорость для авто " + (i + 1) + ":");
            int carSpeed = scanner.nextInt();
            while ((carSpeed < 0) || (carSpeed >= 250)) {
                System.out.println("Скорость вне диапазона 0-250. Введите значение еще раз.");
                System.out.println("Введите скорость для авто " + (i + 1) + ":");
                carSpeed = scanner.nextInt();
            }
            cars[i] = new Car(name, carSpeed);
        }

        Race race = new Race();
        System.out.println(race.winner(cars));
    }
}