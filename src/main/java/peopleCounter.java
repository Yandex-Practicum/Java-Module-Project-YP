import java.util.Scanner;

public class peopleCounter {

    public static int countPeople (){
        System.out.println("Приветствую! На сколько человек поделим счет?");
        int peopleNumber;
        while (true) {
            Scanner peopleScanner = new Scanner(System.in);
            if (peopleScanner.hasNextInt()) {
                peopleNumber = peopleScanner.nextInt();
                if (peopleNumber <= 1) {
                    System.out.println("Не вижу смысла в таких подсчетах. Возможно, вы ошиблись. Попробуем еще раз?");
                } else {
                    break;
                }
            } else {
                System.out.println("Это не целое число, возможно, вы ошиблись. Попробуем еще раз?");
                peopleScanner.next();
            }
        }
        return peopleNumber;
    }
}
