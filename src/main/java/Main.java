import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int currentParticipants = 1;
        final int maxParticipants = 3;
        final int maxSpeed = 250;
        final int minSpeed = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите трех участников гонки");
        while (currentParticipants <= maxParticipants) {
            String name;
            int speed;

            System.out.println("Введите название машины №" + currentParticipants + ":");
            name = scanner.next();

            while (true) {
                System.out.println("Введите скорость машины №" + currentParticipants + ":");
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    if (speed <= minSpeed || speed > maxSpeed) {
                        System.out.println("Введена неверная скорость");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Введена неверная скорость");
                    scanner.next();
                }
            }
            Race.identifyingTheLeader(name, speed);
            currentParticipants += 1;
        }
        System.out.println("Победитель гонки: " + Race.leaderBuffer);
    }
}