import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dudes.calcDudes();
    }
}

class Dudes { //счётчик
    public static void calcDudes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На скольких человек необходимо разделить счёт?");
        while (true) {
            String x = scanner.nextLine();
            x = x.trim();
            try {
                int dudes = Integer.parseInt(x);
                if (dudes > 1) {
                    Product.eachdude(dudes); //запись в хранилище
                    System.out.println("калькулируем"); //вызвать калькулятор;
                    Calc.calculate();
                    break;
                } else {
                    System.out.println("Количество не может быть нулевым или отрицательным");
                }

            } catch (NumberFormatException e) {
                System.out.println("Неверный формат, введите число");

            }
        }
    }
}


//калькулятор
class Calc {
    //ввод и проверка
    public static void calculate() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите название товара");
            String productname = scanner.nextLine();
            productname = productname.trim();
            System.out.println("Введите стоимость в формате х.хх");
            String productpriceS = scanner.nextLine();
            productpriceS = productpriceS.replace(",", ".");
            double productpriceD;
            String products;
            try {
                productpriceD = Double.parseDouble(productpriceS);
                if (productpriceD > 0) {
                    productpriceS = String.format("%.2f", productpriceD);
                    products = productname + " " + productpriceS;
                    Product.storage(products, productpriceD); //запись в хранилище
                    System.out.println("""
                            Товар успешно добавлен
                            Добавить ещё один товар?
                            Если все товары внесены, введите <завершить>""");
                } else {
                    System.out.println("Стоимость не может быть отрицательной или нулевой");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат");
            }
            String exit = scanner.nextLine();
            if (exit.equalsIgnoreCase("завершить")) {
                Product.output();
                break;
            }
        }
    }
}

//товары
class Product {
    private static String productsout = "";
    private static double fullprice = 0;
    private static double eachdudepay;
    private static String rubleEnding = "";

    public static void eachdude(int dudes) { //чуваки
        eachdudepay = dudes;
    }

    public static void storage(String products, double productpriceD) { //хранение
        rublesconvert(productpriceD);
        productsout += products + rubleEnding + "\n";
        fullprice = fullprice + productpriceD;

    }

    public static void rublesconvert(double rubles) { //окончание рубля
        rubles = Math.floor(rubles);

        if (rubles % 10 == 1 && rubles % 100 != 11) {
            rubleEnding = " рубль";
        } else if ((rubles % 10 >= 2 && rubles % 10 <= 4) && !(rubles % 100 >= 12 && rubles % 100 <= 14)) {
            rubleEnding = " рубля";
        } else {
            rubleEnding = " рублей";
        }
    }

    public static void output() { //вывод
        //список
        System.out.println("Добавленные товары:" + "\n" + productsout);

        //всего
        rublesconvert(fullprice);
        String totalpriceS = String.format("%.2f", fullprice);
        System.out.println("Всего: " + totalpriceS + rubleEnding);

        //сколько каждый
        double eachdudeD = fullprice / eachdudepay;
        rublesconvert(eachdudeD);
        String eachdudeS = String.format("%.2f", eachdudeD);
        System.out.println("Каждый должен заплатить по: " + eachdudeS + rubleEnding);
    }
}


