import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите название авто " + (i + 1) + ":");
            String name = scanner.next();
            int speed;
            while (true) {
                System.out.println("Введите скорость авто " + (i + 1) + " от 0 до 250км/ч");
                speed = scanner.nextInt();
                if (speed <= 250) {
                    if (speed >= 0) {
                        break;
                    } else {
                        System.out.println("Скорость авто введена неправильно.Повторите ещё раз");
                        scanner.nextInt();
                    }
                }
            }

            Car car = new Car(name, speed);
            race.updateLeader(car);
        }
        System.out.println("Победитель на машине - " + race.getLeader());
        scanner.close();

    }
}
