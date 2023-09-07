import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
    String menu="";
	double summa=0;
	int n;
	boolean a1;
	double price1=0;
	
        Prod p = new Prod(); 
        Scanner input = new Scanner(System.in);
          System.out.println("Привет! Я – калькулятор счета");
        while (true) {
            System.out.println("На скольких человек необходимо разделить счет?");
            String str = input.next();
             n = 0;
            try {
                n = Integer.parseInt(str);
                 if (n==1) {
	        	    System.out.println("Ошибка, Вы ввели 1");
	            	} else {
	                	if (n<1) {
		                    	System.out.println("Вы ввели отрицательное число!");
		                    	}
		                    	else {
		                    	    if (n==0){
		                    	        System.out.println("Ошибка, Вы ввели 0");
		                    	    }else{
			                    	System.out.println("Спасибо!");
				                     break;
			                        }
                                 } 
                
                
            }
                
            } catch (NumberFormatException ne) {
                System.out.println("Ошибка, введите число");
            }
        }

        while (true) {
            System.out.println("Введите название блюда и нажмите Enter. Если ввод закончен, введите \"Завершить\"");
            
            p.name = input.next();
            if (p.name.equalsIgnoreCase("Завершить")) {
                break;
            }
            while (true) {
            System.out.println("Введите цену блюда");
            String str1 = input.next();
             try {
             price1 = Double.parseDouble(str1);
             if (price1<0){
                 System.out.println("Вы ввели отрицательное число!");
             }else{
                 break;
             }
               }catch (NumberFormatException ne) {
                System.out.println("Ошибка, введите число");
             } 
            }
           p.price = price1; 
             menu = menu + "\n" + p.name;
            summa = summa + p.price;
            System.out.println("Товар добавлен");
            System.out.println("Хотите ли добавить еще один товар?");
           
        }
        System.out.print("Добавленные товары: ");
        System.out.println(menu);
        summa = summa/n;
        System.out.print("Необходимо оплатить: ");
        int x = (int) summa%100/10;
        int y = (int) summa%10;
        System.out.printf("%.2f",summa);
        if (summa == 1||(y==1 && x!=1)){
            System.out.print(" рубль");
        }else{
            if ((y==2||y==3||y==4)&&x!=1){
                System.out.print(" рубля");
            }else{
                System.out.print(" рублей");
            }
        }
}
}
class Prod {
    String name = ""; // Название блюда
    double price = 0; // Цена блюда
}
