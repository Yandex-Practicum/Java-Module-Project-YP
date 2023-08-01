import java.util.Scanner;

import mypackage.Product;
import mypackage.ProductBusket;


public class Main {

    public static String rubleDeclination(double numberExample) {
        int rouble = (int) Math.floor(numberExample);

        if (rouble >= 5 && rouble <= 20) {
            return "рублей";
        }
        switch (rouble % 10) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }

    public static void main(String[] args) {
        System.out.println(Main.class.getPackage().getName());
        int numberOfGuests = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) {

            try {
                System.out.println("Введите количество гостей.");
                numberOfGuests = scanner.nextInt();
                if (numberOfGuests <= 1)
                    System.out.println("Ошибка. Введите корректное количество гостей заново.");
                else
                    break;
            } catch (Exception e) {
                String wrongInput = scanner.next();
                System.out.println("Ошибка. Введите корректное количество гостей заново.");

            }
        }

        ProductBusket myBusket = new ProductBusket();


        while (true) {
            String prodName = "";
            if (myBusket.productList.size() == 0) {

                System.out.println("Введите название блюда");
                prodName = scanner.next();
            } else {
                System.out.println("Введите название блюда, если хотите добавить товар или 'завершить', если товаров больше нет.");

                prodName = scanner.next();
                if (prodName.equalsIgnoreCase("Завершить")) {
                    break;
                }
            }

//                System.out.println("Введите название блюда.");
//                String prodName = scanner.next();
//                if (prodName.equalsIgnoreCase("Завершить")) {
//                    break;
//                }
            if (prodName.matches("[а-яА-Я]+")) {
                while (true) {
                    try {
                        System.out.println("Введите стоимость блюда в формате рубли.копейки.");
                        Double prodPrice = scanner.nextDouble();
                        if (prodPrice > 0) {
                            Product a = new Product(prodName, prodPrice);
                            myBusket.addToBusket(a);
                            System.out.println("Блюдо успешно добавлено в корзину!");

                            break;

                        } else {
                            System.out.println("Ошибка. Неверно введена стоимость блюда. Введите снова!");
                        }
                    } catch (Exception e) {
                        String WrongName = scanner.next();
                        System.out.println("Ошибка. Неверно введена стоимость блюда. Введите снова!");
                        continue;
                    }
                }
            } else {
                System.out.println("Неккоректно введено название блюда введите снова.");
            }
        }

        myBusket.displayProducts();
        double result = ProductBusket.finalPrice / numberOfGuests;
        double finalResult = Math.round(result * 100.0) / 100.0;
        System.out.println("Каждый гость заплатит: " + finalResult + " " + rubleDeclination(finalResult) + ".");
    }
}




