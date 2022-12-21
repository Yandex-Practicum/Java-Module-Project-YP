import java.util.Scanner;

public class Main {

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfPeople;
        double costOfGoods;

        // 1. Вводим количество посетителей.

        System.out.println("На скольких человек разделить счет?");

        while (true) {

            while (!sc.hasNextInt()) {
                System.out.println("Некорректный ввод, введите целое число.");
                sc.next();
            }
            numberOfPeople = sc.nextInt();

            if (numberOfPeople <=1) {
                    System.out.println("Количество посетителей должно быть больше 1.");
                } else {
                    System.out.println("Количество посетителей - " + numberOfPeople);
                    break;
                }

            }

        Calculator calc = new Calculator();

        // 2.1 Вводим название товара

        while (true) {

            System.out.println("Введите название товара");

            String productName = sc.next();

            if (productName.equalsIgnoreCase("ЗАВЕРШИТЬ")){

                // 3.1 Выводим список товаров
                System.out.println(calc.listOfProducts);

                // 3.2 Выводим цену для одного человека
                double costPerPerson = calc.totalAmount / (double) numberOfPeople;

                System.out.println(String.format("%.2f",costPerPerson) + " " + GetCurrency(costPerPerson));

                break;

            } else {

                while (true) {

                    // 2.2 Вводим стоимость товара
                    System.out.println("Введите стоимость товара");

                    while (!sc.hasNextDouble()) {
                        System.out.println("Некорректный ввод, введите число.");
                        sc.next();
                    }
                    costOfGoods = sc.nextDouble();



                    if (costOfGoods > 0) {
                        calc.AddProductToCalculator(productName,costOfGoods);
                        break;
                    } else {
                        System.out.println("Введите не нулевую стоимость товара." + numberOfPeople);
                    }

                }

            }

        }   //while (true)

    }

    public static String GetCurrency(double costPerPerson){

        String currency = "рублей";

        int integerPartOfNumber = (int)costPerPerson;

        String strIntegerPartOfNumber = Integer.toString(integerPartOfNumber);

        String theLastDigit = strIntegerPartOfNumber.substring(strIntegerPartOfNumber.length() - 1);

        if (theLastDigit.equals("1")){
            currency = "рубль";
        } else if (theLastDigit.equals("2") || theLastDigit.equals("3") || theLastDigit.equals("4")) {
            currency = "рубля";
        }

        return currency;
    }
}
