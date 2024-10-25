import java.util.Scanner;

public class Main {
    private static final int FIRST_CAR = 1;
    private static final int SECOND_CAR = 2;
    private static final int THIRD_CAR = 3;
    private static final int MIN_SPEED = 0;
    private static final int MAX_SPEED = 250;

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в самую реалистичную гоночную игру!");
        Scanner scanner = new Scanner(System.in);

        Car carOne = getCarFromUser(scanner, FIRST_CAR);
        Car carTwo = getCarFromUser(scanner, SECOND_CAR);
        Car carThree = getCarFromUser(scanner, THIRD_CAR);

        defineLeaderAndTextOut(carOne, carTwo, carThree);
    }

    public static Car getCarFromUser(Scanner scanner, int carNumber) {
        String carModel = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Введите название машины № " + carNumber);
            carModel = scanner.nextLine().trim();
            if (!carModel.isEmpty()) {
                isValid = true;
            } else {
                System.err.println("Ошибка: Недопустимое название автомобиля. Пожалуйста, попробуйте снова.");
            }
        }

        int carSpeed;
        System.out.println("Введите скорость машины № " + carNumber);
        do {
            try {
                carSpeed = Integer.parseInt(scanner.nextLine());
                if (carSpeed < MIN_SPEED || carSpeed > MAX_SPEED) {
                    System.out.println("Введите корректную скорость машины № " + carNumber + "!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Ошибка ввода: скорость должна быть целым числом.");
            }
        } while (true);

        return new Car(carSpeed, carModel);
    }

    public static void defineLeaderAndTextOut(Car one, Car two, Car three) {
        Race.defineLeaderFromParticipants(one, two, three);
        Car raceLeader = Race.getLeader();
        System.out.println("Гонку выиграл автомобиль " + raceLeader.getModel());
    }
}
