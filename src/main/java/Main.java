import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();


        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название автомобиля " + i + ":");
            String name = scanner.next();

            int speed;

            while (true) {
                System.out.println("Введите скорость автомобиля " + i + " (от 0 до 250):");
                String input = scanner.next();

                try {
                    speed = Integer.parseInt(input);

                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Ошибка: скорость должна быть от 0 до 250. Попробуйте снова.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите целое число для скорости. Попробуйте снова.");
                }
            }


            Car car = new Car(name, speed);
            race.updateLeader(car);
        }


        System.out.println("Самая быстрая машина: " + race.getLeaderName());
        scanner.close();
    }
}
