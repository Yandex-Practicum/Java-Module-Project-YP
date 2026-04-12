import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        while (vehicles.size() < 3) {
            createVehicle();
        }

        evaluate();
    }


    private static void evaluate() {
        Vehicle speedy = getSpeedy();
        System.out.println("Самый быстрый автомобиль: " + speedy.name + " (" + speedy.speed + " км/ч)");
    }

    private static void createVehicle() {
        // Получаем данные от пользователя
        // Код не покрывает вариант исключения бесконечного цикла, нужно ввести все три автомобиля
        String name = getVehicleName();
        int speed = getVehicleSpeed();

        // Добавляем инстанс автомобиля
        vehicles.add(new Vehicle(name, speed));
    }

    private static String getVehicleName() {
        System.out.println("Введите название автомобиля №" + (vehicles.size() + 1) + ":");
        String name = scanner.nextLine();

        if (name.isEmpty()) {
            System.out.println("Название автомобиля не может быть пустым");
            return getVehicleName();
        }

        return name;
    }

    private static int getVehicleSpeed() {
        System.out.println("Введите скорость автомобиля №" + (vehicles.size() + 1) + " (км/ч):");
        int speed = Integer.parseInt(scanner.nextLine());

        if (speed <= 0 || speed > 250) {
            System.out.println("Введённая скорость должна быть больше 0 км/ч но и не более 250 км/ч");
            return getVehicleSpeed();
        }

        return speed;
    }

    private static Vehicle getSpeedy() {
        Vehicle speedy = new Vehicle("", -1);

        for (Vehicle vehicle : vehicles) {
            if (vehicle.speed > speedy.speed) {
                speedy = vehicle;
            }
        }

        return speedy;
    }
}

