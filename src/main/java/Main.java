import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название машины №" + i + ":");
            String name = scanner.nextLine().trim();

            while (name.isEmpty()) {
                System.out.println("Произошла ошибка. Введите ещё раз:");
                name = scanner.nextLine().trim();
            }

            int speed;
            while (true) {
                System.out.println("Введите скорость машины №" + i + ":");
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    scanner.nextLine(); // очищаем буфер
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Неправильная скорость. Введите число от 1 до 250.");
                    }
                } else {
                    System.out.println("Неправильная скорость. Введите целое число.");
                    scanner.nextLine(); // очищаем неправильный ввод
                }
            }

            Car car = new Car(name, speed);
            race.updateLeader(car);
        }

        System.out.println("Самая быстрая машина: " + race.getLeaderName());
        scanner.close();
    }
}
