import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать на одну из самых известных автогонок в мире — 24 часа Ле-Мана");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Car> cars = new ArrayList<>();
        int i = 1;
        while (i <= 3) {
            System.out.println("Введите название машины №" + i + ":");
            String name = "";
            while (true) {
                if (scanner.hasNextLine()){

                    name = scanner.nextLine();
                    if (!name.trim().isEmpty()){
                        System.out.println(name);
                        break;
                    } else {
                        System.out.println("Название не должно быть пустым!");
                        System.out.println("Введите название машины №" + i + ":");
                    }
                } else {
                    System.out.println("Название не должно быть пустым!");
                    System.out.println("Введите название машины №" + i + ":");
                }
            }

            System.out.println("Введите скорость машины №" + i + ":");
            int speed;
            while (true){
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    if (speed > 0 && speed < 250){
                        System.out.println(speed);
                        break;
                    } else {
                        System.out.println("Неверно указана скорость");
                        System.out.println("Введите скорость машины №" + i + ":");
                    }

                } else {
                    System.out.println("Неверно указана скорость");
                    System.out.println("Введите скорость машины №" + i + ":");
                    scanner.next();
                }
            }

            cars.add(new Car(name, speed));
            i++;
        }
        scanner.close();
        new Race().resultRace(cars);

    }
}