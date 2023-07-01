import java.util.Scanner;

public class Calculator {
     double Calculator() {

         boolean restart = true;
         String chek = " ", menu = " ", stop = "Завершить";
         double obshag = 0, many;
         System.out.print("Введите название товара: ");
         while (restart) {
             Scanner scanner = new Scanner(System.in);
             menu = scanner.next();
             System.out.print("Введите стоймость: ");
             if (menu.equalsIgnoreCase(stop)) {
                 restart = false;
             } else if (scanner.hasNextDouble()) {
                 many = scanner.nextDouble();
                 if (many >= 0) {
                     System.out.print("Продолжить Заказ(Введите название товара)/Завершить счёт(Введите завершить): ");
                     chek = chek + "\n" + String.format("%s - %.2f", menu, many);
                     obshag += many;
                 } else {
                     System.out.print("Скидок нету. Цена не должна быть меньше 0:\nВведите название товара: ");
                 }
             } else {
                 System.out.print("Цена товара не может быть символом!\nВведите название товара: ");
             }
         }
         System.out.println("\nДобавленные товары: ");
         System.out.println(chek);
         System.out.printf("Итого: %.2f", obshag);
         return obshag;

     }

}



