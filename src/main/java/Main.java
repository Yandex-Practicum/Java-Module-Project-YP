import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        int i = 3;
        Car[] cars = new Car[i];
        int speed;

        Scanner scanner = new Scanner(System.in);
for (i = 0; i < 3; i++) {
    System.out.println("Название машины № " + (i + 1) + ":");
    name = scanner.next();


    while (true) {
        System.out.println("Скорость машины № " + (i + 1) + " в км/ч:");
        if(!scanner.hasNextInt()) {
            speed = scanner.nextInt();
            System.out.println("Введите целочисленное значение.");

        } else speed = scanner.nextInt();
            if (speed <= 250 && speed > 0) {
            break;
        }
        System.out.println("Введено некорректное значение скорости.");
    }
    cars[i] = new Car(name, speed);
}
        Race race = new Race();
        race.determineLeader(cars);

        Car leader = race.getLeader();
        System.out.println("Самая быстрая машина: " + leader.name());
        scanner.close();
    }
}