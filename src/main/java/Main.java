
import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        RubFormat rF = new RubFormat();
        Scanner scanner = new Scanner(System.in);
        // Ввод количества гостей
        int guests;
        System.out.println("Введите, пожалуйста, на скольких человек необходимо разделить счёт:");
        boolean guestsInt;
        do{
            while (!scanner.hasNextInt())
            {
                System.out.println("Введено некорректное значение для подсчёта! Повторите ввод!");
                scanner.next();
            }
            guests = scanner.nextInt();
            if (guests == 1) {
                System.out.println("Делить счет бессмысленно! Повторите ввод!");
            } else if (guests < 1) {
                System.out.println("Введено некорректное значение для подсчёта! Повторите ввод!");
            }

        } while (guests<=1);
        // Добавление и ввод товаров и цены
        String text = "Добавленные товары:";
        String product, exit, s;
        double price, score=0;
        while (true)
        {
            System.out.println("Введите наименование товара:");
            product = scanner.next();
            System.out.println("Введите цену товара:");
            do{
                while (!scanner.hasNextDouble())
                {
                    System.out.println("Введено некорректное значение цены! Повторите ввод!");
                    scanner.next();
                }
                price = scanner.nextDouble();
                if (price<0) {System.out.println("Цена товара не может быть меньше 0. Повторите ввод!"); }
            }while (price<0);

            s=rF.rubFormat(price);
            text = text + "\n"+product+" "+String.format("%.2f %s", price, s);
            score = score+price;
            System.out.println("Для завершения ввода введите слово  \"Завершить\"");
            exit = scanner.next();
            if (exit.equalsIgnoreCase("Завершить"))
            { break;
            }
        }


        System.out.println(text);
        s=rF.rubFormat(score);
        System.out.printf("Итого: %.2f %s", score, s);

        score=score/guests;
        s=rF.rubFormat(score);
        System.out.printf("\nКаждый гость должен заплатить по %.2f %s", score, s);

    }

}
