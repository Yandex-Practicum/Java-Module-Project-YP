import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("На сколько человек необходимо разделить счёт?");

        Scanner scanner = new Scanner(System.in);

        int numberPersons;

        while (true) {
            if (scanner.hasNextInt()) {
                numberPersons = scanner.nextInt();
                if (numberPersons > 1) {
                    break;
                } else {
                    System.out.println("Ошибка! Введено меньше 2. Введите корректное количество гостей. Для закрытия программы напишите \"выход\"");
                }
            } else {
                String exit = scanner.next();
                if (exit.equalsIgnoreCase("выход")) {
                    System.out.println("Завершена работы программы!");
                    return;
                } else {
                    System.out.println("Ошибка! Введено не число. Введите корректное количество гостей. Для закрытия программы напишите \"выход\"");
                    scanner.nextLine();
                }
            }
        }

        Calculation calculation = new Calculation(numberPersons);

        while (true) {
            System.out.println("Введите название товара. Для закрытия программы напишите \"завершить\""); // можно сделать через useDelimeter(). думаю пока как обработать несколько пробелов
            String product = scanner.next();
            if (product.equalsIgnoreCase("завершить")) {
                break;
            } else {
                while (true) {
                    System.out.println("Введите стоимость товара (руб,коп).");
                    try {
                        double price = scanner.nextDouble();
                        if (price > 0) {
                            calculation.addProduct(product, price);
                            break;
                        } else {
                            System.out.println("Ошибка! Введено отрицательное значение!");
                        }
                    } catch (Exception err){
                        System.out.println("Ошибка! Введено не число");
                        scanner.nextLine();
                    }
                }
            }
        }

        System.out.println(calculation.productList);
        System.out.println(calculation.divideCheck());
    }
}

