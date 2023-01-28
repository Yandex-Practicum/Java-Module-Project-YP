public class Rub {

    public void endingOfTheRub (int amountPersons ,float totalAmount) {
        float amountForPersons;
        String templatePut = "Итого, с каждого человека по %.2f";
        amountForPersons = totalAmount / amountPersons;
        switch ((int)amountForPersons % 100){
            default:{
                System.out.println(String.format(templatePut, amountForPersons) + " рублей");
                break;
            } case (1) : {
                System.out.println(String.format(templatePut, amountForPersons) + " рубль");
                break;
            }
            case (11) : {
                System.out.println(String.format(templatePut, amountForPersons) + " рублей");
                break;
            }
            case (21) :
            case (31) :
            case (41) :
            case (51) :
            case (61) :
            case (71) :
            case (81) :
            case (91) :  {
                System.out.println(String.format(templatePut, amountForPersons) + " рубль");
                break;
            }
            case (2) :
            case (3) :
            case (4) : {
                System.out.println(String.format(templatePut, amountForPersons) + " рубля");
                break;
            }
        }
    }
}
