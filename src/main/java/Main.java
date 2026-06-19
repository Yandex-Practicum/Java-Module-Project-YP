import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название машины №" + i + ":");
            String name;
            while (true) {
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Ошибка: название не может быть пустым. \nПопробуйте снова:");
                } else {
                    break;
                }
            }

            System.out.println("Введите скорость машины №" + i + ":");
            int speed;
            while (true) {
                String speedInput = scanner.nextLine().trim();
                try {
                    speed = Integer.parseInt(speedInput);
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Ошибка: скорость должна быть от 1 до 250. \nПопробуйте снова:");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите целое число. \nПопробуйте снова:");
                }
            }

            Car car = new Car(name, speed);
            race.checkLeader(car);
        }

        String winner = race.getLeaderName();
        System.out.println("Самая быстрая машина: " + winner);

        scanner.close();
    }
}