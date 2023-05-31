import java.util.Scanner; // импорт сканера

public class programActions
{
    public static void addDish()
    {
        System.out.println("addDish Работает");
       boolean exitProgramm = false;
        Scanner scanner = new Scanner(System.in);
        while (exitProgramm == false) {
            System.out.println("Введите название блюда или слово Завершить для выхода");
            String dishName = scanner.nextLine();
            System.out.println("Введите цену блюда");
            double dishPrice = scanner.nextDouble();
            System.out.println(dishName);
            if (dishPrice == 0)
            {
                System.out.println(dishName);
                exitProgramm = true;
            }
        }
    }

    public static void showDishes()
    {
        System.out.println("showDishes Работает");
    }



}
