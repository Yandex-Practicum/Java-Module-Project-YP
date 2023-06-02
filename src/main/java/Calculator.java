import java.util.ArrayList;
import java.util.InputMismatchException;
import  java.util.Scanner;


public class Calculator {



    public static int calculator(){
        int totalPersons = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько человек необходимо разделить счет?");
        while (!scanner.hasNextInt()){
            System.out.println("Допустимы только цифры, попробуйте еще раз");
            scanner.next();
        }

        while (scanner.hasNextInt()) {
            int persons = scanner.nextInt();


            if (persons == 1) {
                System.out.println("Ничего считать не буду");
            } else if (persons < 1) {
                System.out.println("Некорректное значение, пробуй еще");
            }
            else {
                totalPersons += persons;
                break;
            }
        }
        return totalPersons;
    }

    public static double stuffCost(){

        double totalCOst = 0.0;
        String keyWord = "завершить";
        ArrayList<String> allNames = new ArrayList<>();
        double price;
        while (true) {
            System.out.println("Введите название товара");
            String name = Stuff.name();
            allNames.add(name);
            System.out.println("Введите стоимость товара");
            price = Stuff.priceStuf(name);
            if (name.equalsIgnoreCase(keyWord)) {
                    System.out.println("Ну ладно");
                    System.out.println("Добавленные товары: ");
                    for (int i = 0; i < allNames.size() - 1; i++) {
                        System.out.println(allNames.get(i));
                    }
                    break;
                } else if (name.matches("[-+]?\\d+")) {
                    System.out.println("Попробуй еще раз");
                    break;
                }
                totalCOst += price;
            }
        return totalCOst;
        }

    }

