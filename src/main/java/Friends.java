import java.util.Scanner;

public class Friends {

    boolean restart = true;


    int friends() {
        System.out.print("На скольких разделить счёт:\t ");
         int result = 0;
        while (restart) {

            Scanner numberFriends = new Scanner(System.in);
            if (numberFriends.hasNextInt()) {
              int number = numberFriends.nextInt();
                if (number <=1 ){
                    System.out.print("Количество человек, равно 1. В этом случае нет смысла ничего считать и делить.\nВведите сколько вас гостей: ");
                } else {
                    System.out.println("Счёт будет поделён между " + number + " человек. ");
                    restart = false;
                    result = number;

                }
            } else {
                System.out.print("Вы не ввели число, введите колличество гостей: ");
            }


        }
         return result;
    }
}

