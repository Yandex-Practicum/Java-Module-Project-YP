public class Result {

    /// поля
    private double rubValue; // итоговое значение вычислений
    private String rubFormat; // переменная для хранения правильной формы слова "рубль"

    // методы

    public void setRubValue(double rub) {
        rubValue = rub;
    }

    public void format() {
        double rubRounded = Math.floor(rubValue);
        if (rubValue >= 0 && rubValue <21) {
            if (rubValue==0) {
                rubFormat = "рублей";
            } else if (rubValue == 1) {
                rubFormat = "рубль";
            } else if (rubValue >= 2 && rubValue <5) {
                rubFormat = "рубля";
            } else if (rubValue >=5) {
                rubFormat = "рублей";
            }
        } else if (rubValue >= 21 && rubValue <100) {
            if (rubRounded%10 == 1) {
                rubFormat = "рубль";
            } else if (rubRounded%10 > 1 && rubRounded%10 <5) {
                rubFormat = "рубля";
            } else if (rubRounded%10 >=5 || rubRounded%10 == 0) {
                rubFormat = "рублей";
            }
        } else if (rubValue >=100) {
            if (rubRounded % 100 == 0) {
                rubFormat = "рублей";
            } else if (rubRounded % 100 == 1) {
                rubFormat = "рубль";
            } else if (rubRounded % 100 > 1 && rubRounded % 100 <5) {
                rubFormat = "рубля";
            } else if (rubRounded % 100 >=5 && rubRounded % 100 < 21) {
                rubFormat = "рублей";
            } else {
                if (rubRounded%10 == 1) {
                    rubFormat = "рубль";
                } else if (rubRounded%10 > 1 && rubRounded%10 <5) {
                    rubFormat = "рубля";
                } else if (rubRounded%10 >=5 || rubRounded%10 == 0) {
                    rubFormat = "рублей";
                }
            }

        }
    }

    public String getRubFormat() {
        return rubFormat;
    }
}