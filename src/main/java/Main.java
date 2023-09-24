
public class Main {
    public static void main(String[] args) {


        Input input = new Input();
        Check check = new Check();
        Format format = new Format();

        int people = input.getIntInput("На сколько человек нужно разделить счет?");
        float sum = check.getItem();
        float resultPrice = format.money(people, sum);
        String resultLine = format.endString(resultPrice);
        System.out.println(resultLine);
    }

}