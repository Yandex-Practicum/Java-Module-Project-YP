import java.util.Scanner;

public class Meet {
    public static int companyInput() {
        System.out.println("Введите количество гостей");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Необходимо ввести число!");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
}

