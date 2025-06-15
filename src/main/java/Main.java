import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            String name;
            int speed;

            while (true) {
                System.out.println("— Введите название машины №" + i + ":");
                name = scanner.next();

                if (name.isBlank()) {
                    System.out.println("Укажите не пустое название автомобиля!");
                } else {
                    while (true) {
                        System.out.println("— Введите скорость машины №" + i + ":");

                        if (scanner.hasNextInt()) {
                            speed = scanner.nextInt();
                            if (speed <= 0 || speed > 250) {
                                System.out.println("Укажите скорость в диапазоне от 0 до 250!");
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("Введите числовое значение!");
                            scanner.next();
                        }
                    }
                    break;
                }
            }
            Car car = new Car(name, speed);
                System.out.println(race.returnLeader(car).name);
        }
        scanner.close();
    }

}