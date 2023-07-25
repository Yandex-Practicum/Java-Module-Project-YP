import services.ConsoleCommunicator;
import utils.Consts;

public class Main {
    public static void main(String[] args) {
        var communicator = new ConsoleCommunicator();
        var persons = communicator.readInteger(Consts.ENTER_PERSONS_PROMT);
        var calculator = Calculator.createInstance(persons, communicator);
        calculator.readGoods();
        calculator.printGoods();
    }
}