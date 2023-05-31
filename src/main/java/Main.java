import java.util.Scanner; // импорт сканера



public class Main extends programActions {

    public static void main(String[] args)
    {
       boolean exitProgramm = false;
       Scanner scanner = new Scanner(System.in);
       System.out.print("Введите количество человек: ");
       int peopleQuantity = scanner.nextInt();

       addDish(); //Добавляем блюда из счета
       showDishes(); // выводим список блюд из счета

       System.out.println("Жрали " + peopleQuantity + ", а платите Вы" );

    }
}