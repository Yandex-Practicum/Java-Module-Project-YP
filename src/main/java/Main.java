import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        for (int i = 1; i <= 3; i++) {
            String name = "";
            while (true) {
                System.out.println("Введите название машины №" + i + ":");
                name = scanner.nextLine().trim();
                if (!name.isEmpty()) {
                    break;
                }
                System.out.println("Неправильное название");
            }
            int speed =0;
            while (true) {
                System.out.println("Введите скорость машины №"+ i + ":");
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    scanner.nextLine();
                    if (speed > 0 && speed <= 250) {
                        break;
                    }
                } else {
                    scanner.nextLine();
                }
                System.out.println("Неправильная скорость");
            }
            Car car = new Car(name, speed);
            race.formula(car);
        }
        System.out.println("Самая быстрая машина: "+ race.leaderName);
        scanner.close();
    }
}