import java.util.Scanner;

public class PeopleNumber {
    static int sumOfPeople = 0;

    public static int sumOfPeople() {


        while (true) {
            //if (scannerPeople.hasNextInt()) {
            sumOfPeople = Main.scannerPeople.nextInt();

            if (sumOfPeople == 1) {
                System.out.println("На одного счет делить не будем");
            } else if (sumOfPeople > 1) {
                System.out.println("Давай приступим к расчетам");
                Product.Product();
                break;
            } else {
                System.out.println("С таким значением мы не разделим счет");
            }
        }
        return sumOfPeople;
    }
}
