import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RaceCars raceCars = new RaceCars();
        RaceTournament tournament = new RaceTournament();

        for (int i = 1; i <= 3; i++) {

            String carName = getCarName(i);
            int carSpeed = getCarSpeed(i);

            raceCars.carsSpecs.put(carName, carSpeed);
        }

        System.out.println("Текущие участники: " + raceCars.carsSpecs);
        tournament.startTournament(raceCars);
    }

    private static String getCarName(int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n— Введите название машины №%d:\n", i);
        String input;

        if (scanner.hasNext()) {
            input = scanner.next();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("\n— Неправильное название\n");
                input = getCarName(i);
            }
        } else {
            System.out.println("\n— Неправильное название\n");
            input = getCarName(i);
        }
        return input;
    }

    private static int getCarSpeed(int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n— Введите скорость машины №%d:\n", i);
        int input = -1;

        if (scanner.hasNextInt()) {
            input = scanner.nextInt();
            if (input >= 0 && input <= 250) {
                return input;
            } else {
                System.out.println("\n— Неправильная скорость\n");
                input = getCarSpeed(i);
            }
        } else {
            System.out.println("\n— Неправильная скорость\n");
            input = getCarSpeed(i);
        }
        return input;
    }
}