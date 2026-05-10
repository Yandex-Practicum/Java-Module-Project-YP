import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Сначала работаем с данными от пользователя
        Car[] cars = Car.ProcessData();
        Race.ProcessLeader(cars);

//        Scanner input = new Scanner(System.in);
//
//        if (input.hasNextInt()) {
//            int number = input.nextInt();
//
//            if (number == 10); {
//                System.out.println("Hi");
//            }
//        } else {
//            System.out.println("Incorrect format");
//        }
    }
}

// 10, 11, 12
// 12, 10, 11
// 10, 11, 8