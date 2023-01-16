import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        makeRequest();
    }

    public static void makeRequest(){
        while(true){
            System.out.println("Введите на скольких человек необходимо разделить счёт.");
            int countPerson;
            while (!scanner.hasNextInt()) {
                System.out.println("Требуется ввести число!");
                scanner.next();
            }
            countPerson = scanner.nextInt();
            if(countPerson > 1){
                Calculator calculator = addProductsToCalc();
                getCalcInfo(calculator, countPerson);
                break;
            }
            else {
                System.out.println("Кол-во человек не может быть меньше или равно 1.");
            }
        }
    }

    public static Calculator addProductsToCalc(){
        Calculator calculator = new Calculator();
        while (true){
            System.out.println("Введите название продукта");
            String title = scanner.next();
            System.out.println("Введите стоимость продукта");
            double price = 0;
            while (price <= 0){
                while (!scanner.hasNextDouble()) {
                    System.out.println("Требуется ввести число!");
                    scanner.next();
                }
                price = scanner.nextDouble();
                if(price <= 0){
                    System.out.println("Введите положительное число!");
                }
            }

            Product product = new Product(title, price);
            calculator.addProduct(product);
            System.out.println("Вы хотите добавть ещё один продукт? Наберите завешить, чтобы перестать дабавлять продукты");
            String userAnswer = scanner.next();
            if(userAnswer.equalsIgnoreCase("завершить")){
                break;
            }
        }
        return calculator;
    }

    public static void getCalcInfo(Calculator calculator, int countPerson){
        System.out.println("Добавленные товары:");
        for(Product product : calculator.productsList){
            System.out.println("--" + product.title + " Цена " + product.price);
        }
        double averagePrice = calculator.amountProduct / countPerson;
        String rubFormat = "";
        if ((int) averagePrice == 1){
            rubFormat = "рубль";
        }
        else if((int) averagePrice > 1 && (int) averagePrice < 5){
            rubFormat = "рубля";
        }
        else {
            rubFormat = "рублей";
        }

        System.out.println("Сумма которую должен заплатить каждый " + String.format("%.2f", averagePrice) + " " + rubFormat);
    }
}
