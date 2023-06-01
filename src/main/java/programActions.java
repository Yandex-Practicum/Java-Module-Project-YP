import java.util.Scanner; // импорт сканера

public class programActions
{
    public class Biil {

        String dishName;
        double dishPrice;

    }
    public static void addDish()
    {

        boolean stopInput = false;
        Scanner scanNames = new Scanner(System.in);
        Scanner scanPrices = new Scanner(System.in);
        String[] dishNames = new String[100];
        Double[] dishPrice = new Double[100];
        //int i = 0;
        for (int i = 0; i < dishNames.length; i++)

         {
            System.out.println("Введите название блюда или слово Завершить для выхода: ");
            dishNames[i] = scanNames.nextLine();
            System.out.println(dishNames[i]);

            System.out.println("Введите цену блюда: ");
            dishPrice[i] = scanPrices.nextDouble();
            System.out.println(dishPrice[i]);

          if (dishNames[i].equals("Завершить"))
            {
                break;
            }
        }
        scanNames.close();
        scanPrices.close();
        System.out.println("OK");
    }

    public static void showDishes()
    {
        System.out.println("showDishes Работает");
    }



}
