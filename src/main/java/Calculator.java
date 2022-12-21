public class Calculator {
    double totalAmount = 0;
    String listOfProducts = "";

    void AddProductToCalculator(String productName, double costOfGood){

        FillInTheListOfProducts(productName);
        sum(costOfGood);

        System.out.println("Товар добавлен - " + productName);
    }

    void sum(double sum) {
        this.totalAmount = this.totalAmount + sum;
    }

    void FillInTheListOfProducts(String productName) {
        this.listOfProducts = this.listOfProducts + "\n" + productName;
    }

}
