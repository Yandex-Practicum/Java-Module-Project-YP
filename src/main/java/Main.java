package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            String name = "";
            while (true) {
                System.out.print("— Введите название машины №" + i + ": ");
                name = scanner.nextLine();
                if (!name.trim().isEmpty()) {
                    break;
                } else {
                    System.out.println("— Ошибка: Название автомобиля не может быть пустым");
                }
            }

            int speed = 0;
            while (true) {
                System.out.print("— Введите скорость машины №" + i + ": ");
                String speedInput = scanner.nextLine();

                if (speedInput.trim().isEmpty()) {
                    System.out.println("— Неправильная скорость");
                    continue;
                }

                try {
                    speed = Integer.parseInt(speedInput);

                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("— Неправильная скорость");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("— Неправильная скорость");
                }
            }

            Car car = new Car(name, speed);
            race.checkNewParticipant(car);
        }

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
    String leaderName = "";
    int maxDistance = 0;

    public void checkNewParticipant(Car car) {
        int distance = car.speed * 24;

        if (distance > maxDistance) {
            maxDistance = distance;
            leaderName = car.name;
        }
    }

    public void printLeader() {
        System.out.println("Самая быстрая машина: " + leaderName);
    }
}
