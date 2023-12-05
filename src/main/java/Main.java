import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = 0.0;
        int people = 0;
        String allProducts = "";

        System.out.println("На скольких человек необходимо разделить счёт?");
        while (true) {
            if (scanner.hasNextInt()) {
                people = scanner.nextInt();
                if (people == 1) {
                    System.out.println("Количество людей должно быть больше одного. Повторите ввод.");
                } else if (people < 1) {
                    System.out.println("Некорректное значение для подсчёта. Повторите ввод.");
                }else {
                    break;
                }
            } else {
                System.out.println("Введено некорректное значение. Повторите запуск приложения.");
                return;
            }
        }
        while (true) {
            allProducts += Calculator.processProducts() + "\n";

            sum += Calculator.receiveTheCostOfTheProduct() ;

            System.out.println("Товар успешно добавлен.\nНапишите \"Да\", чтобы продолжить или \"Завершить\", чтобы закрыть программу.  ");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Завершить")) {
                break;
            }
        }
        double priceForOnePerson = (int)sum / people;
        String format = "Каждый человек должен заплатить %.2f ";
        System.out.println("Добавленные товары:" + "\n" + allProducts);
        System.out.println(String.format(format, priceForOnePerson) + Formatter.GetDeclinationRub((int) Math.floor(priceForOnePerson)));
    }
}