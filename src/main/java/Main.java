import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Persons persons = new Persons();
        persons.quantityPersons();


        Formatter formatter = new Formatter();
        formatter.formatMat();
        formatter.padejRub();

    }

}

class Persons {
    Scanner scanner = new Scanner(System.in);
    int newpersone;

     public void quantityPersons() {

        while (true) {
            System.out.println("Введите количество гостей:");
            newpersone = scanner.nextInt();
            if (newpersone > 1) {
                System.out.println("На " + newpersone + " гостей будет поделен счет.\n");
                break;
            }
            else if(newpersone < 1) {
                System.out.println("Введите корректное число гостей");
            }
            else {
                System.out.println("Некорректные данные");
            }
        }
    }
}

class Product{
    String nameProduct;
    double priceProduct;



}


class Calculator {
    Scanner scanner = new Scanner(System.in);
    Product product = new Product();
    String sumNameProduct = "";
    double sumPriceProduct;



    public void calculate() {


        while (true) {

            System.out.println("Введите название товара:");
            product.nameProduct = scanner.next();

            if (product.nameProduct.equalsIgnoreCase("Завершить")) {
                System.out.println("Добавление товара завершено.");
                break;
            }

            System.out.println("Введите цену блюда:");
            product.priceProduct = scanner.nextDouble();


            sumPriceProduct = sumPriceProduct + product.priceProduct;
            sumNameProduct = sumNameProduct + product.nameProduct + "\n";
        }
    }
}


class Formatter {
    Calculator calculator = new Calculator();

    public void formatMat() {
        calculator.calculate();
        String str = "Добавленные товары:\n%sСумма с человека:";
        String formatRubl = calculator.sumNameProduct;
        double formatDouble = calculator.sumPriceProduct;
        System.out.println(String.format(str, formatRubl, formatDouble));

    }

    public void padejRub() {
        int x = (int) (calculator.sumPriceProduct % 100);
        int y = (int) (calculator.sumPriceProduct % 10);
        if (x == 1 || y == 1)
            System.out.println(calculator.sumPriceProduct + " рубль");
        if (5 > x && x > 1 || y > 1 && y < 5)
            System.out.println(calculator.sumPriceProduct + " рубля");
        if (20 > x && x > 10 || y > 5 && y < 10)
            System.out.println(calculator.sumPriceProduct + " рублей");
    }


}

