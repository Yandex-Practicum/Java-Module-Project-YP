import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Race race = new Race();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Car> cars = new ArrayList<>();
        int raceParticipants;

        while (true) {
            System.out.println("Введите количество участников: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка ввода");
                scanner.next();
            }
            else {
                raceParticipants = scanner.nextInt();
                scanner.nextLine();
                break;
            }
        }

        for (int i = 1; i <= raceParticipants; i++) {

            System.out.println(String.format("Введите название %d машины: ", i));
            String name = scanner.nextLine();

            while (true){
                System.out.println(String.format("Введите скорость %d машины: ", i));
                if (!scanner.hasNextInt()){
                    System.out.println("Ошибка - Скорость должна быть целым числом");
                    scanner.next();
                    continue;
                }

                int speed = scanner.nextInt();
                scanner.nextLine();

                if (speed > 0 && speed <= 250){
                    Car car = new Car(name, speed);
                    cars.add(car);
                    break;
                }
                else {
                    System.out.println("Ошибка - Скорость должна быть выше 0 и меньше 251");
                }
            }
        }

        System.out.println("Список участников гонки: ");
        for (Car getCar : cars) {
            System.out.println(String.format("Название - %s; Скорсть - %d", getCar.name, getCar.speed));
        }

        Car winner = race.getLeader(cars);
        System.out.println("Победитель " + winner.name);
    }
}