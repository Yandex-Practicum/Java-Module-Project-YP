import java.util.Scanner;

public class GetValues {
    int getIntInput(){
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNextInt()){
            System.out.println("Это некорректное значение для подсчёта. Значение должно быть числом больше одного.");
            scanner.nextLine();
        }

        return scanner.nextInt();
    }


}
