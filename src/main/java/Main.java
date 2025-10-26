import java.util.Scanner;
public class Main {
    public static void main(String[] args){
    System.out.println("24 часа Ле-Мана");
    Scanner scanner = new Scanner(System.in);
    Car[] cars = new Car[3];
    Race race = new Race();

    for (int i = 0; i < cars.length; i++) {
        System.out.println("Автомобиль " + (i + 1) + ":");

        String name;
        while (true) {
            System.out.println("Введите название автомобиля: ");
            name = scanner.nextLine().trim();
            if(!name.isEmpty()){
                break;
            }
            System.out.println("Ошибка: название автомобиля не может быть пустым!");
        }

        int speed = 0;
        while (true) {
            System.out.println("Введите скорость автомобиля (1-250 км/ч): ");
            if (scanner.hasNextInt()) {
                speed = scanner.nextInt();
                scanner.nextLine();
                if (speed > 0 && speed <= 250) {
                    break;
                } else {
                    System.out.println("Скорость должна быть от 1 до 250.");
                }
            } else {
                System.out.println("Введите целое число");
                scanner.next();
            }
        }

        cars[i] = new Car(name, speed);
    }

    Car winner = race.raceWinner(cars);
        System.out.println("Самая быстрая машина: " + winner.getName());
}
}

