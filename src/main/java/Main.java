import java.util.Random;
import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {
    int persons = 0;
    public static void main(String[] args) {
        quantityOfPersons();
        addProduct();
        finish();

    }
    public static void quantityOfPersons() {
        Scanner scanner = new Scanner(System.in);
        int persons = 0;
        System.out.println("Сколько вас человек?");
        while (true) {
            if (scanner.hasNextDouble()) {
                persons = scanner.nextInt();
                if (persons == 1) {
                    System.out.println("Вы один, нет смысла делить.");
                } else if (persons < 1) {
                    System.out.println("Неверное значение меньше 1");
                } else if (persons > 1) {
                    break;
                } else {
                    System.out.println("Вы ввели не число");
                    scanner.next();
                }
            }
        }
    }
    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        double price = 0;
        double sum = 0;
        String productList = "Добавленные товары: \n";
        String product = null;

        System.out.println("напишите блюдо");

        while ((product = scanner.next()) != null) {
            if (product.equalsIgnoreCase("Завершить")) {
                System.out.println(productList);
                String str2 = String.format("Общая сумма товаров составила: %.2f",sum);
                System.out.println(str2);
                break;
            }
            System.out.println("сколько стоит блюдо?");
            while (true) {
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    if (price < 0) {
                        System.out.println("Введённая сумма меньше 0");
                    } else if (price >= 0) {
                        sum += price;
                        productList += product + "\n";
                        String str = String.format("%s стоимостью %.2f добавлено. Сумма: %.2f",product, price,sum);
                        System.out.println(str);
                        System.out.println("напишите блюдо");
                        break;
                    } else {
                        System.out.println("Введено не число");
                        scanner.next();
                    }
                }

            }

        }

    }
    public static void finish(){

    }


}

