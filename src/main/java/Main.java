/*------------------------Пишем консольное приложение №1--------------------------*/
//Никитин Евгений
//Яндекс практикум
/*--------------------------------------------------------------------------------*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        calculateIt();
    }
    public static void calculateIt (){
        int human=-1;
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
        if (sumWithoutReal==1) {
             formatTmp = "Каждый должен заплатить %.2f рубль";
        }
        else if (sumWithoutReal>1&&sumWithoutReal<5) {
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
                if(userInput==1||userInput<1){
                    System.out.println("Число людей должно быть больше одного");
                    continue;
                }
                else{
                    break;
                }
            }
        }
        return userInput;
    }
}
