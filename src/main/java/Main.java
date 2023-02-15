
public class Main {
    public static void main(String[] args) {
        Persons persons = new Persons();
        persons.quantityPersons();
        Formatter formatter = new Formatter();
        Calculator calculator = new Calculator();
        calculator.calculate();
        String str = "Добавленные товары:\n%sСумма с человека: %d %s";
        String formatRubl = calculator.sumNameProduct;
        int formatDouble = (int) (calculator.sumPriceProduct / persons.newpersone);
        String s = formatter.padejRub(formatDouble);
        System.out.println(String.format(str, formatRubl, formatDouble, s));
    }
}