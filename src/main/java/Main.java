import java.util.Scanner;
public class Main {
    static Car[] carList = new Car[3];
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать на гонки 24 часа Ле-Мана");
        String carmodel;
        int speed = 0;
        String input;
        for (int i = 0; i <= 2; i++) {
            while (true) {
                System.out.println("Введите марку " + (i + 1) + "-й  машины");
                carmodel = scanner.nextLine();
                if (!(carmodel == null) && !carmodel.isBlank()) {
                    break;
                } else {
                    System.out.println("Невалидное значение, введите текст");
                }
            }
            while (true) {
                System.out.println("Введите скорость " + (i + 1) + "-й машины");
                if (scanner.hasNextLine()) {
                    input = scanner.nextLine();
                    if (!input.isBlank() && !input.contains(".") && input.matches("\\d+")) {
                        speed = Integer.parseInt(input);
                    } else {
                        System.out.println("Невалидное значение скорости");
                        input = "mark";
                    }
                    if ((speed > 0) && (speed <= 250)) {
                        break;
                    } else if (!(input.equals("mark"))) {
                        System.out.println("Невалидное значение, введите число от 1 до 250");
                    }
                    }
                }

            Car newcar = new Car(carmodel, speed);
            carList[i] = newcar;
            speed=0;
        }
            scanner.close();
            new Race();
            System.out.println("Победитель гонки - " + Race.winner);
        }
    }
    class Car {
        String carmodel;
        int speed;

        Car(String carmodel, int speed) {
            this.carmodel = carmodel;
            this.speed = speed;
        }
    }

    class Race {
        int trip;
        static String winner;

        public Race() {

            for (int i = 0; i < 3; i++) {
                if (trip < Main.carList[i].speed * 24) {
                    trip = Main.carList[i].speed * 24;
                    winner = Main.carList[i].carmodel;
                }
            }
        }
    }