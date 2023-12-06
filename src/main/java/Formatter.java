import java.util.Scanner;

public class Formatter {
    public static void main(String[] args) {
    }
    public static String GetDeclinationRub(int num) {
        var penultimateDigit = num % 100 / 10;
        if (penultimateDigit == 1)
        {
            return "рублей.";
        }

        switch (num % 10)
        {
            case 1:
                return "рубль.";
            case 2:
            case 3:
            case 4:
                return "рубля.";
            default:
                return "рублей.";
        }
    }
    public static boolean checksForInput(String input) {
        boolean proverka = false;
        try {
            int people = Integer.parseInt(input);
            if (people == 1) {
                System.out.println("Количество людей должно быть больше одного. Повторите ввод.");
            } else if (people < 1) {
                System.out.println("Некорректное значение для подсчёта. Повторите ввод.");
            }else {
                proverka = true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректное значение для подсчёта. Повторите ввод.");
            proverka = false;
        }
        return proverka;
    }
    public static boolean checksForPrice(String input){
        boolean proverka = false;
        try {
            Double cost = Double.parseDouble(input);
            if (cost <= 0) {
                System.out.println("Некоректное значение, повторите ввод.");
            } else {
                proverka = true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректное значение. Повторите ввод.");
            proverka = false;
        }
        return proverka;
    }
}
