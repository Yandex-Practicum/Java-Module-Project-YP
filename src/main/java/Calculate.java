import java.util.ArrayList;
import java.util.Scanner;

public class Calculate {

    private final Scanner scanner = new Scanner(System.in);

    String check = "";
    Double countProducts = 0.0;

    public void calculate(String name) {
        ArrayList<Product> products = new ArrayList<>();

        System.out.println(name + " Напишите название блюда");
        while (true) {
            String productName = scanner.next();

            if (productName.equalsIgnoreCase("Завершить")) {
                if (products.size() == 0) {
                    System.out.println("У " + name + " не добавлено ни одного блюда");
                } else {
                    System.out.println("Добавденные товары: ");
                    for (int j = 0; j < products.size(); j++) {
                        double temp2 = products.get(j).count;
                        int convertRub2 = (int) temp2;
                        System.out.println(products.get(j).name + " - " + products.get(j).count + " " + convertRubDeclination(convertRub2));
                    }
                }
                break;
            }

            if (checkString(productName)) {
                System.out.println("Вы ввели некорректное название блюда");
                continue;
            }

            System.out.println(name + " Напишите цену блюда");
            double productPrice;
            while (true) {
                try {
                    productPrice = Double.parseDouble(scanner.next());
                    if (productPrice <= 0) {
                        System.out.println("Вы ввели минусовую цену. Попробуйте ще раз.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Вы ввели некорректное значение цены. Попробуйте еще раз.");
                }

            }

            products.add(new Product(productName, productPrice));
            double temp1 = productPrice;
            int convertRub = (int) temp1;
            System.out.println("Вы успешно добавили блюдо " + "\"" + productName + "\"" + " стоимостью " + productPrice + " " + convertRubDeclination(convertRub) + " в счет");
            countProducts += productPrice;
            check += productName + " - " + productPrice + " " + convertRubDeclination(convertRub) + "\n";

            System.out.println("Хотите ли вы добавить ещё один товар?\nЕсли нет, напишите - Завершить, если хотите продолжить, напишите название следующего блюда.");


        }


    }

    public String convertRubDeclination(int number) {
        int lastDigit = number % 100 / 10;
        if (lastDigit == 1) {
            return "рублей";
        }

        switch (number % 10) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }

    private boolean checkString(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
