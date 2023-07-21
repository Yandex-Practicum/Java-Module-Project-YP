import java.util.List;

public class App {
    public void run() {
        int amountOfPeople = Interactor.acquireAmountOfPeople();
        List<Item> items = Interactor.acquireItems();
        Calculator calculator = new Calculator(amountOfPeople, items);
        Reporter.getFullReport(calculator);
    }
}
