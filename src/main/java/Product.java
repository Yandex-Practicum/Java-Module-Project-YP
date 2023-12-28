import java.util.Scanner;
public class Product {

    double getDoubleInput(){
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNextDouble()){
            System.out.println("Это некорректное значение для подсчёта. Значение должно быть числом в формате рубли.копейки, например 10.45 или 11.40.");
            scanner.nextLine();
        }

        return scanner.nextDouble();
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

}
