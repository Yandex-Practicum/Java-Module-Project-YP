import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String carName;
        int carSpeed;
        Scanner scanner = new Scanner(System.in);
        Race carLeaderRace = new Race();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название машины № " + i);
            carName = scanner.next();
            while (true){
                System.out.println("Введите скорость машины № " + i);
                carSpeed = scanner.nextInt();
                if (carSpeed >0 && carSpeed <=250) {
                    break;
                }
                System.out.println("Неправильная скорость");
            }
            Car carObject = new Car(carName,carSpeed);
            carLeaderRace.leaderCalculations(carObject);
        }
        System.out.println("Самая быстрая машина: " + carLeaderRace.carLeaderName);
        scanner.close();
    }
}


