import java.util.Scanner; // Импортируем сканер для ввода с клавиатуры (В задании было написано, что для ввода данных поможет класс Scanner. Я посмотрел в задании, что нужны методы nextInt() для цифр и next() для слов, и подключил его, чтобы программа могла считывать мои ответы, просто я не помню изучали мы его или нет)

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать на гонку '24 часа Ле-Мана'!");

        Race race = new Race();
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название машины №" + i + ":");
            String carModel = scanner.next();

            int carSpeed = 0;

            while (true) {
                System.out.println("Введите скорость машины №" + i + " (от 0 до 250):");
                if (scanner.hasNextInt()) {
                    carSpeed = scanner.nextInt();

                    if (carSpeed > 0 && carSpeed <= 250) {
                        break;
                    } else {
                        System.out.println("Ошибка! Скорость должна быть больше 0 и не более 250.");
                    }
                } else {
                    System.out.println("Ошибка! Нужно ввести целое число.");
                    scanner.next();
                }
            }

            Car newCar = new Car(carModel, carSpeed);

            race.determineWinner(newCar);
        }

        System.out.println("--- Гонка завершена! ---");
        System.out.println("Самая быстрая машина: " + race.leaderName);
    }
}