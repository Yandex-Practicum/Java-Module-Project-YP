import java.util.Scanner;

public class Input {
    //поля
    private int peopleQty;

    // Методы
    public void enterPeopleQty() {
        Scanner scanP = new Scanner(System.in);
        scanP.useDelimiter("\n");

        while (true) {
            try {
                System.out.println("На скольких человек следует разделить счёт? Введите количество: ");
                int quantity = scanP.nextInt(); // считывание количества человек с клавиатуры
                if (quantity > 1) {
                    peopleQty = quantity;
                    System.out.println("Хорошо, давайте разделим счёт на " + peopleQty + "-х человек");
                    break;
                } else {
                    System.out.println("Ошибка. Для корректной работы программы колличество человек должно быть больше 1. Пожалуйста введите повторно");
                }
            } catch (Exception e2) {
                System.out.println("Ошибка ввода. Пожалуйста введите число, равное количеству человек");
                scanP.next();
            }
        }

    }

    public int getPeopleQty() {
        return peopleQty;
    }

}