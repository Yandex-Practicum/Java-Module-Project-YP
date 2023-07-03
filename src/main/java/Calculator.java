public class Calculator {

    // поля
    private double amount;
    private int peopleQuantity;
    private double calculationResult;


    // методы
    public void setAmount (double totalAmount) {
        amount = totalAmount;
    }
    public double getAmount() {
        return amount;
    }

    public void setPeopleQty (int peopleQty) {
        peopleQuantity = peopleQty;
    }
    public int getPeopleQty() {
        return peopleQuantity;
    }

    public void calculate () {
        calculationResult = amount/peopleQuantity;
    }

    public double getCalculationResult() {
        return calculationResult;
    }

}
