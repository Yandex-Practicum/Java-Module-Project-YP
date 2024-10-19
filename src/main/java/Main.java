import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        for(int i = 1; i < 4; i++) {
            System.out.println("Введите название машины №" + i);
            String nameCar = scanner.next();
            int speedCar;
            while (true) {
                System.out.print("Введите скорость машины №" + i);
                speedCar = scanner.nextInt();
                if (speedCar > 0 && speedCar <= 250) {
                    break;
                } else {
                    System.out.println("Некорректная скорость. Попробуйте еще раз.");
                }
            }

            Car car = new Car(nameCar, speedCar);
            race.addCar(car);
        }

        String leader = race.getLeader();
        System.out.println("Самая быстрая машина: " + race.getLeader());

        scanner.close();

    }
}
