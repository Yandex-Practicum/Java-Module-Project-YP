import java.util.InputMismatchException;
import java.util.Scanner;

public class Products {
    static String strProducts = "";
    static double sum = 0;
    static double productPrice;
    static void productCount() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Хотите добавить товар?");
            String productInput = scanner.next();
            switch (productInput.toLowerCase()) {
                case "да":
                    while (true) {
                        System.out.println("Введите название товара.");
                        String productName = scanner.next();
                        strProducts = strProducts.concat("\n").concat(productName);
                        while (true) {
                            System.out.println("Введите стоимость товара.");
                            try {
                                productPrice = scanner.nextDouble();
                            }catch (InputMismatchException b){
                                System.out.println("Введено не число.");
                                scanner.nextLine();
                            }
                            if (productPrice > 0) {
                                break;
                            } else if (productPrice < 0) {
                                System.out.println("Стоимость не может быть отрицательной!");
                            }
                        }
                        System.out.println("Товар добавлен!");
                        sum = sum + productPrice;
                        System.out.println("Хотите добавить еще товар? (Введите \"Завершить\" ,чтобы завершить процесс добавления товаров.)");
                        String productInput2 = scanner.next();
                        switch (productInput2.toLowerCase()) {
                            case "да":
                                break;
                            case "нет":
                                return;
                            case "завершить":
                                return;
                            default:
                                while (true) {
                                    System.out.println("Введите \"Да\" ,чтобы добавить товар.\nВведите \"Завершить\" ,чтобы завершить процесс добавления товаров.");
                                    String productInput3 = scanner.next();
                                    if (productInput3.equalsIgnoreCase("да")) {
                                        break;
                                    } else if (productInput3.equalsIgnoreCase("Завершить")) {
                                        return;
                                    } else {
                                    }
                                }
                        }
                    }
                case "нет":
                    return;
                default:
                    System.out.println("Введите да или нет!");
            }
        }
    }
}
