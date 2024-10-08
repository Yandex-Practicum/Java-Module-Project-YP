import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Race race = new Race();

        for (int i = 0; i < 3; i++) {

            System.out.println("- Введите название машины №" + (i + 1) + ":");

            String carName = scanner.next();

            int carSpeed;
            while (true) {
                System.out.println("- Введите скорость машины №" + (i + 1) + ":");

                if (scanner.hasNextInt()) {

                    carSpeed = scanner.nextInt();

                    if (carSpeed > 0 && carSpeed <= 250) {
                        break;
                    } else {
                        System.out.println("- Введите скорость от 1 до 250");
                    }
                } else {
                    System.out.println("- Введите число");

                    scanner.next();
                }
            }
            Car car = new Car(carName, carSpeed);

            race.addRacer(car.getName(), car.getSpeed());
        }
        System.out.println("Самая быстрая машина: " + race.getLeader());
    }
}