import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        int guestCounter;
        //int productCount = 0; - устарело, с заменой на массив

        //ПЕРВЫЙ ЗАПУСК
        System.out.println("\n\nЭто - калькулятор для поиска вашей доли от общей стоимости счёта. " +
                "\n(гостей должно быть больше одного)");

        //БЕСКОНЕЧНЫЙ ЦИКЛ ДЛЯ ВВОДА ЧИСЛА ГОСТЕЙ
        while (true) {
            System.out.println("\nВведите количество гостей:");
            if (scanner.hasNextInt()) {
                guestCounter = scanner.nextInt();
                if (guestCounter > 1) {
                    System.out.println("Количество гостей: " + guestCounter);
                    break;
                } else {
                    System.out.println("Необходимо ввести целое число больше единицы.");
                }
            } else {
                System.out.println("Необходимо ввести число.");
            }
            scanner.nextLine(); // ОЧИСТКА БУФЕРА ОБМЕНА ПОСЛЕ СЧИТЫВАНИЯ (вне зависимости от ввода)
        }

        //ОЧИСТКА ПОЛЯ ВЫВОДА С ПРОКРУТКОЙ ВНИЗ (мне так приятненько)
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        //scanner.nextLine(); // ОЧИСТКА БУФЕРА ОБМЕНА ПОСЛЕ СЧИТЫВАНИЯ

        //СОЗДАЁМ МАССИВ БЛЮДО - ЦЕНА
        System.out.println("Для выхода из режима ввода пар <<блюдо - цена>>, введите " +
                "<<завершить>> вместо наименования следующего блюда\n");
        while (true) {
            Product product = Product.createProduct(scanner);
            //productCount++;  - устарело, с заменой на массив
            if (product == null) {
                break; // Завершаем цикл, если введено "завершить"
            }
            productList.add(product);
        }

        // ВЫВОДИМ МАССИВ БЛЮДО - ЦЕНА
        System.out.println("Заказанные блюда:");
        double sumTotal = 0;
        for (Product product : productList) {
            sumTotal += product.getPrice();
            System.out.println(product.getName() + " - " + product.getPrice());
        }
        //ВЫВОДИМ ОБЩУЮ СУММУ И ДОЛЮ ПОЛЬЗОВАТЕЛЯ
        System.out.println("Общая сумма счёта составила" + AmountFormatter.formatAmount(sumTotal)
                + ",\nиз них ваша часть счёта составляет" + AmountFormatter.formatAmount(sumTotal/guestCounter));
    }
}
