import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        Scanner scanner = new Scanner(System.in);
        String nameCar;
        for (int i=1; i<4; i++) {
            while(true){
                System.out.println("Введите название автомобиля " + i);
                nameCar = scanner.next().trim();
                if (nameCar.isEmpty()){
                    System.out.println("Это пустая строка! Введите название автомобиля!!!!");
                }
                else{
                    break;
                }
            }
            System.out.println("Введите скорость автомобиля " + i);
            int speedCar;
            System.out.println("Скорость должна быть 0-250 км/ч");
            while(true) {
                if (scanner.hasNextInt()){
                    speedCar = scanner.nextInt();
                    String SpeedCstr = Integer.toString(speedCar);
                    if ((speedCar<0) || (speedCar>250)  ){
                        System.out.println("Скорость должна быть 0-250. Введите повторно!!!");
                    } else if ((SpeedCstr.isEmpty())) {
                        System.out.println("Скорость не может быть пустой строкой!! Введите значение повторно!");
                    } else if (speedCar%10 != 0) {
                        System.out.println("Скорость не может быть дробным значением! Введите значение повторно!");
                    } else {
                        break;
                    }
                }
                else {
                    System.out.println("Ошибка!! Ты вводишь нечисловое значение! Введи значение повторно!");
                }
            }
            SportCar car = new SportCar(nameCar, speedCar);
            race.returnPath(car);

        }
        scanner.close();
        System.out.println("Самая быстрая машина: " + race.Leader());
    }
}
class SportCar{
    String name;
    int speed;
    SportCar(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
    public int speedGet(){
        return speed;
    }
}
class Race{
    String carBest;
    int bestPath = 0;
    public void returnPath(SportCar car){
        int path = car.speedGet() * 24;
        if (path>bestPath) {
            bestPath = path;
            carBest = car.name;
        }
    }
    public String Leader(){
        return carBest;
    }
}