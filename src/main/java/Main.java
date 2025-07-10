import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        int numberOfCars = 3;


        for (int i = 0; i < numberOfCars; i++) {
            System.out.println("— Введите название машины №" + (i + 1) + ":");
            String name = scanner.nextLine();

            int speed;
            while (true) {
                System.out.println("— Введите скорость машины №" + (i + 1) + ":");
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    scanner.nextLine();
                    int minSpeed = 0;
                    int maxSpeed = 250;
                    if (speed > minSpeed && speed <= maxSpeed) {
                        break;
                    } else {
                        System.out.println("— Неправильная скорость");
                    }
                }
            }
            Auto car = new Auto(name, speed);
            race.checkNewLeader(car);
        }
        System.out.println("Самая быстрая машина: " + race.leader);
    }
}


class Auto {
    String name;
    int speed;

    Auto(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}


class Race {
    String leader = "";
    int distance = 0;

    void checkNewLeader(Auto car) {
        int time = 24;
        int carDistance = time * car.speed;

        if (carDistance > distance) {
            distance = carDistance;
            leader = car.name;
        }
    }
}