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
    void MyException(String s){
        String keyWord = "завершить";
        if(s.equalsIgnoreCase(keyWord)){
            throw new NullPointerException("попробуй еще раз")
        }


    }


    public static Double stuffCost() {



        double totalCOst = 0;

        Scanner scanner = new Scanner(System.in);



        while (true) {

            System.out.println("Введите стоимость товара");
            System.out.println("Введите название товара");
            Stuff stuff = new Stuff();
            if (stuff.name.equalsIgnoreCase(keyWord)) {
                break;
            } else {

                stuff.price = scanner.nextDouble();
                totalCOst += stuff.price;
                stuff.name = scanner.nextLine();
                ArrayList<String> allNames = new ArrayList<>();
                allNames.add(stuff.name);
                System.out.println("Добавлено успешно");
                System.out.println("Что нибудь еще?");
                if (stuff.name.equalsIgnoreCase(keyWord)) {
                    break;
                }

            }
        }
        return totalCOst;
    }
}