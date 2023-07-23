import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Укажите количество человек, на которых необходимо разделить счёт:");

        //Ввод количества людей и проверка
        int peopleAmount;
        while (true) {
            peopleAmount = scanner.nextInt();
            if (peopleAmount == 1 || peopleAmount == 0) {
                System.out.println("Пожалуйста, укажите большее количество человек:");
            } else if (peopleAmount <= -1) {
                System.out.println("Указано отрицательное число. Пожалуйста, введите другое число:");
            } else {
                break;
            }
        }

        //Добавление товаров в корзину

        Calculator calculator = new Calculator();

        System.out.println("Добавьте товар в корзину. Для этого укажите его наименование:");

        while (true) {
            String productName = scanner.next();
            if (productName.equalsIgnoreCase("завершить")) {
                break;
            } else {
                System.out.println("Укажите стоимость товара:");
                while (true) {
                    float price = scanner.nextFloat();
                    if (price > 0) {
                        calculator.addNameToCart(productName);
                        calculator.costing(price);
                        System.out.println("Введите название следующего товара, чтобы добавить его в корзину. " +
                                "Чтобы завершить добавление товаров и расчитать стоимость для каждого человека введите \"Завершить\":");
                        break;
                    }
                    else {
                        System.out.println("Введено отрицательное число. Пожалуйста, повторно введите стоимость:");
                    }

                }
            }
        }
        calculator.calculatePerPeople(peopleAmount);
        calculator.finalOutput();
    }
}