import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ReadLine myReadline = new ReadLine();
        Menu clientMenu = new Menu();

        System.out.println("Добро пожальвать в ресторан \"Sabor De La Vida\"");
        System.out.println("Как вас зовут?");
//        String nameClient = scanner.next();
//        System.out.println("Привет " + name);
        System.out.println("Сколько человек вас будет?");

        myReadline.twoLine();
        clientMenu.menuClient();
    }
}

