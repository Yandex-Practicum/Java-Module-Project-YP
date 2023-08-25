import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int countPeople = getCountpeople();
        calculateProduct(countPeople);
    }

    private static int getCountpeople() {
        int countPeople;
        while (true){
            System.out.println("Введите количество людей");
            Scanner scanner = new Scanner(System.in);
            String countPeopleString = scanner.next();
            countPeople = parseStringIntoInt(countPeopleString);
            if (countPeople == 1){
                System.out.println("Нет смысла рассчитывать на 1-го человека");
            }else if (countPeople < 1) {
                System.out.println("Введено некоректное число");
            }else {
                break;
            }
        }
        return countPeople;
    }

    private static void calculateProduct(int countPeople) {
        Calculator calculator = new Calculator();
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название продукта или 'Завершить' что бы закончить." );
            String productName = scanner.next();
            if (productName.equalsIgnoreCase("Завершить")){
                break;
            }
            System.out.println("Введите цену");
            double productPrice;
            String productPriceString = scanner.next();
            productPrice = parseStringIntoDouble(productPriceString);
            if (productPrice < 0){
                System.out.println("Введено некорректное значение");
            }else {
                Product product = new Product(productName, productPrice);
                calculator.addProduct(product,1);
                System.out.println("Продукт добавлен");
            }
        }
        calculator.showProduct();
        double perconСheck = calculator.getProductsum()/countPeople;
        System.out.println("Каждый должен заплатить: " + String.format("%.2f",perconСheck) + " " + calculator.rublesFormat(perconСheck));
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