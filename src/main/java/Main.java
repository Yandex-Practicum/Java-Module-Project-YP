import android.telephony.SignalThresholdInfo;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Блок приветствия и запрос кол-во персон
        int person;
        System.out.println("На сколько человек необходимо разделить счёт?...");
        while (true) {
            person = input.nextInt();
            if (person <= 1) {
                System.out.println(String.format("Значение %d некорректно.\nВведите значение 2 или более...", person));
                continue;
            } else {
                break;
            }
        }

        //Блок запроса у пользователя товара и его стоимость

        Calculator summator = new Calculator(person); // добавялем объект калькулятор
        ADD:
        while (true) {
            System.out.println("Пожалуйства, введите название товара и его стоимость в формате \"рубли.копейки\"...");
            Products newProducts = new Products(input.next(), input.nextDouble());
            summator.sum(newProducts.priceProducts); // прибавялем стоимость к общеему счету
            summator.spisok(newProducts.nameProducts); // добавляем в коллекцию товар
            System.out.println("Товар успешно добавлен...");
            while (true) {
                System.out.println("Хотите добавить еще один товар...");
                String answer = input.next().trim().toLowerCase(); // ввели ответ, удалили пробелы и изменили регистр
                if (answer.equals("завершить")) {
                    break ADD;
                } else {
                    continue ADD;
                }
            }

        }
        //Блок вывода данных

        System.out.println("Добавленные товары:");
        summator.check(); // Печатаем чек

    }
}