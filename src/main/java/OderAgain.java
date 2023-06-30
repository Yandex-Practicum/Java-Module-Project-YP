import java.util.Scanner;

public class OderAgain {

    Scanner sc = new Scanner(System.in);

    int OderAgainQuestion() {
        System.out.println("Желаете разделить счет еще раз?");
        while (true) {
            String againBill = sc.next();
            String lowerCaseAgainBill = againBill.toLowerCase().trim();
            switch (lowerCaseAgainBill) {
                case "да":
                case "еще раз":
                case "желаю":
                case "хочу":
                    System.out.println("На сколько человек Вы желаете разделить счет?");
                    return 1;
                case "нет":
                case "не хочу":
                case "не желаю":
                case "завершить":
                case "выйти":
                    System.out.println("Хорошего дня и до скорых встреч!");
                    return 2;
                default:
                    System.out.println("Не понимаю, введите еще раз: Да или Нет");

            }
        }
    }
}
