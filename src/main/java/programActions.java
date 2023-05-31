import java.util.Scanner; // импорт сканера

public class programActions
{
    public static void addDish()
    {
        //System.out.println("addDish Работает");
        boolean stopInput = false;
        Scanner scanString = new Scanner(System.in);
        String[] dishNames = new String[];
        int i = 0;
        //for (int i=0; i < dishNames.length-1; i++)
        while (stopInput == false)
        {
            System.out.println("Введите название блюда или слово Завершить для выхода");
            dishNames[i] = scanString.nextLine();
            System.out.println(dishNames[i]);

            if (dishNames[i].equals("Завершить"))
            {
                stopInput = true;
                break;
            }

            i++;
            /*System.out.println("Введите цену блюда");
            double dishPrice = scanner.nextDouble(); */

        }
        System.out.println("OK");
    }

    public static void showDishes()
    {
        System.out.println("showDishes Работает");
    }



}
