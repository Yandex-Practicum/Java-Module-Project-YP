import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        System.out.println("Старт гонки 24 часа Ле-Мана!");

        int numCars = 3;
        for (int i = 1; i <= numCars; i++) {
            System.out.println(" Ввод данных для автомобиля:" + i);
            System.out.print("Введите название автомобиля: ");
            String carName = scanner.next();

            int carSpeed = 0;
            while (true) {
                System.out.print("Введите скорость (от 0 до 250 км/ч): ");

                if (scanner.hasNextInt()) {
                    int inputSpeed = scanner.nextInt();

                    if (inputSpeed >= 0 && inputSpeed <= 250) {
                        carSpeed = inputSpeed;
                        break;
                    } else {
                        System.out.println("Ошибка: Скорость должна быть от 0 до 250. Попробуйте снова.");
                    }
                } else {
                    System.out.println("Ошибка: Введите корректное целое число.");
                    scanner.next();
                }
            }
            Car newCar = new Car(carName, carSpeed);
            race.Leader(newCar);
        }
        System.out.println("Финиш! Результаты гонки: -");
        System.out.println("Самая быстрая машина : " + race.getLeader());

        scanner.close();
    }
}




