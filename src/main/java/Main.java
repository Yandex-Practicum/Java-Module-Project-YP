


public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int numberOfPeople = calculator.getTheQuantity();
        String list = calculator.inputName(numberOfPeople);
        System.out.println("Количество человек: " + numberOfPeople);
        System.out.println(list);
    }
}
