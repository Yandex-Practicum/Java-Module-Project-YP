import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {

            String name;

            while (true) {
                System.out.println("Введите название автомобиля под номером " + i + ":");
                name = scanner.nextLine().trim();

                if (!name.isEmpty()) {
                    break;
                }

                System.out.println("Название не может быть пустым");
            }

                int speed;

                while (true) {
                    System.out.println("Введите скорость автомобиля под номером " + i + ":");

                    if (scanner.hasNextInt()) {
                        speed = scanner.nextInt();
                        scanner.nextLine();

                        if (speed > 0 && speed <= 250) {
                            break;
                        } else {
                            System.out.println("Неверная скорость. Скорость должна быть от 1 до 250");
                        }
                    } else {
                        System.out.println("Ошибка. Нужно ввести целое число");
                        scanner.next();
                    }
                }
                Car car = new Car(name, speed);
                race.defineLeader(car);
            }
            System.out.println("Победитель гонки: " + race.leader + "!");
        }
    }