public class Rub {

    public void endingOfTheRub (int amountPersons ,float totalAmount) {
        float amountForPersons;
        String templatePut = "Итого, с каждого человека по %.2f";
        amountForPersons = totalAmount / amountPersons;
        switch ((int)amountForPersons % 10){
            default:{
                System.out.println(String.format(templatePut, amountForPersons) + " рублей");
                break;
            } case (1) : {
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
