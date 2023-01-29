import java.util.Random;
import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {
    static CountPersons countPersons = new CountPersons();
    static int persons = 0;
    static double sum = 0;

    public static void main(String[] args) {
        countPersons.quantityOfPersons();
        addProduct();
        finish();

    }
    public static class CountPersons {


        void quantityOfPersons() {
            Scanner scanner = new Scanner(System.in);
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
                        scanner.nextLine();
                    }
                }
            }
        }
    }
    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        double price = 0;
        String productList = "Добавленные товары: \n";
        String product = null;

        System.out.println("напишите блюдо");

        while ((product = scanner.nextLine()) != null) {
            if (product.equalsIgnoreCase("Завершить")) {
                System.out.println(productList);
                String str2 = String.format("Общая сумма товаров составила: %.2f", sum);
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
                        String str = String.format("%s стоимостью %.2f добавлено. Сумма: %.2f", product, price, sum);
                        System.out.println(str);
                        System.out.println("напишите блюдо");
                        break;
                    } else {
                        System.out.println("Введено не число");
                        scanner.nextLine();
                    }
                }
            }
        scanner.nextLine();
        }
    }

    public static void finish() {
        double total = sum/persons;
        int num1 = (int) (total);
        String result = null;
        if (total % 100 > 4 && total % 100 < 21) {
            result = "рублей";
        } else if (total % 10 == 1) {
            result = "рубль";
        } else if (total % 10 > 1 && total % 10 < 5) {
            result = "рубля";
        }
        int num2 = persons;
        String result2 = null;
        if (num2 % 100 > 4 && num2 % 100 < 21) {
            result2 = "человека";
        } else if (num2 % 10 > 1 && num2 % 10 < 5) {
            result2 = "человек";
            String str = String.format("Вас %d %s, С каждого по %.2f %s", persons, result2, total, result);
            System.out.println(str);
        }
    }
}

