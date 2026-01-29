import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите данные для автомобиля " + i + ":");


            System.out.print("Название автомобиля: ");
            String carName = scanner.nextLine().trim();


            while (carName.isEmpty()) {
                System.out.println("Название автомобиля не может быть пустым!");
                System.out.print("Название автомобиля: ");
                carName = scanner.nextLine().trim();
            }

            int speed = 0;
            boolean validSpeed = false;

            while (!validSpeed) {
                System.out.print("Скорость автомобиля (км/ч, от 1 до 250): ");

                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    scanner.nextLine();

                    if (speed > 0 && speed <= 250) {
                        validSpeed = true;
                    } else {
                        System.out.println("Скорость должна быть больше 0 и не больше 250 км/ч!");
                    }
                } else {
                    System.out.println("Введите целое число!");
                    scanner.nextLine();
                }
            }

            Car car = new Car(carName, speed);
            race.determineLeader(car);

            System.out.println();
        }


        String winner = race.getWinner();
        if (!winner.isEmpty()) {
            System.out.println("Самая быстрая машина: " + winner);
        }

        scanner.close();
    }
}