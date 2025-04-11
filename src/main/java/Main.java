import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberOfСars = 3; //количество машин участвующих в гонке
        ArrayList<Car> listOfCar = new ArrayList<>();
        Scanner sr = new Scanner(System.in);

        for (int i = numberOfСars; i > 0; i--) {

            String carName;
            while (true) {
                System.out.println("Введите название машины №" + (numberOfСars - i + 1));
                carName = sr.nextLine();
                if (carName != null && !carName.isEmpty() && !carName.trim().isEmpty()) {
                    break;
                } else System.out.println("Введено не корректное значение пропробуйте снова");
            }

            int carSpeed;
            while (true) {
                System.out.println("Введите скорость машины №" + (numberOfСars - i + 1));
                String carSpeedString = sr.nextLine();
                if (isNumber(carSpeedString)) {
                    if (Integer.parseInt(carSpeedString) > 0 && Integer.parseInt(carSpeedString) <= 250) {
                        carSpeed = Integer.parseInt(carSpeedString);
                        break;
                    } else System.out.println("Введено не корректное значение пропробуйте снова");
                } else System.out.println("Введено не корректное значение пропробуйте снова");
            }

            Car car = new Car(carName, carSpeed);
            listOfCar.add(car);
        }

        Race race = new Race(listOfCar);
        race.resultRace();
        sr.close();

    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
