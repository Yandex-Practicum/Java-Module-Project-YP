import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            System.out.print("Введите название машины #" + i + ": ");
            String name = scanner.nextLine();

            int speed = 0;
            while (true) {
                try {
                    System.out.print("Введите скорость машины #" + i + ": ");
                    speed = Integer.parseInt(scanner.nextLine());

                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Неправильная скорость");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Неправильная скорость");
                }
            }
            Car car = new Car(name, speed);
            race.addCar(car);
        }
        String leader = race.whoLeader();
        System.out.println("Самая быстрая машина: " + leader);

        scanner.close();
    }
}