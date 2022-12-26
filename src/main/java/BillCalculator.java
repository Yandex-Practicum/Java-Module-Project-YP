import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class BillCalculator {
    private static final Scanner scan = new Scanner(System.in).useDelimiter("\\n").useLocale(Locale.UK);
    final int numOfPersons = setNumOfPersons();
    ArrayList<Purchase> bill = fillBill();
    final double totalCost = getTotalCost();
    final double personalCost = getPersonalCost();

    private int setNumOfPersons() {
        System.out.println("Укажите количество персон:");
        int result;
        if (scan.hasNextInt()) {
            result = scan.nextInt();
        } else {
            System.out.println("Некорректный ввод.");
            return setNumOfPersons();
        }
        if (result <= 1) {
            System.out.println("Неверное количество персон.");
            return setNumOfPersons();
        } else return result;
    }

    private ArrayList<Purchase> fillBill() {
        ArrayList<Purchase> local = new ArrayList<>();
        while (true) {
            System.out.println("\nХотите добавить покупку в чек?");
            System.out.println("Введите: 'Да' или 'Завершить':");
            String input = scan.next().trim();
            switch (input.toLowerCase()) {
                case ("завершить"): return local;
                case ("да"): {
                    Purchase purchase = new Purchase();
                    local.add(purchase);
                    System.out.println("Товар \"" + purchase.name + "\" успешно добавлен.");
                    break;
                }
                default: break;
            }
        }
    }

    private double getTotalCost() {
        double result = 0;
        if (bill != null) {
            for (Purchase purchase : bill) {
                result += purchase.price;
            }
        }
        return result;
    }

    private double getPersonalCost() {
        double local = totalCost / numOfPersons;
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(local).replace(",", "."));
    }
}

class Purchase {
    Scanner scan = new Scanner(System.in).useLocale(Locale.UK).useDelimiter("\\n");
    String name = setName();
    double price = setPrice();

    private double setPrice() {
        String regex = "\\d+\\.?\\d{0,2}";
        double local;

        System.out.println("Введите стоимость товара в формате (рубли.копейки):");

        String input = scan.next();
        if (input.matches(regex)) {
            local = Double.parseDouble(input);
        } else {
            System.out.println("Некорректный ввод.");
            return setPrice();
        }
        if (local <= 0.0) {
            System.out.println("Стоимость товара не может быть меньше либо равна 0 рублей!");
            return setPrice();
        } else return local;
    }

    private String setName() {
        System.out.println("Введите наименование товара:");
        String input = scan.next();
        if (input != null) {
            return input;
        } else {
            System.out.println("Некорректный ввод.");
            return setName();
        }
    }
}