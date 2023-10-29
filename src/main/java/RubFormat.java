public class RubFormat {
    static double rubFormat;
    static double rubFormatAdd;

    public static String RubFormat() {
        rubFormat = Math.floor(Calculator.rubPerPerson);

        int preLastNumber = (int) (rubFormat % 100 / 10);
        if (preLastNumber == 1) {
            return "рублей";
        }
        int lastNumber = (int) (rubFormat % 10);
            switch (lastNumber) {
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
    public static String RubFormatAdd() {
        rubFormatAdd = Math.floor(Calculator.totalPrice);

        int preLastNumber = (int) (rubFormatAdd % 100 / 10);
        if (preLastNumber == 1) {
            return "рублей";
        }
        int lastNumber = (int) (rubFormatAdd % 10);
        switch (lastNumber) {
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
