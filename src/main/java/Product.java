import java.util.Scanner;
public class Product {

    double getDoubleInput(){
        String value = getProduct();
        while(value.trim().isEmpty()){
            System.out.println("Строка не должна быть пустой! Укажите значение больше нуля в формате рубли.копейки, например 10,45 или 11,40.");
            value=getProduct();
        }

        while(!isNumericDoub(value)){
            System.out.println("Это некорректное значение для подсчёта. Значение должно быть числом больше нуля в формате рубли.копейки, например 10,45 или 11,40.");
            value=getProduct();
        }

        return Double.parseDouble(value);
    }

    String getProduct(){
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    String getRuble(double value){
        int valueInt = (int) value;
        if(valueInt%10==1&&valueInt%100!=11){
            return "рубль";
        }else if((valueInt%10==2||valueInt%10==3||valueInt%10==4)&&!(valueInt%100==12||valueInt%100==13||valueInt%100==14)){
            return "рубля";
        }
        return "рублей";
    }

    int getIntInput(){
        String people = getProduct();
        while(people.trim().isEmpty()){
            System.out.println("Строка не должна быть пустой! Значение должно быть числом больше одного.");
            people=getProduct();
        }

        while(!isNumeric(people)){
            System.out.println("Это некорректное значение для подсчёта. Значение должно быть числом больше одного.");
            people=getProduct();
        }

        return Integer.parseInt(people);
    }

    boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    boolean isNumericDoub(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }


}
