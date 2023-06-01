import java.util.ArrayList;
import  java.util.Scanner;


public class Calculator {




    public static int calculator() {
        int totalPersons = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько человек необходимо разделить счет?");

        while (true) {
            int persons = scanner.nextInt();
            if (persons == 1) {
                System.out.println("Ничего считать не буду");

                continue;
            } else if (persons < 1) {
                System.out.println("Некорректное значение, пробуй еще");
                continue;
            } else if (persons > 1) {
                totalPersons += persons;
                break;
            }
        }
        return totalPersons;
    }

    public static Double stuffCost() {



        double totalCOst = 0;
        String keyWord = "завершить";
        Scanner scanner = new Scanner(System.in);



        while (true) {

            System.out.println("Введите название товара");
            System.out.println("Введите стоимость товара");
            Stuff stuff = new Stuff();
            ArrayList<String> allNames = new ArrayList<>();

            while (true) {
                if (stuff.name.equalsIgnoreCase(keyWord)) {
                    System.out.println("Ну ладно");
                    return 0.0;
                }else if(stuff.name.matches("[-+]?\\d+")){
                    System.out.println("Попробуй еще раз");
                    break;
                }
                allNames.add(stuff.name);
                totalCOst += stuff.priceStuf();
                System.out.println("Добавлено успешно");
                System.out.println("Что нибудь еще?");
                break;

            }
            //return totalCOst;
        }

    }
}