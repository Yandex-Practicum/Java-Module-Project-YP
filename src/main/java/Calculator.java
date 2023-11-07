import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);

    double totalCost = 0.00;
void Calculate (){

        String productName;
        String allProducts = "";
        while (true) {
            System.out.println("Желаете добавить товар?\nВведите его название или слово \"завершить\" для разделения счета: ");
            productName = scanner.nextLine();

            if (productName.equalsIgnoreCase("завершить")) {
                System.out.println("Все добавленные товары: ");
                System.out.println(allProducts);
                int totalCostInt = (int) totalCost;
                int lastDigit = totalCostInt % 10;
                int lastTwoDigits = totalCostInt % 100;
                if (lastTwoDigits >= 11 && lastTwoDigits <= 20) {
                    System.out.println("Сумма всех товаров: " + totalCost + " рублей");
                } else if (lastDigit == 1) {
                    System.out.println("Сумма всех товаров: " + totalCost + " рубль");
                } else if (lastDigit >= 2 && lastDigit <= 4) {
                    System.out.println("Сумма всех товаров: " + totalCost + " рубля");
                } else {
                    System.out.println("Сумма всех товаров: " + totalCost + " рублей");
                }

                break;
            } else {

                System.out.println("Введите стоимость товара в формате \"рубли,копейки\": ");
                if (scanner.hasNextDouble()) {
                    double productCost = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Товар успешно добавлен!");
                    totalCost += productCost;
                    int totalCostInt = (int) totalCost;
                    int lastDigit = totalCostInt % 10;
                    int lastTwoDigits = totalCostInt % 100;
                    if (lastTwoDigits >= 11 && lastTwoDigits <= 20) {
                        System.out.println("Текущая сумма добавленных товаров: " + totalCost + " рублей");
                    } else if (lastDigit == 1) {
                        System.out.println("Текущая сумма добавленных товаров: " + totalCost + " рубль");
                    } else if (lastDigit >= 2 && lastDigit <= 4) {
                        System.out.println("Текущая сумма добавленных товаров: " + totalCost + " рубля");
                    } else {
                        System.out.println("Текущая сумма добавленных товаров: " + totalCost + " рублей");
                    }
                    allProducts += productName + "\n";
                } else
                    System.out.println("Введено ошибочное значение, пожалуйста повторите попытку (возможно вы ввели значение с точкой, а не запятой, необходимо вводить с запятой).");

            }
        }




    }
}

