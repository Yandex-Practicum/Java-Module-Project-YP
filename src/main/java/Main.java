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
      //  System.out.println("Введите количество позиций в счете: ");
       // int positionsQuantity = scanner.nextInt(); // Берем количество позиций в счете и умножаем на пять, для ситуаций с дублированием
        addDish(); //Добавляем блюда из счета и их цену в массив
       //showDishes(); // выводим список блюд из счета

       System.out.println("Жрали " + peopleQuantity + ", а платите Вы" );

    }
}