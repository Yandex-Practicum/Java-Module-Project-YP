import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        int speed = 0;
        for (int i = 1; i <= 3; i = i + 1) {
            System.out.println("Введите название машины №" + i);
            String brand = scanner.next();


            boolean validInput = false;
            while (!validInput) {
                System.out.println("Введите скорость машины №" + i);
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    if (speed >= 0 && speed <= 250) {
                        validInput = true;
                    } else {
                        System.out.println("Неправильная скорость");
                    }
                } else {
                    System.out.println("Неправильная скорость");
                    scanner.next();
                }
            }
            Auto auto = new Auto(brand, speed);
            race.updateWinner(auto.getBrand(), auto.getSpeed());
        }

        scanner.close();
        System.out.println(race.getCurrentWinner());
    }
}

