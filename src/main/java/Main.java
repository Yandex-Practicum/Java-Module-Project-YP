import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            String name;
            //проверим что пользовател ввел название машины а не пусто
            while (true) {
                System.out.println("Введите название машины №" + i + ":");
                name = scanner.nextLine().trim();
                if (!name.isEmpty()) {
                    break;
                }
                System.out.println("Название машины не может быть пустым!");
            }

            int speed;
            //проверяем правильность ввода скорости иначе выкидываем ошибку
            while (true) {
                System.out.println("Введите скорость машины №" + i + ":");
                try {
                    speed = Integer.parseInt(scanner.nextLine());
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Неправильная скорость (должна быть от 1 до 250)");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Неправильная скорость (введите целое число)");
                }
            }

            Car car = new Car(name, speed);
            race.determineLeader(car);
        }

        System.out.println("Самая быстрая машина: " + race.getLeaderName());
    }
}