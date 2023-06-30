import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        //Приветствие
        System.out.println("Добро пожаловать!");
        System.out.println("На сколько человек Вы желаете разделить счет?");
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                //Ввод кол-ва людей
                int numberOfPeople = sc.nextInt();

                //Людей больше 1
                if (numberOfPeople > 1) {


                    //ИСПОЛЬЗОВАНИЕ КЛАССА BillMaker
                    BillMaker bill = new BillMaker();
                    bill.BillMakerMethod(numberOfPeople);

                    //ИСПОЛЬЗОВАНИЕ КЛАССА OderAgainQuestion.
                    // IF - НУЖЕН ДЛЯ ТОГО, ЧТОБЫ ВЫХОДИТЬ ИХ НУЖНЫХ ЛУПОВ, В РАМКАХ КЛАССА Я НЕ ЗНАЛА КАК ЭТО СДЕЛАТЬ
                    OderAgain ord = new OderAgain();
                    int ordExit = ord.OderAgainQuestion();
                    if (ordExit == 1) {
                        continue;
                    } else if (ordExit == 2) {
                        break;
                    }

                }

                // 1 человек
                if (numberOfPeople == 1) {
                    System.out.println("Нет смысла ничего считать, ведь вы всего один :с");
                    System.out.println("Может, кто-то из друзей уже подошел, на сколько человек делить сейчас?");
                }
                // меньше 1 человека
                if (numberOfPeople < 1) {
                    System.out.println("Никого нет :с");
                    System.out.println("Может, кто-то из друзей уже подошел, на сколько человек делить сейчас?");

                }
                //Неправильный ввод
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели что-то не то :с Попробуйте еще раз");
                sc.nextLine();
            }
        }
    }
}