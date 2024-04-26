import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Calculator {

    static String nameGood;
    static String normalNames = "";
    static double price;
    static double sumOfPrices;
    static double sumForOne;
    static short plugForCycle;

    static ArrayList<Good> goods = new ArrayList<>();

    public static void count() {

        while (true) {

            if (plugForCycle == 0) {
                System.out.println("\nВведи название товара");
            } else {
                System.out.println("\nДобавим ещё товар? Введи его название или команду 'Завершить'");
            }

            nameGood = Main.scanner.nextLine();

            if (nameGood.equalsIgnoreCase("Завершить")) {

                System.out.println("\nДобавление товаров завершено!\n\nДобавленные товары:" + normalNames);
                break;

            } else {

                do {
                    System.out.println("\nВведи цену этого товара в формате 'рубли,копейки'");
                    while (!Main.scanner.hasNextDouble()) {
                        System.out.println("\nОшибка: некорректное значение! Введи цену товара ещё раз в формате 'рубли,копейки'");
                        Main.scanner.next();
                    }
                    price = Main.scanner.nextDouble();
                    Main.scanner.nextLine();
                    if (price <= 0) {
                        System.out.println("\nОшибка: цена не может быть нулевой или отрицательной!");
                    }
                } while (price <= 0);

                Good good = new Good(nameGood, price);
                goods.add(good);
                System.out.println("\nТовар '" + nameGood + "' добавлен");
                normalNames = normalNames + "\n- " + good.name;
                sumOfPrices = sumOfPrices + price;
                sumForOne = sumOfPrices / Main.numberPersons;
                plugForCycle++;
            }
        }

        System.out.println(String.format("\nКаждый гость должен заплатить: %s %s", Formating.sumForMan, Formating.getNormalRubles()));
    }
}