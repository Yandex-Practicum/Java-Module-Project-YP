import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        int speedCar = 0;
        String nameCar = "";
        int successSpeed = 1;
        for (; successSpeed < 4; ) {

            System.out.println("Введите название машины №" + successSpeed);
            nameCar = scanner.next();
            System.out.print("Введите скорость машины №" + successSpeed);
            if (scanner.hasNextInt()) {
                speedCar = scanner.nextInt();
                if (0 < speedCar && speedCar <= 250) {
                    ++successSpeed;
                    }

                 else {
                    System.out.println("Некорректная скорость. Попробуйте еще раз.");
                }
            } else {
                scanner.next();
                System.out.println("некорректный ввод. Попробуйте еще раз.");
            }
            Car car = new Car(nameCar, speedCar);
            race.addCar(car);

        }


        String leader = race.getLeader();
        System.out.println("Самая быстрая машина: " + race.getLeader());

        scanner.close();

    }
}


