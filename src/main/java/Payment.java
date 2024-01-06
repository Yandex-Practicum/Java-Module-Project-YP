import java.util.Scanner;

public class Payment {
    private static double pay;
    private static int clients;


    Payment( double a, int visitors) {
        pay = a;
        clients = visitors;
    }

    public static void paymentPerPerson() {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        double finalSum = pay/clients;
        double piss = Math.floor(finalSum);
        String sumFinal = String.format("%.2f",finalSum);
        String ruble;
        if (sumFinal.equals("1.00")) {
            ruble = "рубль";
        }
        else if (piss>= 2.00 && piss<5.00) {
            ruble = "рубля";
        }
        else {
            ruble = "рублей";
        }
        System.out.println("Расчет на человека: " + sumFinal + " " + ruble);

    }

}