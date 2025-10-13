import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[3];
        Race race = new Race();

        for (int i = 0; i < cars.length; i++) {
            System.out.println("Введите название автомобиля " + (i + 1) + ":");
            String name = scanner.nextLine();

            while (name.trim().isEmpty()) {
                System.out.println("текст отсутствует");
                name = scanner.nextLine();
            }

            int speed = 0;
            while (true) {
                System.out.println("Введите скорость автомобиля " + (i + 1) + ":");
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    if (speed >= 0 && speed <= 250) {
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println("Скорость должна быть от 0 до 250.");
                    }
                } else {
                    System.out.println("Введите целое число.");
                    scanner.next();
                }
            }

            cars[i] = new Car(name, speed);
        }

        Car winner = race.findWinner(cars);
        System.out.println("Самая быстрая машина: " + winner.getName());
    }
}

class Car {
    private String name;
    private int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int distanceFor24h() {
        return speed * 24;
    }
}

class Race {
    public Car findWinner(Car[] cars) {
        Car winner = cars[0];
        int maxDistance = cars[0].distanceFor24h();

        for (int i = 1; i < cars.length; i++) {
            int currentDistance = cars[i].distanceFor24h();
            if (currentDistance > maxDistance) {
                maxDistance = currentDistance;
                winner = cars[i];
            }
        }
        return winner;
    }
}