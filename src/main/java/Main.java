import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String carName = "";
        Race race = new Race();
        int carSpeed = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            boolean checkName = false;
            while (!checkName) {
                System.out.println("Введите название машины: ");
                carName = scanner.nextLine().trim();
                if (carName.isEmpty()) {
                    System.out.println("Вы ничего не ввели. Введите еще раз");
                } else {
                    checkName = true;
                }
            }
            boolean check = false;
            while (check == false) {
                System.out.println("Введите скорость машины: ");
                String scanner1 = "";
                boolean chekScanner = false;
                while (!chekScanner) {
                    scanner1 = scanner.nextLine().trim();
                    if (scanner1.isEmpty()) {
                        System.out.println("Вы ничего не ввели. Введите еще раз.\n Введите скорость от 1 да 250 км/ч");
                    } else {
                        chekScanner = true;
                    }
                }
                try {
                    carSpeed = Integer.parseInt(scanner1);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка,введите целое число");
                    continue;
                }

                if (carSpeed > 0 && carSpeed <= 250) {
                    Car carWinner = new Car(carName, carSpeed);
                    check = true;
                   race.calculate(carWinner);
                } else {
                    System.out.println("Введины неправильные данные, введите дааные заново");

                }
            }
            race.winner = race.getWinner();

        }

        System.out.println("Победитель: " + race.winner);
    }

}
