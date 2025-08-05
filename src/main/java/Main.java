import java.util.Scanner;
class Car {
    String name;
    int speed;
    Car(String carName, int carSpeed) {
        this.name = carName;
        this.speed = carSpeed;
    }
}
class Race {
    String leader;
    int distance = 0;

    public void calculate(Car car) {
        int dis = 24 * car.speed;
        if (distance < dis) {
            distance = dis;
            leader = car.name;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Race granPriMonaco = new Race();
        Scanner scanner = new Scanner(System.in);
        int i;
        for (i = 1; i <= 3; i++) {
            System.out.println("- Введите название машины №" + i + ":");
            String name = scanner.next();
            int speed;
            while (true) {
                System.out.println("Введите скорость машины №" + i + ":");
                speed = scanner.nextInt();
                if ((0 > speed) || (speed > 250)) {
                    System.out.println("Неправильная скорость");
                } else {
                    break;
                }
            }
            Car result = new Car(name, speed);
            granPriMonaco.calculate(result);
        }
        System.out.println("Самая быстрая машина: " + granPriMonaco.leader);
    }
}