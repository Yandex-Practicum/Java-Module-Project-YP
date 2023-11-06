import java.util.Scanner;

public class Main {
    public void main(String[] args) {

       System.out.println("На сколько человек необходимо разделить счёт?");

        Scanner scanner = new Scanner(System.in);

        int numberPersons;

        while (true) {
            numberPersons = scanner.nextInt();
            if (numberPersons > 1) {
                break;
            } else {
                System.out.println("Ошибка! Введено меньше 2. Введите корректное количество гостей");
            }
        }

        Calculation calculation = new Calculation(numberPersons);

        System.out.println("Введите название товара и его стоимость");

        while (true) {
            String product = scanner.next();
            if (product.equalsIgnoreCase("завершить")){
                break;
            } else {
                while (true) {
                    double amount = scanner.nextDouble();
                    if (amount > 1) {
                        calculation.addProduct(product, amount);
                        break;
                    } else {
                        System.out.println("Ошибка! Введено отрицательное значение! Введите корректную цену");
                    }

            }
        }

        System.out.println(calculation.productList);
        System.out.println(calculation.divideCheck());

    }
}

class Calculation {

    String productList = "Добавленные товары:";
    int numberPersons;
    double totalAmount;

    Calculation(int numberPersons){
        this.numberPersons = numberPersons;
    }

    public void addProduct(String product, double amount){
        productList = productList + "\n" + product;
        totalAmount = totalAmount + amount;
    }

    public String divideCheck(){

        if (numberPersons == 0) {
            return "Ошибка: нет персон";
        }

        double result = totalAmount / numberPersons;

        String ending;

        switch ((int)Math.floor(result)){
            case 1:
                ending = " рубль";
                break;
            case 2:
            case 3:
            case 4:
                ending = " рубля";
                break;
            default:
                ending = " рублей";
                break;
        }

        return String.format("%.2f", result) + ending;
    }

}}