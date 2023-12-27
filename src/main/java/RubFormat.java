public class RubFormat {
    String rubFormat(double rub) {
        // Определение правильного окончания в слове "рубль"
        String rubFormat;
        int rubInt;
        rubInt=(int) rub;
        int number=rubInt%10;
        if (rubInt%100>=11&&rubInt%100<=14)
        {
            rubFormat = "рублей";
        }
        else
        {
            switch (number)
            {
                case 1:
                    rubFormat = "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    rubFormat = "рубля";
                    break;
                default:
                    rubFormat = "рублей";
            }
        }
        return  rubFormat;
    }
}
