import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("На сколько человек разделить счет?");

        int visitors = 0;

        // узнаем сколько на сколько человек делить счет

        while(true){
            Scanner scanner = new Scanner(System.in);
            try{
                visitors = scanner.nextInt();
                if(visitors > 1){
                    break;
                } else if(visitors == 1){
                    System.out.println("Одному человеку нечего делить, введите количество человек от 2 и больше");
                } else {
                    System.out.println("Число не может быть нулем или отрицательным");
                }
            } catch (NoSuchElementException e){
                System.out.println("Введите количество человек, число должно быть целым");
            }
        }



        Calculator calculator = new Calculator();
        // узнаем у пользователя что было заказано
        calculator.addItems();
        // показываем список товаров
        calculator.showItems();
        // считаем
        calculator.calculate(visitors);
    }
}