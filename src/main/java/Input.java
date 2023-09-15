import java.util.Scanner;

public class Input {

    public static int getIntInput(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int people = testPeople(scanner.nextLine());
        return people;
    }


    public static int testPeople(String str) {
        if (str != null && str.matches("[-+]?\\d*\\.?\\d+"))
            return Integer.parseInt(str);
        else return getIntInput("Введите корректное число");
    }


    public boolean StopOrNot(String message) {
        if (message.equalsIgnoreCase("Завершить"))
            return true;
        return false;
    }
}
