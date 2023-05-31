import java.util.Scanner; // импорт сканера
public class Main {

    public static void main(String[] args)
    {
       boolean exitProgramm = false;
       Scanner scanner = new Scanner(System.in);
       System.out.println("Введите количество человек");

       int peopleQuantity = scanner.nextInt();

       while (exitProgramm == false) {

        // System.out.println("Введите название блюда или слово Выход для выхода");
        //String dishName = scanner.nextLine();
          System.out.println("Введите цену блюда или 0 для выхода");
          double dishPrice = scanner.nextDouble();
           //System.out.println(dishName);
          if (dishPrice == 0)
          {
             // System.out.println(dishName);
              exitProgramm = true;
          }
        }
       System.out.println("Жрали " + peopleQuantity + ", а платите Вы" );

    }
}