import java.util.Scanner;

public class Main {
    //Новый пулл
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите название автомобиля " + (i + 1) + ":");
            String name = scanner.nextLine();

            double speed = 0;
            boolean validSpeed = false;

            while (!validSpeed) {
                System.out.println("Введите скорость автомобиля " + (i + 1) + " (от 1 до 250):");
                String speedInput = scanner.nextLine();

                try {
                    speed = Double.parseDouble(speedInput);

                    if (speed > 0 && speed <= 250) {
                        validSpeed = true;
                    } else {
                        System.out.println("Скорость должна быть больше 0 и не больше 250. Попробуйте снова.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                }
            }

            cars[i] = new Car(name, speed);
        }

        Race race = new Race();
        race.determineLeader(cars);

        Car leader = race.getLeader();
        System.out.println("Самая быстрая машина: " + leader.getName());
    }
}