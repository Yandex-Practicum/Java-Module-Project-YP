import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Скнер для ввода данных.
        Car[] cars = new Car[3]; // Массив размерностью в 3 машинки могламно условию.

        for (int i = 0; i < cars.length; i++){
            System.out.println("Введите название автомобиля № " + (i + 1) + ":");
            String name = scanner.nextLine();

            int speed;
            while (true) {
                System.out.println("Введите его скорость (1–250):");
                speed = scanner.nextInt();
                scanner.nextLine(); //Странно что в JAVA nextInt() не очищает буффер ввода!!!!!!

                if (speed >0 && speed <=250){
                    break;
                }
                else {
                    System.out.println("Задана неверная скорость. Скорость должна быть в диапазоне от 1 до 250 км/ч. Попробуйте снова.");
                }
            }
            cars[i] = new Car(name, speed);
        }

        Race race = new Race();
        ArrayList<Car> leaders = race.getRaceLeaders(cars);
        if (leaders.size() == 1){
            System.out.println("Лидер гонки \"24 часа Ле-Ман\": " + leaders.getFirst().getName() + ", он проехал - " + leaders.getFirst().getDistanceIn24Hours() + " км.");
        }
        else {
            System.out.println("Лидеры гонки \"24 часа Ле-Ман\": ");
            for (Car leader: leaders){
                System.out.println("* " + leader.getName() + ", он проехал - " + leader.getDistanceIn24Hours() + " км.");
            }
        }
    }
}