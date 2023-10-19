import java.util.Scanner;
class Product {
    private String allProducts = "";
    private double countProduct = 0;
    public double count () {
        Scanner sc = new Scanner(System.in);

        String nameProduct ;
        String answer;
        String end;
        double priceProduct;

        do {
            System.out.print("Введите наименование товара: ");
            nameProduct = sc.nextLine();
            allProducts += "\n" + "-" + nameProduct;

            System.out.print("Введите стоимость товара: ");
            priceProduct = sc.nextDouble();
            countProduct += priceProduct;
            System.out.println("Товар успешно добавлен!");
            sc.nextLine();

            do {
                System.out.println("Хотите ли вы добавить еще один товар? (Да/Нет)");
                answer = sc.nextLine();

                switch (answer) {
                    case "Да","да", "дА", "ДА" :
                        break;
                    case "Нет", "НЕТ", "нЕт", "неТ", "НЕт", "нЕТ", "НеТ", "нет" :
                        break;
                    default:
                        System.out.println("Введите корректный ответ");
                }
            } while (!answer.equalsIgnoreCase("да") && !answer.equalsIgnoreCase("нет"));

        } while (answer.equalsIgnoreCase("да"));

        System.out.println("Введите -Завершить-, для итогового подсчета стоимости товаров: ");
        end = sc.nextLine();
            if (!end.equalsIgnoreCase("Завершить")) {
                do {
                    System.out.println("Введите корректное значение: ");
                    end = sc.nextLine();
                } while (!end.equalsIgnoreCase("Завершить"));
            }
            return countProduct;
    }
    public String getAllProducts() {
        return allProducts;
    }
}