public class Main {
    public static void main(String[] args) {
        int persons = Calculator.calculator();
        double cost = Calculator.stuffCost();
        Format.format(persons,cost);
    }
}