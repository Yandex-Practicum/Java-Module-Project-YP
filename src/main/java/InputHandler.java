import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {

    public int getPeopleCount() {
        int numberOfPeople = 0;
        boolean flag = false;

        while (!flag) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                numberOfPeople = scanner.nextInt();
                if (numberOfPeople <= 0) {
                    System.out.println("Введено не корректное значение количества человек");
                } else if (numberOfPeople == 1) {
                    System.out.println("Не целесообразно делить счет на одного человека, введите несколько человек");
                } else {
                    flag = true;
                }
            }
        }
        return numberOfPeople;
    }

        public ArrayList<Product> getProductsList() {
            ArrayList<Product> products = new ArrayList<>();
            String currentInput = "";

            while (!currentInput.equalsIgnoreCase("Завершить")) {
                System.out.println("Если хотите добавить товар в чек введите \"Наименование товара\" если нет, то \"Завершить\"");
                Scanner scanner = new Scanner(System.in);
                currentInput = scanner.next();
                double price = 0;
                if (!currentInput.equalsIgnoreCase("Завершить")) {
                    String name = currentInput;
                    System.out.println("Введите цену товара ");
                    boolean flag = false;
                    while (!flag) {
                        Scanner secondScanner = new Scanner(System.in);
                        if (secondScanner.hasNextDouble()) {
                            price = secondScanner.nextDouble();
                            flag = !(price <= 0);
                            if (!flag) {
                                System.out.println("Введите корректную цену");
                            }
                        } else {
                            System.out.println("Введите корректную цену");
                        }
                    }
                    Product product = new Product(name, price);
                    products.add(product);
                    String rubName = ResultHandler.getRubName(product.price);
                    String format = ("Товар \"%s\" с ценой %.2f %s добавлен в чек");
                    System.out.println(String.format(format,product.name, product.price, rubName));
                }
            }
            return products;
        }
}
