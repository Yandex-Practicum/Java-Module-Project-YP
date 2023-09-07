
public class Main {
    public static void main(String[] args) {
        Сalculator сalculator = new Сalculator();
        People people = new People();
        Format format = new Format();
        int humans = people.addPeople();
        double totalAmount = сalculator.addProducts();
        double personalAmount = totalAmount / humans;
        format.getResult(totalAmount, personalAmount);
    }
}
