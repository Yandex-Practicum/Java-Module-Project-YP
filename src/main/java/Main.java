import java.util.Scanner;

class Car {
    int speed;
    String carName;
    public Car(String carName, int speed) {
        this.carName = carName;
        this.speed = speed;
    }
}

class Race {
    String leaderName;
    int distance = 0;
    public void takeLeader(Car car) {
        int distance = car.speed * 24;
        if (this.distance < distance) {
            this.leaderName = car.carName;
            this.distance = distance;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String carName;
        int speed;
        Race race = new Race();
        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название автомобиля № " + i);
            carName = scanner.next();
            while (true) {
                System.out.println("Введите скорость автомобиля № " + i);
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    if (speed > 0 && speed <= 250) {
                        break;
                    }
                    else {
                        System.out.println("Пожалуйста, введите корректную скорость. Повторите ввод!");
                    }
                }
                else {
                    scanner.next();
                    System.out.println("Пожалуйста, введите целое число. Повторите ввод!");
                }

            }
            Car car = new Car(carName, speed);
            race.takeLeader(car);
        }
        System.out.println("Лидер гонки - автомобиль '" + race.leaderName + "'");
    }
}


