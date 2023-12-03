import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Calculator.calculator();
        String formatText = "Добавленные товары:\n%sКаждый человек должен заплатить: %.2f %s\n";
        System.out.printf(formatText, Calculator.menuSum, FormatRub.rubAverage, FormatRub.formatRub());

    }
}
