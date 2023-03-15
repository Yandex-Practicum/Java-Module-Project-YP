import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {


    public static void main(String[] args) {
        Calculator calc = new Calculator(); {
        Scanner scanner = new Scanner(System.in);
        String nameOfProduct = "";
        double priceOfProduct = 0.0;
        String fullList = "";
        double totalAmount = 0.0;
        while (true) { // не стал делать проверку по введенному значению. Она есть дальше при делении счета.
            System.out.println("Введите название и цену товара! Если хотите закончить, то введите 'завершить'!");
            nameOfProduct = scanner.next();
                if (nameOfProduct.equalsIgnoreCase("завершить")) {
                    System.out.println(fullList);
                    String fullListsCost = "Общая сумма всего списка:  %.2f ";
                    System.out.println(String.format(fullListsCost, totalAmount) + calc.GetRubleAddition(priceOfProduct));
                    break;
                } else {
                    priceOfProduct = scanner.nextDouble();
                    totalAmount = totalAmount + priceOfProduct;
                    String cost = "%.2f";
                    System.out.println("Товар добавлен!");
                    fullList = (fullList.concat(nameOfProduct + " " + String.format(cost, priceOfProduct)) + "\n");
                }
        }
        System.out.println("На скольких человек необходимо разделить счет?");
            int numberOfPersons = 0;
            while (true) {
                while (!scanner.hasNextInt()) {
                    System.out.println("Не является числом, повторите ввод!");
                    String numberOfPersons1 = scanner.next();
                }
                while (scanner.hasNextInt()) {
                    numberOfPersons = scanner.nextInt();
                    if (numberOfPersons <= 1) {
                        System.out.println("Количество персон должно быть больше 1. Повторите ввод!");
                    } else if (numberOfPersons > 1) {
                        System.out.println("Разделим сумму счета на " + numberOfPersons + "!");
                        calc.calculate(totalAmount, numberOfPersons);
                        return;
                    }
                    break;
                }
            }
        }
    }
}

