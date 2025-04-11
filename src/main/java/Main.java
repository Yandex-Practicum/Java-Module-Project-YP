
     import java.util.Scanner;
     import java.util.InputMismatchException;     class   Car {
        String name;
         int speed;

         public Car(String name, int speed) {
             this.name = name;
             this.speed = speed;}
        public String getName() {
             return name;}
         public int getSpeed() {
             return speed;}
         public double distanceIn24Hours() {
             return speed * 24;}
     }
     class Race {
         Car[] cars;
         public Race(Car[] cars) {this.cars = cars;}
         public Car findWinner() {
             Car winner = cars[0];
             for (Car car : cars) {
                 if (car.distanceIn24Hours() > winner.distanceIn24Hours()) {
                     winner = car;}
             }
             return winner;}
     }
        public class Main {

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                Car[] cars = new Car[3];

                for (int i = 0; i < 3; i++) {
                    String carName;
                    int carSpeed;

                    System.out.println("Введите название машины №" + (i + 1) + ":");
                    carName = scanner.next();

                    while (true) {
                        System.out.println("Введите скорость машины №" + (i + 1) + " (должна быть > 0 и <= 250):");
                        try {
                            carSpeed = scanner.nextInt();

                            if (carSpeed > 0 && carSpeed <= 250) {
                                break;
                            } else {
                                System.out.println("Ошибка: скорость должна быть > 0 и <= 250. Попробуйте снова.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Ошибка: введено некорректное значение. Пожалуйста, введите целое число.");
                            scanner.next();
                        }
                    }

                    cars[i] = new Car(carName, carSpeed);
                }

                Race race = new Race(cars);
                Car winner = race.findWinner();

                System.out.println("Самая быстрая машина: " + winner.getName());

                scanner.close();

            }
        }




