import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в самую реалистичную гонку во вселенной");

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            System.out.println("Укажи название автомобиля " + (i+1) + " ");
            String name = scanner.nextLine().trim();

            System.out.println("Укажи скорость автомобиля " + (i+1) + " " );
            int speed;
            do {
                try {
                    speed = Integer.parseInt(scanner.nextLine().trim());
                    if (speed >= 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Неправильно указал скорость. Введи число от 1 до 250");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Неправильно написал. Нужно указать число от 1 до 250");
                }
            } while (true);

                    cars.add(new Car(name, speed));
            }
                Race race = new Race(cars);
                race.printLeadInfo();
        }

    }