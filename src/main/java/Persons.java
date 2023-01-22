import java.util.Scanner;

public class Persons {
    public int numberOfPersons(){
        int numberOfPersons = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("На какое количество человек необходимо разделить счёт?");
            if(scanner.hasNextInt()) {
                numberOfPersons = scanner.nextInt();
                if (numberOfPersons <= 1) {
                    System.out.println("В этом случае нет смысла ничего считать и делить! Попробуйте снова.");
                    scanner.nextLine();
                }
            } else {
                scanner.nextLine();
                System.out.println("Ошибка! Введенное значение не является числом. Попробуйте снова.");
            }
        } while(numberOfPersons<=1);
        return numberOfPersons;
    }
}

