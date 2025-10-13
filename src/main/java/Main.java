import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Car [] Cars = new Car[3];
        Scanner scanner = new Scanner(System.in);
        Race race = new Race ();
        for (int i =0; i <3; i++) {
            System.out.println("Автомобиль" + (i+1));
            System.out.println("Название автомобиля:");
            String name = scanner.next();
            int speed;
            while (true) {
                System.out.println("Скорость автомобиля от 0 до 250 км/ч");
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Ошибка! Скорость должна быть от 1 до 250 км/ч. Введите значение скорости снова");
                    }
                } else {
                    System.out.println("Ошибка! Введите числовое значение!");
                    scanner.next();
                }
            }
            Cars[i] = new Car(name, speed);
            race.checkLeader(Cars[i]);
        }
        scanner.close();
        race.printLeader();

    }
}
class Car {
    String name;
    int speed;
    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}

class Race {
    String leader = "";
    int leaderDistance = 0;

    public void checkLeader(Car newCar) {
        int newDistance = newCar.speed * 24;
        if(leader.isEmpty()) {
            leader = newCar.name;
            leaderDistance = newDistance;
        } else if(newDistance > leaderDistance) {
            leader = newCar.name;
            leaderDistance = newDistance;
        }
    }
    public void printLeader () {
        System.out.println("Победитель " + leader);
    }
}
