import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int peopleCount = getpeopleCount();
        calculateProduct(peopleCount);
    }

    private static int getpeopleCount() {
        int peopleCount;
        while (true){
            System.out.println("Введите кол-во людей");
            Scanner scanner = new Scanner(System.in);
            String peopleCountString = scanner.next();
            peopleCount = parseStringIntoInt(peopleCountString);
            if (peopleCount == 1){
                System.out.println("Нет смысла высчитывать на 1-го человека");
            }else if (peopleCount < 1) {
                System.out.println("Введено неверное число");
            }else {
                break;
            }
        }
        return peopleCount;
    }

    private static void calculateProduct(int peopleCount) {
        Calculator calculator = new Calculator();
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название продукта или \"Завершить\" что бы закончить." );
            String productName = scanner.next();
            if (productName.equalsIgnoreCase("Завершить")){
                break;
            }
            System.out.println("Введите цену в формате \"рубли.копейки\"");
            double productPrice;
            String productPriceString = scanner.next();
            productPrice = parseStringIntoDouble(productPriceString);
            if (productPrice < 0){
                System.out.println("Введено неверное значение");
            }else {
                Product product = new Product(productName, productPrice);
                calculator.addProduct(product,1);
                System.out.println("Продукт добавлен");
            }
        }
        calculator.showProduct();
        double perconСheck = calculator.getProductsum()/peopleCount;
        System.out.println("Каждый должен заплатить по: " + String.format("%.2f",perconСheck) + " " + calculator.rublesFormat(perconСheck));
    }

    private static int parseStringIntoInt(String string){
        try {
            return Integer.parseInt(string);
        }catch (NumberFormatException e){
            return -1;
        }
    }
    private static double parseStringIntoDouble(String string) {
        try {
            return Double.parseDouble(string);
        }catch (NumberFormatException e){
            return -1;
        }
    }



}

