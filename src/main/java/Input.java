import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);
    public int getIntInput(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int people = testPeople(scanner.nextLine());
        return people;
    }


    public int testPeople(String str) {
        if (str != null && str.matches("[-+]?\\d*\\d+") &&(Integer.parseInt(str) > 1))
            return Integer.parseInt(str);
        else return getIntInput("Введите целое число большее единицы:");
    }

    public boolean StopOrNot(String message) {
        if (message.equalsIgnoreCase("Завершить"))
            return true;
        return false;
    }
}
