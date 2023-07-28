import java.util.ArrayList;

public class Bill {

    public static ArrayList<Product> billCompiler () {
        ArrayList<Product> bill = new ArrayList<>();

        while(true) {
          System.out.println("Напишите название товара, если хотите выйти напишите - завершить");
          String name = NameChecker.check();

          if (name.equalsIgnoreCase("завершить")) {
              break;
          }
          System.out.println("Напишите цену товара в формате рублей.копеек");
          double price = PriceChecker.check();
          Product product = new Product(name, price);
          bill.add(product);
          System.out.println("Спасибо товар успешно добавлен");
        }

        return bill;
    }
}
