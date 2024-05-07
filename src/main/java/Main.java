public class Main {
    public static void main(String[] args) {
        AddProductsToTheBill.askTheBill();
        Calculator.addProductsToTheList();

        Calculator.printItems();
        System.out.println("Каждый должен заплатить по " + FormatCurrency.formatCurrency(Calculator.calculate()));
    }
}