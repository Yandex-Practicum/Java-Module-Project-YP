import java.util.*;



public class Calculator {
    public static final Scanner scanner = new Scanner(System.in);
    String productNames;
    double sumMoney;
    Calculator(String productNames, double sumMoney){
        this.productNames = productNames;
        this.sumMoney = sumMoney;
    }
    void addProduct(){
        System.out.println("Введите название нового товара ");
        String nameOfProduct = scanner.next();


        System.out.println("Введите цену товара");
        double priceOfProduct = checkInputPrice();



        System.out.println("\nТовар успешно добавлен! \n");
        Product prod = new Product(nameOfProduct, priceOfProduct);
        productNames += nameOfProduct + "\n";
        sumMoney += priceOfProduct;

    }

    //Проверка ввода корректной цены
    public static double checkInputPrice(){
        double userInputDouble;
        while (true) {

            String userInput = scanner.next();
            if (isDouble(userInput)) {
                userInputDouble = Double.parseDouble(userInput);
                if (userInputDouble > 0)
                    break;
                else
                    System.out.println("Введите корректную цену товара больше нуля!");
            } else
                System.out.println("Введите корректную цену товара!");

        }
        return userInputDouble;
    }


    //Функция проверки на ввод дробного числа
    public static boolean isDouble(String x) throws NumberFormatException
    {
        try {
            Double.parseDouble(x);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

}
