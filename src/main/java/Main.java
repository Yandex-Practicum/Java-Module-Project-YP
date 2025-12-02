import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        for (int i = 0; i < 3; i++){
            System.out.println("Введите название машины под номером " + (i + 1));
            String name = scanner.nextLine();
            int speed;
            while (true){
                System.out.println("Введите скорость машины " + (i + 1));
                String input = scanner.nextLine();
                if (vNumber(input)) {
                    speed = Integer.parseInt(input);
                    if  (speed > 0 && speed <= 250){
                        break;
                    } else {
                        System.out.println("Неккоретная скорость");
                    }
                }
                else {
                    System.out.println("Неккоретная скорость");
                }
            }
            Car car = new Car(name, speed);
            race.whoLeader(car);
        }
        System.out.println("Самой быстрой оказалась машина - " + race.lName());
    }
    private static boolean vNumber(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}