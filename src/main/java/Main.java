
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfPerson = 0;
        //Ввод кол-ва персон
        while (true) {
            System.out.print("Укажите количетсво персон для разделения счета: ");
            numOfPerson = scanner.nextInt();

            if (numOfPerson == 1) { // кол-во персон равно 1
                System.out.println("Ошибка: нельзя разделить счет на одного человека.");
            }
            if (numOfPerson < 1) { // кол-во персон равно меньше 1
                System.out.println("Ошибка: нельзя указать количесвто персон меньше одного.");
            } else {
                break;
            }
        }

        // Создание калькулятора
        double price = 0.0;
        String name = "";

        while (true) {
            System.out.println("Введите название товара (или 'Завершить' для выхода): ");
            String names = scanner.next();
            if (names.equalsIgnoreCase("Завершить")) { // выход из бесконечного цикла при вводе команда "Заверщить"
                break;
            }
            System.out.println("Введите цену товара: ");
            double prices = scanner.nextDouble();

            price += prices;
            name += names + "\n";

            System.out.println("Товар успешно добавлен.");
        }
        // Вывод результатов
        System.out.println("Добавленные товары:\n" + name);

        double pricePerPerson = price / numOfPerson;

        if (pricePerPerson % 2 == 0) {
            System.out.printf("Каждый человек должен заплатить: %.2f рублей\n", pricePerPerson);
        } else {
            System.out.printf("Каждый человек должен заплатить: %.2f рубля\n", pricePerPerson);
        }

    }
}


