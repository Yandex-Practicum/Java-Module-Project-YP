public class Formatter {
    Calculator calculator = new Calculator();

    public String padejRub() {
        double num = calculator.sumPriceProduct;
        calculator.sumPriceProduct = num % 100 / 10;
        if (calculator.sumPriceProduct == 1) {
            return "дней";
        }
        switch ((int) (num % 10)) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
