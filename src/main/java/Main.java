import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static int userInput;
    public static void main(String[] args) {
        System.out.println("Здравствуйте, сколько гостей будет ужинать? (введите число):");
        theQuestion();
        System.out.println("Введите название товара:");

    }

    public static void theQuestion(){
        try {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("Должно быть как минимум 2 гостя, для разделения счёта. Пожалуйста, укажите число гостей:");
                theQuestion();
                break;
            } else if (userInput > 1){
                System.out.println("Прошёл");
                break;
            } else {
                System.out.println("Пожалуйста, укажите число гостей:");
                theQuestion();

            }
        }
        } catch (NoSuchElementException e) {
            System.out.println("Ошибка! укажите число гостей:");
            theQuestion();
        }
    }

}