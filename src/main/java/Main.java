import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> productName = new ArrayList<>();
        ArrayList<String> productPrice = new ArrayList<>();

        int company = 0;
        double summ = 0;
        double priceOnePerson = 0.00;


        while (true) {
            System.out.println("Введите количество гостей");
            try {
                company = Integer.parseInt(scanner.nextLine());
                if (company <= 0) {
                    System.out.println("Введено некорректное число гостей. Повторите ввод.");
                } else if (company == 1) {
                    System.out.println("Нет смысла ничего считать и делить.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введено не число. Повторите ввод.");
            }
        }

        while (true) {
            System.out.println("Количество людей: " + company);
            break;
        }
        String prName = "";
        boolean f = false;
            while (!f) {
                System.out.println("Введите название продукта или 'Завершить'. ");
                prName = scanner.nextLine();

                if (prName.equalsIgnoreCase("завершить")) {
                    break;
                }
                if (prName.matches(".*\\d+.*") || prName.trim().isEmpty()) {
                    System.out.println("Название продукта не может содержать цифры или быть пустым. Пожалуйста, введите название продукта:");
                    f = true;

                    //я не понимаю как после этой ошибки заново запрашивать название продукта, я 3 раза переписал весь код запроса названия и цены и ничего не понимаю.

                }
                productName.add(prName);



                double prPrice = 0;

                while (prPrice <= 0) {
                    try {
                        System.out.println("Введите цену продукта");
                        prPrice = Double.parseDouble(scanner.nextLine());
                        if (prPrice <= 0) {
                            System.out.println("Цена продукта должна быть больше нуля. Пожалуйста, введите положительное число");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка! Пожалуйста, введите положительное число:");
                    }
                }
                productPrice.add(prPrice + Okonch.getAddition(prPrice));
                summ += prPrice;
            }


        priceOnePerson = summ / company;
        String formattedPrice = String.format("%.2f", priceOnePerson);
        System.out.println("Цена с 1-го человека: " + (formattedPrice) + Okonch.getAddition(priceOnePerson));
        System.out.println("Добавленные товаров:");
        for (int i = 0; i < productName.size(); i++) {
            System.out.println(productName.get(i) + " - " + productPrice.get(i));
        }
    }
}

