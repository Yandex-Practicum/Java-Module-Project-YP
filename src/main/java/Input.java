import java.util.Scanner;
public class Input {
    Scanner scanner = new Scanner(System.in);
    public int getIntInput(String message){
        System.out.println(message);
        return scanner.nextInt();
    }

    public boolean StopOrNot(String message) {
        if (message.equalsIgnoreCase("Завершить"))
            return true;
        return false;
    }
}
