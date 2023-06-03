import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        calculateIt();
    }
    public static void calculateIt (){
        int human=0;
        while(human<=1){
            human=checkPeople ();
        }
        Calc clc = new Calc();
        clc.askAboutThings();
        System.out.println("Добавленные товары:");
        System.out.println(clc.nameOfThings);
        float delSum= (clc.sum/human);
        int sumWithoutReal =  (int)delSum;
        String formatTmp;
        if (sumWithoutReal%100>10&&sumWithoutReal%100<20){
             formatTmp = "Каждый должен заплатить %.2f рублей";
        }
        else if (sumWithoutReal%10==1) {
             formatTmp = "Каждый должен заплатить %.2f рубль";
        }
        else if (sumWithoutReal%10>1&&sumWithoutReal%10<5) {
             formatTmp = "Каждый должен заплатить %.2f рубля";
        }
        else {
             formatTmp = "Каждый должен заплатить %.2f рублей";
        }
        System.out.println(String.format(formatTmp,delSum));
    }
    public static int checkPeople (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("На скольких человек необходимо разделить счёт?");
        int userInput;
        while (true){
            if (!scanner.hasNextInt()) {
                System.out.println("Введите корректное количество людей в штуках");
                scanner.next();
            }
            else{
                userInput = scanner.nextInt();
                if(userInput<=1){
                    System.out.println("Число людей должно быть больше одного");
                }
                else{
                    break;
                }
            }
        }
        return userInput;
    }
}
