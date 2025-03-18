import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        Scanner scanner = new Scanner(System.in);
        String nameCar;
        int speedCar;
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
            System.out.println("Скорость должна быть 0-250 км/ч");
            while(true) {
                if (scanner.hasNextInt()) {
                    speedCar = scanner.nextInt();
                    if ((speedCar < 0) || (speedCar > 250)) {
                        System.out.println("Скорость должна быть 0-250. Введите повторно!!!");
                    } else {
                        break;
                    }
                }
                else {
                    System.out.println("Ошибка!! Ты вводишь нечисловое значение! Введи значение повторно!");
                    scanner.next();
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
