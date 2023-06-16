
import java.util.Scanner;

public class Calculator {
    public static String totalName = "";
    public static float totalPrice;
    public static float pricePerPerson;
    public static String pricePerPersonFormat;
    public static String rub = " ";
    public static String rub1 = " ";

    public static void calculatePrice() {
        System.out.println(" Введите название товара: ");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String productName = scanner.nextLine();
            if (productName.equalsIgnoreCase("Завершить")) {
                break;
            }
            boolean signs = false;
            float price = 0;
            while (!signs) {
                System.out.println(" Введите стоимость товара в формате 'рубли.копейки', например '10.45' : ");
                if (scanner.hasNextFloat()) {
                    price = scanner.nextFloat();
                    signs = true;
                } else {
                    System.out.println("Ошибка, введён текст\n Введите числовое значение");
                    scanner.next();
                }
            }
            while (price <= 0) {
                System.out.println(" Ошибка, цена не может быть отрицательной! \n  Введите цену заново: ");
                price = scanner.nextFloat();
            }
            totalName += "\n" + productName;
            totalPrice += price;
            pricePerPerson = totalPrice / People.people;
            pricePerPersonFormat = String.format("%.2f", pricePerPerson);
            System.out.println(" Товар " + productName + " успешно добавлен! ");
            System.out.println(" Стоимость товара: " + price);
            System.out.println(" Хотите добавить еще что-то? \n Если хотите завершить программу, то введите команду | Завершить | ");
            int lastDigit = (int) pricePerPerson % 10;
            if (lastDigit == 1) {
                rub = " рубль ";
            } else if (lastDigit == 2 || lastDigit == 3 || lastDigit == 4) {
                rub = " рубля ";
            } else if (lastDigit == 5 || lastDigit == 6 || lastDigit == 7 || lastDigit == 8 || lastDigit == 9 || lastDigit == 0) {
                rub = " рублей ";
            } else {
                rub = " рублей ";
            }
            int ending = (int) totalPrice % 10;
            if (ending == 1) {
                rub1 = " рубль ";
            } else if (ending == 2 || ending == 3 || ending == 4) {
                rub1 = " рубля ";
            } else if (ending == 5 || ending == 6 || ending == 7 || ending == 8 || ending == 9 || ending == 0) {
                rub1 = " рублей ";
            } else {
                rub1 = " рублей ";
            }
        }
    }
}