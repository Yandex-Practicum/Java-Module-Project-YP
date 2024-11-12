import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        Scanner scanner = new Scanner(System.in);

        for (int carNumber = 1; carNumber <= 3; carNumber++) {
            System.out.println("Введите название машины №" + carNumber + ":");
            String carName = scanner.next();

            boolean isReady = false;
            int carSpeed = 0;
            while (!isReady) {
                System.out.println("Введите скорость машины №" + carNumber + ":");
                if (scanner.hasNextInt()) {
                    carSpeed = scanner.nextInt();
                    if (carSpeed > 0 && carSpeed <= 250) {
                        isReady = true;
                    } else {
                        System.out.println("Неправильная скорость. Скорость должна быть целым числом от 1 до 250.");
                    }
                } else {
                    System.out.println("Неправильный ввод. Пожалуйста, введите целое число.");
                    scanner.next();
                }
            }
            race.addNewCar(new Car(carName, carSpeed));
        }
        System.out.println("Самая быстрая машина: " + race.getLeaderName());
        scanner.close();
    }
}
