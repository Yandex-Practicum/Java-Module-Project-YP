public class Calculator {
    public String getRubleAddition(double num) {

        int preLastDigit = (int) ((num % 100) / 10);
        if (preLastDigit == 1) {
            return "рублей";
        } else {
            switch ((int) (num % 10)) {
                case 1:
                    return "рублю";
                case 2:
                case 3:
                case 4:
                    return "рубля";
                default:
                    return "рублей";
            }
        }
    }

    void calculate(double totalAmount, int numberOfPersons) {
        double payBill = totalAmount / numberOfPersons;
        String SumForOnePerson = "Каждый должен оплатить по:  %.2f";
        System.out.println(String.format(SumForOnePerson, payBill) + " " + getRubleAddition(payBill));
    }
}


