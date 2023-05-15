public class Calculator {
    private final int sumGuests;
    private double totalPrice;
    public String list = "";

    public Calculator(int sumGuests) {

        this.sumGuests = sumGuests;

    }

    public void add(Product p) {
        totalPrice += p.price;

        list += p.productName + "\n";
    }

    public String getResult() {
        var part = totalPrice / sumGuests;
        //Чтобы округлить дробное число только до двух чисел после запятой, можно использовать строковый шаблон: String.format("%.2f", double);.
        var r = String.format("%.2f", part);

        //Чтобы поставить правильное окончание, вы можете округлить дробное значение и вывести слово "рубль" в правильном падеже. Для округления дробного числа в меньшую сторону можно использовать метод floor() класса Math.
        var rub = Math.floor(part);

        var suffix = getSuffix(rub);

        return r + " рубл" + suffix;
    }

    public static String getSuffix(double rub) {
//        0,5 - 20 ей
//        1:ь
//        2,3,4я
        if (rub % 100 >= 11 && rub%100 <= 14){
            return "ей";
        }
        else if (rub % 10 == 1) {
            return "ь";
        } else if (rub % 10 == 2 || rub % 10 == 3 || rub % 10 == 4) {
            return "я";
        } else {
            return "ей";
        }

    }

}
