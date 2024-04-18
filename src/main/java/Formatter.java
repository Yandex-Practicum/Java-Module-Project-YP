public class Formatter {
    public String getCase(Double number){
        // округляем число до целых
        double flooredNumber = Math.floor(number);
        // находим остаток от деления на 10 чтобы получить крайнюю цифру справа
        // по нему определяем падеж, единственное или множественное число
        int remainder = (int) flooredNumber % 100;
        if(remainder >= 11 && remainder <= 19){
            return "рублей";
        } else if(remainder % 10 == 1){
            return "рубль";
        } else if(remainder % 10 >=2 && remainder % 10 <= 4){
            return "рубля";
        } else return "рублей";
    }
}
