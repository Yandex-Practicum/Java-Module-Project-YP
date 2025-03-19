import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Приветствуем тебя на этой гонке!");
        Scanner scanner = new Scanner(System.in);
        Car carOne = new Car();
        Car carTwo = new Car();
        Car carThree = new Car();

        System.out.println(" Ввод данных для первой машины ");
        carOne.name = checkName(scanner);
        carOne.speed = checkSpeed(scanner);

        System.out.println(" Ввод данных для второй машины ");
        carTwo.name = checkName(scanner);
        carTwo.speed = checkSpeed(scanner);

        System.out.println(" Ввод данных для третьей машины ");
        carThree.name = checkName(scanner);
        carThree.speed = checkSpeed(scanner);

        Race race = new Race();
        race.startRace(carOne, carTwo, carThree);

        scanner.close();
    }

    public static String checkName(Scanner scanner) {
        while (true) {
            System.out.print("Введите название машины (без цифр): ");
            String name = scanner.nextLine();

            if (name.matches("[a-zA-Zа-яА-Я]+")) {
                System.out.println("Машина принята в гонку!");
                return name;
            } else {
                System.out.println("Ошибка! Введите только буквы.");
            }
        }
    }

    public static int checkSpeed(Scanner scanner) {
        while (true) {
            System.out.print("Введите скорость от 0 до 250");
            if (scanner.hasNextInt()) {
                int speed = scanner.nextInt();
                scanner.nextLine();
                if (speed >= 0 && speed <= 250) {
                    return speed;
                } else {
                    System.out.println("Ошибка! Число должно быть от 0 до 250");
                }
            } else {
                System.out.println("Ошибка! Введите только число.");
                scanner.next();
            }
        }
}
}
