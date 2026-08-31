import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LeMansRaceFactory {
    private static final int CARS_LIMIT = 3;

    Scanner scanner = new Scanner(System.in);
    Set<Car> cars = new HashSet<>();
    Racing racing = new Racing();

    public void start() {
        System.out.println("Добро пожаловать на гонку!");
        for (int i = 1; i <= CARS_LIMIT; i++) {
            String carName = inputCarName(i);
            int carSpeed = inputCarSpeed(i);
            Car car = new Car(carName, carSpeed);
            cars.add(car);
            racing.calculateRaceLeader(car);
        }
        end();
    }

    private void end() {
        System.out.printf("Самая быстрая машина: %s", racing.getLeaderName());
        scanner.close();
    }

    private String inputCarName(int carNumber) {
        System.out.printf("Введите название машины №%d':%n", carNumber);
        String carName = scanner.next();

        while (!isCarNameValid(carName) || isCarNameExists(carName)) {
            System.out.printf("Название '%s' не подходит, выберите другое:%n", carNumber);
            carName = scanner.next();
        }
        return carName;
    }

    private int inputCarSpeed(int carNumber) {
        System.out.printf("Введите скорость машины №%d':%n", carNumber);
        int carSpeed = scanner.nextInt();

        while (!isCarSpeedValid(carSpeed)) {
            System.out.println("Неправильная скорость");
            carSpeed = scanner.nextInt();
        }
        return carSpeed;
    }

    private boolean isCarNameValid(String carName) {
        return carName != null && !carName.isBlank();
    }

    private boolean isCarNameExists(String carName) {
        return cars.stream().anyMatch(car -> car.getName().equals(carName));
    }

    private boolean isCarSpeedValid(int carSpeed) {
        return carSpeed > 0 && carSpeed <= 250;
    }
}
