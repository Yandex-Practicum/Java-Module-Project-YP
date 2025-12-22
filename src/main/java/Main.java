import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать на Гонку Ле-Ман!");
        Race race = new Race();

        for(int i = 0; i < 3; i++) {

            String name;

            while(true) {

                System.out.println("Введите название автомобиля №" + (i + 1) + ":");
                name = scanner.nextLine().trim();

                if(!name.isEmpty()){
                    break;
                } else {
                    System.out.println("Ошибка: название не может быть пустым.");
                }
            }
            int speed;

            while(true) {

                System.out.println("Введите скорость автомобиля №" + (i + 1) + " (0–250):");

                if(!scanner.hasNextInt()){
                    System.out.println("Ошибка: скорость должна быть целым числом.");
                    scanner.nextLine();
                    continue;
                }
                speed = scanner.nextInt();
                scanner.nextLine();

                if (speed > 0 && speed <= 250) {
                    break;
                } else {
                    System.out.println("Ошибка: скорость должна быть в диапазоне 1–250.");
                }
            }


            Car car = new Car(name, speed);
            race.checkLeader(car);
        }


             System.out.println("Самая быстрая машина: " + race.leaderName);

        }


}

