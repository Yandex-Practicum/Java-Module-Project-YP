
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        ArrayList<Car> cars = new ArrayList<>();
        int maxSpeed = 0;

        for (int i = 1; i <= 3; i++) {

            String modelCar;
            int speed;

            System.out.printf("Введите название %d автомобиля:\n", i);
            modelCar = scanner.next();

            System.out.printf("Введите скорость %d автомобиля:\n", i);

            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка ввода");
                scanner.next();
                System.out.printf("Введите скорость %d автомобиля:\n", i);
            }

            speed = scanner.nextInt();

            while (speed < 0 || speed > 250) {
                System.out.println("Ошибка ввода. Скорость должна быть от 0 до 250 км/ч.");
                System.out.printf("Введите скорость %d автомобиля:\n", i);
                while (!scanner.hasNextInt()) {
                    System.out.println("Ошибка ввода");
                    scanner.next();
                    System.out.printf("Введите скорость %d автомобиля:\n", i);
                }
                speed = scanner.nextInt();
            }

            cars.add(new Car(modelCar, speed));
        }
        for (Car car : cars) {
            if (car.speed >= maxSpeed) {
                maxSpeed = car.speed;
                race.leader = car.modelCar;
            }
        }
        System.out.println("Лидер: " + race.leader);
    }
}