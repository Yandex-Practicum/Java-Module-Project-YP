import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car[] cars = new Car[3];
        Race race = new Race();

        for (int i = 0; i < cars.length; i++) {
            Car car = new Car();

            while (true) {
                System.out.println("Введите название машины №" + (i + 1) + ": ");
                car.name = sc.nextLine().trim();
                if (!car.name.isEmpty()) {
                    break;
                } else {
                    System.out.println("Название не может быть пустым. Попробуйте снова.");
                }
            }

            while (true) {
                System.out.println("Введите скорость машины №" + (i + 1) + ": ");
                String input = sc.nextLine().trim();

                try {
                    final int minSpeed=0;
                    final int maxSpeed=250;
                    if (input.isEmpty()) {
                        throw new IllegalArgumentException("Скорость не может быть пустой. Попробуйте снова.");
                    }

                    car.speed = Integer.parseInt(input);

                    if (car.speed <= minSpeed || car.speed > maxSpeed) {
                        throw new IllegalArgumentException("Скорость должна быть от 1 до 250. Попробуйте снова.");
                    }

                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод. Введите целое число.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            cars[i] = car;
            race.updateLeader(car);
        }

        for (Car car : cars) {
            System.out.println("Участник гонки: " + car.name + ", Скорость: " + car.speed + ".");
        }

        System.out.println("Наш победитель: " + race.getLeader());
    }
}

class Car {
    String name;
    int speed;

    public int calculateDistance(int hours) {
        return speed * hours;
    }
}
