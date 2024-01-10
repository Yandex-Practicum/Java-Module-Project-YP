import java.util.Date;
import java.util.Scanner;

public class Calculator {

    public int getTheQuantity() {
        int numberOfPeople;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            if (scanner.hasNextInt()) {
                numberOfPeople = scanner.nextInt();
                if (numberOfPeople == 1) {
                    System.out.println("Недостаточное количество человек для подсчета. Введите число еще раз");
                } else if (numberOfPeople < 1) {
                    System.out.println("Введите другое число");
                } else {
                    break;
                }
            }
            scanner.next();
        }
        return numberOfPeople;

    }

    public String inputName(int numberOfPeople) {

        String list = "Добавленные товары:\n";
        String productName;
        double productCost;
        double amount = 0;
        String response;
        double amountOfPeople;
        String an = "Завершить";
        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println("Введите наименование товара");
            productName = scanner.nextLine();

            while (true) {

                System.out.println("Введите стоимость товара в формате 00,00");
                if (scanner.hasNextDouble()) {
                    productCost = scanner.nextDouble();
                    if (productCost <= 0) {
                        System.out.println("Некорректный ввод. Стоимость товара не может быть равна 0 и быть отрицательным числом.");
                    } else {
                        break;
                    }
                } else if (!scanner.hasNextDouble()) {
                    System.out.println("Некорректный ввод");
                    scanner.next();
                }
            }
            list = list + String.format("%s - %.2f\n", productName, productCost);
            amount = amount + productCost;


            System.out.println("Товар успешно добавлнен. Хотите добавить еще товар? Введите любой символ. Если нет,то введите Завершить");

            response = scanner.next();

            if (response.equalsIgnoreCase(an)) {
                amountOfPeople = amount / ((double) numberOfPeople);
                String rubleEnd = getRuble(amountOfPeople);
                list = list + String.format("Каждый должен заплатить %.2f %s\n ", amountOfPeople, rubleEnd);
                break;
            }
            scanner.nextLine();
        }
        return list;
    }

    public String getRuble(double amountOfPeople) {
        double resultEnd = (Math.floor(amountOfPeople)) % 100;
        double r = resultEnd % 10;
        if (resultEnd == 0) {
            return "рублей";
        } else if (resultEnd > 10 && resultEnd < 20) {
            return "рублей";
        } else if (r > 1 && r < 5) {
            return "рубля";
        } else if (r == 1) {
            return "рубль";
        }
        return "рублей";
    }

}


