import java.util.Scanner; // импорт сканера



public class Main extends programActions {

    public static void main(String[] args)
    {

       Scanner scanner = new Scanner(System.in);
       System.out.println("Введите количество человек: ");
       int peopleQuantity = scanner.nextInt();
       boolean normalInput = false;
       while (normalInput == false)
       {
          if (peopleQuantity < 1)
          {
             System.out.println("Протри глаза, пьянь! Людей не может быть меньше одного!");
              System.out.println("Введите количество человек: ");
              peopleQuantity = scanner.nextInt();
          }
          else if (peopleQuantity == 1)
          {
              System.out.println("А что тут считать? Один ел и пил?! Сам и плати!");
              System.out.println("Введите количество человек: ");
              peopleQuantity = scanner.nextInt();

          }
          else
          {
              normalInput = true;
          }
       }
       addDish(peopleQuantity);
     }
}