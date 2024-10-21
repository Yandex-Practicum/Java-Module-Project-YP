import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
       startRace();
    }

    public static void startRace() {
        System.out.println("Начнем гонку!");

        Wheel newWheel = new Wheel();
        Scanner scanner = new Scanner(System.in);

        String riderName = "";
        Integer riderSpeed = 0;

        for(int i = 1; i <= 3; i++){
            while (riderName == "") {
                System.out.println("Введите название автомобиля");
                riderName = scanner.next();
            }

            while (riderSpeed <= 0 || riderSpeed >= 250) {
                System.out.println("Введите скорость автомобиля");
                riderSpeed = scanner.nextInt();

                if (riderSpeed < 0) {
                    System.out.println("В заезде не учавствуют автомобили со скоростью 0 или меньше");
                } else if (riderSpeed > 250) {
                    System.out.println("Мы не принимаем автомобили быстрее 250 км");
                } else {
                    newWheel.racers.add(acceptRider(riderName, riderSpeed));
                    riderName = "";
                    riderSpeed = 0;
                    break;
                }
            }
        }
        newWheel.checkWhoWinnerFrom();
    }


    public static Car acceptRider(String name, Integer speed) {
        System.out.println(String.format("автомобиль %s принят", name));
        System.out.println("-----------------------------------");
        return new Car(name, speed);
    }





}