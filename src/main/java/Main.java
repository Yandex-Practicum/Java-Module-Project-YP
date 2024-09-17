import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int carsNumber = 3;
        int minSpeed = 0;
        int maxSpeed = 250;

        Race race = new Race();
        Car currentCar = new Car();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < carsNumber; i++){

            System.out.println("Введите название машины №" + (i + 1));
            currentCar.name = scanner.next();
            System.out.println("Введите скорость машины №" + (i + 1));

            while (currentCar.speed == 0){

                while (!scanner.hasNextInt()){
                    System.out.println("Неправильная скорость");
                    System.out.println("Введите скорость машины №" + (i + 1));
                    scanner.next();
                }

                currentCar.speed = scanner.nextInt();

                if (currentCar.speed <= minSpeed || currentCar.speed > maxSpeed){
                    System.out.println("Неправильная скорость");
                    System.out.println("Введите скорость машины №" + (i + 1));
                    currentCar.speed = 0;
                }

            }

            race.whoIsTheLeader(currentCar);
            currentCar.speed = 0;
        }

        System.out.println("Самая быстрая машина: " + race.currentLider);
        scanner.close();

    }
}
