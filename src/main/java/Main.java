import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator.setPersonCount();
        Calculator.getProduct();
        Formatter.printProduct();
        Formatter.printSum();
    }
}
class Calculator {
    private static int personCount = 0;
    private static double sum = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Product> productList = new ArrayList<Product>();
    public static void setPersonCount() {
        System.out.println("На сколько человек необходимо разделить счёт? ");
        String line;
        int count = 0;
        while(true) {
            line = scanner.nextLine();
            try {
                count = Integer.parseInt(line);
            } catch (Exception e) {
                System.out.println("Некорректное значение. Введите еще раз: ");
            }
            if (count < 2) {
                System.out.println("Количество человек должно быть больше 1");
            } else {
                break;
            }
        }
        personCount = count;
    }
    public static int getPersonCount() {
        return personCount;
    }
    public static void getProduct() {
        System.out.println("Введите товар и его цену в формате: товар цена(цена указывается в формате рубли.копейки) ");
        do {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("завершить"))
                break;
            try {
                    /*
                    Замечание 1 я исправил. Дал пользователю больше подсказок.
                    Замечание 2 я исправил. при вводе суммы <= 0 выводится ошибка.
                    Не совсем понял замечание 3 насчет случая, когда товар может содержать цифру так как сейчас он может содержать числа
                    и проблем с этим нет потому что товар и сумма разделяются пробелом.
                    Если наоборот, он не должен содержать чисел, укажите это в комментарии к пр и я исправлю.
                     */
                String[] split = line.split(" ");
                String name = split[0];
                double price = Double.parseDouble(split[1]);
                if (price <= 0) {
                    System.out.println("Цена должна быть больше 0");
                    throw new Exception();
                }
                sum += price;
                productList.add(new Product(name, price));
                System.out.println("Товар успешно добавлен.");
                System.out.println("Хотите добавить еще один товар? Для завершения введите команду завершить.");
            } catch (Exception e) {
                System.out.println("Неверные данные. Введите еще раз: ");
            }
        } while (true);
    }
    public static double getSum() {
        return sum;
    }
    public static ArrayList<Product> getProductList() {
        return productList;
    }
}
class Product {
    private String name;
    private double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}

class Formatter {
    public static void printProduct() {
        System.out.println("Добавленные товары:");
        for(Product product : Calculator.getProductList()) {
            System.out.println(product.getName());
        }
    }
    public static void printSum() {
        double sum = Calculator.getSum() / Calculator.getPersonCount();
        int ending = (int)(Math.floor(sum)) % 10;
        String endSum = "";
        switch(ending) {
            case 1: {
                endSum = "рубль";
                break;
            }
            case 2:
            case 3:
            case 4: {
                endSum = "рубля";
                break;
            }
            default: {
                endSum = "рублей";
                break;
            }
        }
        String answer = String.format("К оплате: %.2f %s", sum,endSum);
        System.out.println(answer);
    }
}

