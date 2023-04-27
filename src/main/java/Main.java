import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        String input = "";
        int peopleCount = -1;
        while (peopleCount <= 0 ) {
            System.out.println("Введите количество гостей");
            try {
                input = scanner.nextLine();
                peopleCount = Integer.parseInt(input);
            } catch (Exception error) {
                System.out.println("Пожалуйста введите корректное значение");

            }
        }
        System.out.println("Количество человек " + peopleCount);

        ProductAndPrice productAndPrice = new ProductAndPrice();
        productAndPrice.Calc();

        double everyCheck = productAndPrice.calculator / peopleCount;
        System.out.println("Каждому нужно заплатить " + String.format("%.2f", everyCheck) + " " + detectSuffix(everyCheck) + ".");
        System.out.println(productAndPrice.nameProduct);

    }
    public static String detectSuffix(double everyCheck) {
        String rub = "";
        int sumCheck1 = (int) ((Math.floor(everyCheck))%10);
        switch (sumCheck1) {
            case 1:
                rub = "Рубль";
                break;
            case 2:
            case 3:
            case 4:
                rub = "Рубля";
                break;
            default:
                rub = "Рублей";
                break;
        }
        int sumCheck2 = (int) ((Math.floor(everyCheck))%100);
        if (11 <= sumCheck2 & sumCheck2 <= 19) {
            rub = "Рублей";
        }
        return rub;
    }
}
