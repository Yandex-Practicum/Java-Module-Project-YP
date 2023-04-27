import java.util.Scanner;

class ProductAndPrice {
    public double calculator = 0;
    public String nameProduct = "";
    String product = "";

    public void Calc() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.println("Введите название товара");
            product = scanner.nextLine();
            nameProduct += product + "; \n";
            double price = -1;
            while (price <= 0) {
                System.out.println("Введите стоимость продукта");
                try {
                    input = scanner.nextLine();
                    price = Double.parseDouble(input);
                    if (price <= 0) {
                        price = -1;
                        continue;
                    }
                } catch (Exception Error) {
                    System.out.println("Стоимость продукта должна быть больше 0. Введите стоимость ещё раз");
                }
                calculator += price;
            }
            System.out.println("Товар успешно добавлен.\nХотите ли Вы добавить ещё товар?\nЕсли нет, то нажмите \"Завершить\".");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Завершить")) {
                break;
            }
            System.out.println("Добавленные товары:" + "\n" + nameProduct);
        }
    }
}