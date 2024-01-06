import java.util.Scanner;

public class InputHandler {

    Scanner scanner;
    private static final String CANCEL_COMMAND = "Завершить";

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public int handleGuestAmount() {
        System.out.println("Привет, на сколько человек необходимо разделить счет?");
        while (true) {
            if (scanner.hasNextInt()) {
                int guestAmount = scanner.nextInt();
                if (guestAmount < 1) {
                    System.out.println("Некорректное значение для подсчёта");
                } else if (guestAmount == 1) {
                    System.out.println("Нет смысла ничего считать и делить!");
                } else {
                    return guestAmount;
                }
            } else {
                System.out.println("Пожалуйста, введите число: ");
                scanner.next();
            }
        }
    }

    public void handleItemDescription(Calculator calculator) {
        while (true) {
            System.out.println("Введите название товара и его стоимость: ");
            String name = scanner.next();
            if (scanner.hasNextDouble()) {
                double price = scanner.nextDouble();
                if (price > 0) {
                    calculator.items.add(new Item(name, price));
                    System.out.println("Товар был успешно добавлен");
                } else {
                    System.out.println("Цена товара не может быть отрицательной!");
                    continue;
                }
            } else {
                System.out.println("Цена товара должна быть представлена в числовом выражении!");
                scanner.next();
                continue;
            }

            System.out.println("""
                    Хотите добавить еще один товар?\s
                    введите 'да' или любой символ для продолжения внесения списка товаров,\s
                    'завершить' - для получения результатов""");
            if (CANCEL_COMMAND.equalsIgnoreCase(scanner.next())) {
                break;
            }
        }
    }
}
