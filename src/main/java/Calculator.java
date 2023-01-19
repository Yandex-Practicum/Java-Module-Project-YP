import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Calculator {

    public static void GoodsPrice() {
        int kol = Main.getPeopleCount();
        ArrayList<Product> products = new ArrayList<>();
        double allPrices = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Введите название товара");
            String nameGoods = scanner.nextLine();

            if (nameGoods.equalsIgnoreCase("Завершить")) {
                break;
            } else {
                System.out.println("Введите цену товара");
                if (scanner.hasNextDouble()) {
                    double priceGoods = scanner.nextDouble();
                    products.add(new Product(nameGoods, priceGoods));
                    allPrices = allPrices + priceGoods;
                    System.out.println("Товар добавлен");
                }
                else {
                    System.out.println("Цена введена неправильно.Попробуйте еще раз");
                }
                scanner.nextLine();
            }

        }
        System.out.println("Добавленные товары:");
        for (int i=0; i<products.size();i++){
            System.out.println(products.get(i).name+" за "+products.get(i).price);
        }
        System.out.println("Общая сумма: "+ String.format("%.2f", allPrices));
        int price= (int) (allPrices/kol);
        if(price % 100 > 10 && price % 100 < 20 || price % 10 == 0 || price % 10 > 4) System.out.println("Каждый должен заплатить "+ String.format("%.2f", allPrices/kol)+ " рублей");
        else if(price % 10 > 1 && price % 10 < 5) System.out.println("Каждый должен заплатить "+ String.format("%.2f", allPrices/kol)+ " рубля");
        else System.out.println("Каждый должен заплатить "+ String.format("%.2f", allPrices/kol)+ " рубль");
    }
}


