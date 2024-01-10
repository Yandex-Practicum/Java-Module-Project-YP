import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double summ = 0;
        List productName = new ArrayList<>();
        List productPrice = new ArrayList<>();

        int company = Meet.companyInput();
        if (company == 1) {
            System.out.println("Нет смысла ничего считать и делить.");

        } else if (company < 1) {
            System.out.println("Некорректное значение для подсчёта.");

        } else {

            while (true) {
                System.out.println("Количество людей: " + company);
                break;
            }

            while (true) {
                System.out.println("Введите название продукта или 'Завершить'. ");
                String prName = scanner.next();
                if (prName.equalsIgnoreCase("Завершить")) {
                    break;
                } else if (prName.matches(".*\\d.*")) {
                    System.out.println("Ошибка! Строка содержит цифры.");
                    return;
                } else {
                    productName.add(prName);
                }

                System.out.println("Введите цену продукта");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Необходимо ввести число!");
                    scanner.nextLine();
                }

                double prPrice = scanner.nextDouble();
                scanner.nextLine();
                productPrice.add(prPrice + Okonch.getAddition(prPrice));

                double a = summ;
                summ = a + prPrice;
            }


            double priceOnePerson = summ / company;
            String formattedPrice = String.format("%.2f", priceOnePerson);

            System.out.println("Цена с 1-го человека: " + (formattedPrice) + Okonch.getAddition(priceOnePerson));
            System.out.println("Добавленные товаров:");
            for (int i = 0; i < productName.size(); i++) {
                System.out.println(productName.get(i) + " - " + productPrice.get(i));

            }
        }
    }
}


