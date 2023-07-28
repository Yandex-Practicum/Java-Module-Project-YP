import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Добро пожаловать в калькулятор счета.");
        System.out.println("Это чудо программа поможет вам разделить счет между всеми гостями!");

        int peoples = Peoples.check();
        ArrayList<Product> bill = Bill.billCompiler();

        Calculator calculator  = new Calculator(peoples, bill);

        calculator.printProducts();
        calculator.printSum();
    }
}


