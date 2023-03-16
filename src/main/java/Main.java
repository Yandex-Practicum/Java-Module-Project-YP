// dev branch for Y.Practicum

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счёт?");
        Scanner scan = new Scanner(System.in);
        String AllNames = "";
        double AllPrices = 0.0;
        int AmountOfPeople = 0;
        while (true) {
            if (scan.hasNextInt()) {
                AmountOfPeople = scan.nextInt();
                if (AmountOfPeople <= 1) {
                    System.out.println("Введеное значение некоректно.");
                    scan.nextLine();
                } else {
                    scan.nextLine();
                    break;
                }

            } else {
                System.out.println("Введеное значение некоректно.");
                scan.nextLine();
            }

        }
        while (true) {
            System.out.println("Напишите название товара:");
            String name = scan.nextLine();
            AllNames += name + " ";
            System.out.println("Напишите цену товара:");
            while (true) {
                double price = 0;
                if (scan.hasNextDouble()) {
                    price = scan.nextDouble();
                    if (price < 1) {
                        System.out.println("Введеное значение некоректно.");
                        scan.nextLine();
                    } else {
                        AllPrices += price;
                        break;
                    }
                } else {
                    System.out.println("Введеное значение некоректно.");
                    scan.nextLine();
                }


            }
            System.out.println("Хотите добавить ещё товар?");
            scan.nextLine();
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
        System.out.println("Добавленные товары: " + AllNames);
        String prices = String.format("%.2f", AllPrices);
        System.out.println("Итоговый счёт: " + prices);
        double total = AllPrices / AmountOfPeople;
        String result = String.format("%.2f", total);
        System.out.println("Итоговая сумма с каждого гостя: " + result + " " + Format.Formarter(total));
    }
}
    class Format {
        public static String Formarter(double x) {
            if (x % 10 == 1 && x != 11 || x == 1) {
                return "рубль";
            } else if (x % 10 == 2 && x != 12 || x % 10 == 3 && x != 13 || x % 10 == 4 && x != 14) {
                return "рубля";
            } else {
                return "рублей";
            }
        }
    }
