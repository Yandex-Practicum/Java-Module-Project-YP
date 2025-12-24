import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            System.out.println(String.format("Введите название %d автомобиля: ", i));
            String carName = scanner.nextLine();

            while (true) {
                System.out.println(String.format("Введите скорость %d автомобиля: ", i));

                if (!scanner.hasNextInt()){ // Проверка на ввод не цифр
                System.out.println("Скорость должна быть целым числом");
                scanner.next();
                continue;
            }

                int carSpeed = scanner.nextInt();
                scanner.nextLine();

                if (carSpeed > 0 && carSpeed <= 250) { // Проверка диапазона скорости
                    Car car = new Car(carName, carSpeed);
                    cars.add(car);
                    break;
                }
                else {
                    System.out.println("Скорость должна быть от 0 до 250");
                }

            }
        }
        System.out.println("Список участников гоки: ");
        for (Car car : cars){
            System.out.println(String.format("Название: %s, Скорость: %d", car.carName, car.carSpeed));
        }
        Race race = new Race();

        Car leader = race.getLeader(cars);
        System.out.println("Самая быстрая машина: " + leader.carName);


    }
}