import services.ConsoleCommunicator;
import utils.Consts;

public class Main {
    private static final String TEMPLATE
            = "\u001B[31mОшибка: %s. Перезапустите программу и повторите ввод.";
    public static void main(String[] args) {
        var communicator = new ConsoleCommunicator();
        try {
            var persons = communicator.readInteger(Consts.ENTER_PERSONS_PROMT);
            var calculator = Calculator.createInstance(persons, communicator);
            calculator.readGoods();
            calculator.printGoods();
        } catch (RuntimeException e){
            communicator
                    .showNotification(
                            String.format(TEMPLATE, e.getMessage()));
            System.out.print("\u001B[0m");
        }

    }
}