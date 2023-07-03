import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Вввод количества человек с проверкой ввода
        Input peopleQuantity = new Input();
        peopleQuantity.enterPeopleQty();

        // После ввода количества человек создаем список товаров
        ProductList productList = new ProductList();

        // Цикл ввод товаров в список
        while (true) {
            System.out.println("Введите название товара: ");
            productList.setProductName();
            System.out.println("Введите стоимость этого товара в формате 'рубли,копейки' (например: 123,45): ");
            productList.setProductPrice();
            productList.updateList();
            System.out.println("Вы хотите добавить ещё один товар?\n-Для продолжения введите любой символ\n-Если хотите закончить и получить результат, введите слово \"Завершить\"");
            String userAnswer = scanner.next();
            if (userAnswer.equalsIgnoreCase("завершить")) {
                break;
            }
        }
        System.out.println(productList.getList() + "Общей стоимостью: " + String.format("%.2f", productList.getTotalAmount()) + " руб.\n");


        // Создаем объект калькулятор для расчёта суммы для каждого человека
        Calculator calculator = new Calculator();
        calculator.setAmount(productList.getTotalAmount());
        calculator.setPeopleQty(peopleQuantity.getPeopleQty());
        calculator.calculate(); // метод расчета суммы для каждого человека


        // Создаем объект result для вывода правильного падежа слова "рубль" в итоговом сообщении
        Result result = new Result();
        result.setRubValue(calculator.getCalculationResult());
        result.format();
        String resultTemplate = "Каждый из " + peopleQuantity.getPeopleQty() + "-х человек должен заплатить %.2f %s";
        System.out.println(String.format(resultTemplate, calculator.getCalculationResult(), result.getRubFormat()));
        System.out.println("Работы программы завершена.");
    }
}