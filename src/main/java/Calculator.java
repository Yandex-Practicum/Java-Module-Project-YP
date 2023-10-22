

public class Calculator {
    String names = "";
    int people;
    double valueResult;


    Calculator(int people) {
        this.people = people;
    }

    void addMember(Product product) {
        valueResult += product.productValue;
        names += product.productName + "\n";
    }

    public String Cost() {
        double sum = valueResult / people;
        var rubles = Math.floor(sum);
        var suffix = getSuffix(rubles);

        return String.format("%.2f", sum) + " рубл" + suffix;
    }
    public static String getSuffix(double rubles) {
        double numb1 = rubles % 100;
        double numb2 = rubles % 10;
        if (numb1 >= 11 && numb1 <= 14) {
            return "ей";
        } else if (numb2 == 1) {
            return "ь";
        } else if (numb2 == 2 || numb2 == 3 || numb2 == 4) {
            return "я";
        } else {
            return "ей";
        }
    }
}
