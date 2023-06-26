import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    final private int numbPeople;
    Scanner scanner = new Scanner(System.in);
    final private ArrayList<Product> arrProducts = new ArrayList<>();

    Calculator(int numbPeople) {
        this.numbPeople = numbPeople;
        addProduct();
    }

    private void addProduct() {
        while (true) {
            arrProducts.add(new Product());
            System.out.println("Товар \""
                    + arrProducts.get(arrProducts.size() - 1).getProductName()
                    + "\" успешно добавлен. \n Введите \"Завершить\" чтобы перейти к подсчёту "
                    + "или нажмите \"Enter\" чтобы продолжить работу.");
            if (isFinish()) {
                finalCount();
                break;
            }
        }
    }

    private void finalCount() {
        double sum = 0, res;

        StringBuilder resStrB = new StringBuilder("Добавленные товары: \n");

        for (Product product : arrProducts) {
            resStrB.append( product.getProductName()
                    .concat(": ")
                    .concat(
                            String.format("%.2f", product.getProductPrice()))
                    .concat(Formatter.getEndWord(product.getProductPrice()))
                    .concat(",\n"));
            sum += product.getProductPrice();

        }

        System.out.println(resStrB.substring(0, resStrB.length() - 2) + ".");
        res = sum / numbPeople;
        System.out.println("--------");
       System.out.println(
                String.format("ИТОГ: каждый должен заплатить %.2f ", res) +
                        Formatter.getEndWord(res));

    }

    private boolean isFinish() {
        String tmpStr = scanner.nextLine().trim();
        return  "завершить".equalsIgnoreCase(tmpStr);

    }



}
