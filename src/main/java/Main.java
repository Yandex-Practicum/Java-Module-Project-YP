import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        System.out.println("24 часа Ле-Мана");

        for (int i = 1; i <= 3; i++) {
            System.out.println("\nАвтомобиль №" + i);
            System.out.println("Введите название машины: ");
            String carName = scanner.nextLine();

            while (carName.trim().isEmpty()) {
                System.out.println("Ошибка: название не может быть пустым!");
                System.out.println("Введите название машины:");
                carName = scanner.nextLine();
            }

            int carSpeed = 0;
            boolean speedIsCorrect = false;

            while (!speedIsCorrect) {
                System.out.println("Введите скорость машины: ");

                if (scanner.hasNextInt()) {
                    carSpeed = scanner.nextInt();
                    scanner.nextLine();

                    if (carSpeed > 0 && carSpeed <= 250) {
                        speedIsCorrect = true;
                    } else if (carSpeed <= 0) {
                        System.out.println("Ошибка: скорость должна быть больше 0!");
                    } else {
                        System.out.println("Неправильная скорость!");
                    }
                } else {
                    System.out.println("Ошибка: введите целое число!");
                    scanner.nextLine();
                }
            }

            Car car = new Car(carName, carSpeed);
            race.updateLeader(car);
        }

        scanner.close();
        System.out.println("\n" + race.getWinner());
    }
}