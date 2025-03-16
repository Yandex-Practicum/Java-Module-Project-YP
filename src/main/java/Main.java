import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        int speed = 0;
        Race race = new Race();

        System.out.println("Привет! Введите названия и скорость 3-х автомобилей, участвующих в гонке.");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Название автомобиля №" + i + ":");
            name = scanner.next();

            while (true) {
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    if (speed > 0 && speed <= 250) {
                        break;
                    }
                } else {
                    System.out.println("Ошибка! Скорость должна быть от 0 до 250 км/ч.");
                } else {
                    System.out.println("Ошибка! Скорость должна быть целочисленным значением.");
                }
            }

            Auto auto = new Auto(name, speed);
            race.findNewLeader(auto);
        }
        System.out.println("Победитель гонки «24 часа Ле-Мана»: " + race.leader);
    }
}
