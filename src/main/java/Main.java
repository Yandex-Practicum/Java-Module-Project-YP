import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {


    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double priceOfProduct = 0.0;
        String nameOfProduct = "";
        String fullList = "";
        double totalAmount = 0.0;
        String cost = "%.2f";
        while (true) {
            System.out.println("Введите название и цену товара! Если хотите закончить, то введите 'завершить'!");
            nameOfProduct = scanner.nextLine();
            if (nameOfProduct.equalsIgnoreCase("завершить")) {
                System.out.println(fullList);
                String fullListsCost = "Общая сумма всего списка:  %.2f ";
                System.out.println(String.format(fullListsCost, totalAmount) + calc.getRubleAddition(priceOfProduct));
                break;
            } else {
                while (true) {
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Не является числом, повторите ввод!");
                        scanner.nextLine();
                    }
                    priceOfProduct = scanner.nextDouble();
                    scanner.nextLine();
                    if (priceOfProduct <= 0) {
                        System.out.println("Цена должны быть больше 0! Повторите ввод!");
                    } else {
                        totalAmount = totalAmount + priceOfProduct;
                        System.out.println("Товар добавлен!");
                        fullList = (fullList.concat(nameOfProduct + " " + String.format(cost, priceOfProduct)) + "\n");
                        break;
                    }
                }
            }
        }
        System.out.println("На скольких человек необходимо разделить счет?");
        int numberOfPersons = 0;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Не является числом, повторите ввод!");
                scanner.next();
            }
            numberOfPersons = scanner.nextInt();
            if (numberOfPersons <= 1) {
                System.out.println("Количество персон должно быть больше 1. Повторите ввод!");
            } else {
                System.out.println("Разделим сумму счета на " + numberOfPersons + "!");
                calc.calculate(totalAmount, numberOfPersons);
                return;
            }
        }
    }
}










