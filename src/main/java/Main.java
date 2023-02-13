import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Persons persons = new Persons();
        persons.quantityPersons();
        Formatter formatter = new Formatter();
        Calculator calculator = new Calculator();
        calculator.calculate();
        String str = "Добавленные товары:\n%sСумма с человека: %.2f";
        String formatRubl = calculator.sumNameProduct;
        double formatDouble = calculator.sumPriceProduct / persons.newpersone;
        System.out.println(String.format(str, formatRubl, formatDouble));
        String pad = formatter.padejRub();
        System.out.println(pad);
    }
}