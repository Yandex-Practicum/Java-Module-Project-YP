import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int maxParticipants = 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите трех участников гонки");
        while (maxParticipants <= 3) {
            String name;
            int speed;

            System.out.println("Введите название машины №" + maxParticipants + ":");
            name = scanner.next();

            while (true) {
                System.out.println("Введите скорость машины №" + maxParticipants + ":");
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    if (speed <= 0 || speed > 250) {
                        System.out.println("Введена неверная скорость");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Введена неверная скорость");
                    scanner.next();
                }
            }
            Race.participantsArray(name, speed);
            maxParticipants += 1;
        }
        System.out.println("Победитель гонки: " + Race.identifyingTheLeader());
    }
}