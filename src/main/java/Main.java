import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 0; i < 3; i++) {

        System.out.println("Введите данные машины:");
        String name = scanner.next();

        System.out.println("Приветствуем, " + name + "!");


        int speed;
        while (true) {
        System.out.println("Насколько скоростная ваша малышка?");
        speed = scanner.nextInt();
        System.out.println("Вайвай! " + speed + "!");
        if (speed >= 0 && speed <= 250) {
            break;
        }
        else {
            System.out.println("Ошибка! Скорость должна быть от 0 до 250.");
        }
}
        Car car = new Car(name, speed);
        race.leaderNumber(car);
    }

        System.out.println("Победитель гонки: " + race.getLeaderName());
        System.out.println("Дистанция: " + race.getLeaderDistance() + " км");
}
}