
public class Main {
    public static void main(String[] args) {

        Input input = new Input();
        Check check = new Check();
        float sum = 0;
        int people = input.getIntInput("На сколько человек нужно разделить счет?");
        sum = check.getItem("Пожалуйста введите название товара и его стоимость:");
        System.out.println(sum);
    }

}