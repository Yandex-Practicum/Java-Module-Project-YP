
public class Calculator {
    FormatRubles rub = new FormatRubles();
    float bill = 0.00f;

    //СУММА
    float sum(float y) {
        bill = bill + y;
        String billFormat = "СУММА: %.2f %s";
        System.out.println(String.format(billFormat, bill, rub.Rubles(bill)));
        return bill;
    }

    //ДЕЛЕНИЕ
    void calculate(float sum, int numberOfPeople) {
        float result = (float) sum / numberOfPeople;
        String resultFormat = "Каждый из %d людей - заплатит %.2f %s";
        String resultOutcome = String.format(resultFormat, numberOfPeople, result, rub.Rubles(result));
        System.out.println(resultOutcome);
    }
}
