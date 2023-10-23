import java.util.Scanner;
class Product {
    private String allProducts = "";
    private double countProduct = 0;
    public double count () {
        Scanner sc = new Scanner(System.in);

        String nameProduct ;
        String answer;
        double priceProduct;

        do {
            System.out.print("Введите наименование товара: ");
            nameProduct = sc.nextLine();
            allProducts += "\n" + "-" + nameProduct;

            do {
                System.out.print("Введите стоимость товара: ");
                while (!sc.hasNextDouble()) {
                    sc.next();
                    System.out.print("Введено некорректное значение, укажите числовое значение: ");
                }
                priceProduct = sc.nextDouble();
                if (priceProduct <= 0) {
                    System.out.println("Значение должно быть больше нуля.");
                }
            } while (priceProduct <= 0);
            countProduct += priceProduct;

            System.out.println("Товар успешно добавлен!");
            sc.nextLine();

            do {
                System.out.println("Введите -продолжить- для добавление нового товара или -завершить- для завершения программы");
                answer = sc.nextLine();

                switch (answer.toLowerCase()) {
                    case "продолжить", "завершить":
                        break;
                    default:
                        System.out.println("Введите корректный ответ");
                }
            } while (!answer.equalsIgnoreCase("продолжить") && !answer.equalsIgnoreCase("завершить"));

        } while (answer.equalsIgnoreCase("продолжить"));

        return countProduct;
    }
    public String getAllProducts() {
        return allProducts;
    }
}