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

            System.out.print("Введите стоимость товара: ");
            priceProduct = sc.nextDouble();
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