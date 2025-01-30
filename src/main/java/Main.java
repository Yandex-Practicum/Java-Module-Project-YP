import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Приветствую вас на гонке «24 часа Ле-Мана»!");
        Scanner scanner = new Scanner(System.in);
        Race carLeader = new Race();

        for (int i = 1; i <= 3; ++i) {
            System.out.println("— Введите название машины №" + i + ":");
            String inCarBrand = currectBrand(scanner);
            System.out.println("— Введите скорость машины №" + i + ":");
            int inCarSpeed = currectSpeed(scanner);
            carLeader.makeRace(new Car(inCarBrand, inCarSpeed));
        }

        if (carLeader.draw == 0) {
            System.out.println("Победитель гонки «24 часа Ле-Мана»: " + carLeader.leadRace);
            System.out.println("Финишировавшая машина проехала: " + carLeader.leadDistance + " км");
        } else {
            System.out.println("Победитель гонки «24 часа Ле-Мана» не установлен, так как ничья.");
            System.out.println("Максимальное расстояние пройденное за гонку: " + carLeader.leadDistance);
        }
    }

    public static int currectSpeed(Scanner scanner1) {
        while (true) {
            if (scanner1.hasNextInt()) {
                int carSpeed = scanner1.nextInt();
                scanner1.nextLine();
                if (carSpeed >= 0 && carSpeed <= 250) {
                    return carSpeed;

                } else {
                    System.out.println("Неправильная скорость. Введите скорость в диапозоне от 0 до 250.");

                }
            } else {
                System.out.println("Некорректный ввод. Введите скорость в целочисленном диапозоне от 0 до 250.");
                scanner1.nextLine();
            }
        }
    }

    public static String currectBrand(Scanner scanner2) {
        while (true) {
            String carBrand = scanner2.nextLine().trim();
            if (!carBrand.isEmpty()) {
                return carBrand;
            }
            else  {
                System.out.println("Вы оставили поле пустым, попробуйте ввести название машины еще раз: ");
            }
        }
    }

}
