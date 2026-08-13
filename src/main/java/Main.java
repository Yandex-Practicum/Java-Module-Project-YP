import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^-*\\d+$");
        String winner = "Никто";
        String name;
        int speed = 0;
        for (int i = 1; i <= 3; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название машины " + i);
            name = scanner.nextLine();
            while (name.isEmpty()) {
                System.out.println("Введено пустое имя! Введите корректное имя");
                name = scanner.nextLine();
            }
            System.out.println("Введите скорость машины " + i);
            String sSpeed = scanner.nextLine();
            Matcher matcher = pattern.matcher(sSpeed);
            while (matcher.find()) {
                speed = Integer.parseInt(sSpeed);
                if (speed <= 0 || speed > 250) {
                    System.out.println("Скорость не должна быть меньше 0 км/ч или превышать 250 км/ч! Введите корректную скорость");
                    sSpeed = scanner.nextLine();
                    matcher = pattern.matcher(sSpeed);
                    System.out.println(matcher.find());
                }
            }
            matcher = pattern.matcher(sSpeed);
            while (!matcher.find()) {
                System.out.println("Введены некорректные данные! Введите корректную скорость");
                sSpeed = scanner.nextLine();
                matcher = pattern.matcher(sSpeed);
                while (matcher.find()) {
                    speed = Integer.parseInt(sSpeed);
                    if (speed <= 0 || speed > 250){
                        System.out.println("Скорость не должна быть меньше 0 км/ч или превышать 250 км/ч! Введите корректную скорость");
                        sSpeed = scanner.nextLine();
                        matcher = pattern.matcher(sSpeed);
                    }
                    else {break;}
                }
                matcher = pattern.matcher(sSpeed);
            }
            Car car = new Car(name, speed);
            winner = Race.result(car.name, car.speed);
        }
        System.out.println("Победитель - " + winner);
    }
    }

