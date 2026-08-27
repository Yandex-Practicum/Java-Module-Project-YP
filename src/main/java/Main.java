import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Race race = new Race();

        for (int i = 1; i < 4; i++ )
        {
            Car car = readCar(i);
            race.addPlayer(car.name, car.speed);
        }

        System.out.println("Самая быстрая машина: " + race.leedName);
    }

    private static Car readCar(int number)
    {
        System.out.println("Введите название авто № " + number);
        String name;
        while (true) {

            name = scanner.next();
            if (checkName(name)) {
                break;
            }

        }
        int speed;

        System.out.println("Введите скорость авто № " + number);

        while (true) {

            speed = checkSpeed(scanner.next());
            if (speed > 0) {
                break;
            }
        }

        return new Car(name, speed);

    }

    private static Boolean checkName(String name)
    {
        if (name.trim().isEmpty()) {
            System.out.println("Название автомобиля не должно быть пустым, повторите попытку:");
            return false;
        }

        return true;
    }

    private static int checkSpeed(String speed)
    {
        int number = -1;
        if (speed.trim().isEmpty()) {
            System.out.println("Скорость не должна быть пустым значением, повторите попытку:");
            return 0;
        }

        try {
            number = Integer.parseInt(speed);
        } catch (NumberFormatException e) {
            System.out.println("Некорректное число, повторите попытку: ");
            return -1;
        }

        if (number > 0 && number < 250)
        {
            return  number;
        }

        System.out.println("Ожидается скорость > 0 и < 250, повторите попытку: ");
        return -1;

    }
}