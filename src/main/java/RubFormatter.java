public class RubFormatter  {

    float PerPrice;
    String rubl;
    RubFormatter (float PersPrice) {
        PerPrice = PersPrice;
        int rubPrice;

             rubPrice = (int) PersPrice;
            int PriceEnd = rubPrice % 100; //Остаток от деления на 100 для учёта 11 - 20 рублей
            if (PriceEnd > 4 && PriceEnd < 21) {
                rubl = "рублей";
            } else {
                int PriceEndEnd = PriceEnd % 10; //Остаток от деления на 10 для остальных случаев
                if (PriceEndEnd == 1) {
                    rubl = "рубль";
                } else if (PriceEndEnd > 1 && PriceEndEnd < 5) {
                    rubl = "рубля";
                } else {
                    rubl = "рублей";
                }

        }
    }
}
