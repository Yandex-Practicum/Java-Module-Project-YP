
public class Main {
    public static void main(String[] args) {
        Сalculator сalculator = new Сalculator();
        People people = new People();
        Format format = new Format();
        int humans = people.addNumberOfPeople();
        double totalAmount = сalculator.addProducts();
        double personalAmount = totalAmount / humans;
        format.printResult(totalAmount, personalAmount);
    }
}
