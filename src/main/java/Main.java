import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            String name;
            while (true) {
                System.out.println("Введите название машины №" + (i + 1) + ": ");
                name = scanner.nextLine();
                if (!name.trim().isEmpty()) {
                    break;
                } else {
                    System.out.println("Название машины не может быть пустым, попробуй снова.");
                }
            }

            int speed;
            while (true) {
                System.out.println("Введите скорость машины №" + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    scanner.nextLine();
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Некорректная скорость машины, попробуй ещё раз");
                    }
                } else {
                    System.out.println("Введено не число, попробуй снова.");
                    scanner.next();
                }
            }

            Car car = new Car(name, speed);
            cars.add(car);
        }

        Car winerCar = null;

        int maxDistance = 0;

        for (Car car : cars) {
            int distance = car.scoreKillometrs24();
            System.out.println("Машина: " + car.getName() + ", Скорость: " + car.getSpeed() + " км/ч" + " Проехала за 24 часа: " + distance);

            if (distance > maxDistance) {
                maxDistance = distance;
                winerCar = car;
            }
        }
        System.out.println("Победила машина: " + winerCar.name);
    }
}