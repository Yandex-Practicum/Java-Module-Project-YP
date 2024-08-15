
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String leadName="";
        Car[] cars = new Car[3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < cars.length; i++) {
            System.out.println("Введите название машины №" + (i + 1));
            String name = scanner.next();
            System.out.println("Введите скорость машины №" + (i + 1));
            int speed=scanner.nextInt();
            if (speed<=0 || speed>=250) {
                while (speed<=0 || speed>=250) {
                    System.out.println("Неверная скорость, попробуйте ещё раз");
                    System.out.println("Введите скорость машины №" + (i + 1));
                    speed = scanner.nextInt();
                }
            }
            cars[i]= new Car(name, speed);
        }
        System.out.println("Самая быстрая машина: "+Race.leader(cars));

    }
}
class Car{
    String nameCar;
    int speedCar;
    public Car(String name, int speed){
        this.nameCar= name;
        this.speedCar=speed;
    }
}
class Race{
    String carLider="";
    int distance=0;
    public static String leader(Car[] cars){
        String carLider="";
        int distanceMax=0;
        int time =24;
        for (int i = 0; i< cars.length; i++){
            int distanceCar= cars[i].speedCar * time;
            if (cars[i].speedCar>distanceMax){
                distanceMax=cars[i].speedCar;
                carLider=cars[i].nameCar;
            }
        }
        return carLider;
    }
}
