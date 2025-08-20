import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            String name;
            while (true) {
                System.out.println("Введите название автомобиля № " + i);
                name = scanner.nextLine();

                if (!name.isEmpty()) {
                    break;

                } else {
                    System.out.println("Название не должно быть пустым");
                }
            }


            int speed;
            while (true) {
                System.out.println("Введите скорость автомобиля в диапазоне от 0 до 250 км/ч");

                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    scanner.nextLine();
                    if (speed >= 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Введите корректное значение");
                    }
                } else {
                    System.out.println("Введите корректное значение");
                    scanner.next();
                }
            }

            Car car = new Car(name, speed);

            race.checkWinner(car);

        }
        System.out.println("Самая быстрая машина: " + race.getWinner());
        scanner.close();

    }
}