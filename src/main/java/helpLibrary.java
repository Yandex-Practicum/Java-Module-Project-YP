import java.util.Scanner; // импорт сканера

public class helpLibrary {

    public static String roublesEnd(double amountSum)
    /* Метод возвращает слово "рубль" с правильным окончанием, в зависимости от полседней цифры суммы  */
    {
        String roublesStr = Double.toString(amountSum);
         int indexDot = roublesStr.indexOf(".");
         if (roublesStr.substring(0, indexDot).length() == 1)
         {
            roublesStr = "0" +  roublesStr.substring(0, indexDot);
         }
         else
         {
            roublesStr = roublesStr.substring(indexDot - 2, indexDot);
        }

        int roubles = Integer.parseInt(roublesStr);
        String outRoubles = "ру";

        if (roubles >= 11 && roubles < 20) {
            outRoubles += "блей";
            return (outRoubles);
        } else {
            roublesStr = roublesStr.substring(1, 2);
            roubles = Integer.parseInt(roublesStr);
            switch (roubles) // Понимаю, что можно было сделать с if, но так, на мой взгляд, проще и нагляднее
            {
                case 0:
                    outRoubles += "блей";
                    break;
                case 1:
                    outRoubles += "бль";
                    break;
                case 2:
                    outRoubles += "бля";
                    break;
                case 3:
                    outRoubles += "бля";
                    break;
                case 4:
                    outRoubles += "бля";
                    break;
                case 5:
                    outRoubles += "блей";
                    break;
                case 6:
                    outRoubles += "блей";
                    break;
                case 7:
                    outRoubles += "блей";
                    break;
                case 8:
                    outRoubles += "блей";
                    break;
                case 9:
                    outRoubles += "блей";
                    break;

            }

            return outRoubles;
        }
    }

    public static boolean checkEndInput(String userInput, String sample)
    // Метод сверяет ввод пользователя (в любом регистре) с эталннной стррокой, если ввод совпадает с эталоном, выдается true, если нет - false
    {
        String result = userInput.toLowerCase();
        if (result.equals(sample)) {
            return true;
        } else {
            return false;
        }


    }

    public static int checkIntInput(String stringOut)
   /* Метод проверяет корректность ввода целого числа. В качестве араметра передается строка, которая выводится в качестве приглашения для ввода */
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(stringOut);


        while (!scanner.hasNextInt())
        {
           System.out.println("Неправильный формат ввода, попробуйте еще раз ");
           System.out.print(stringOut);
           scanner.next();
        }
        int result = scanner.nextInt();
        return result;
    }

    public static double checkDoubleInput(String stringOut)
    /* Метод проверяет корректность ввода числа Double. В качестве араметра передается строка, которая выводится в качестве приглашения для ввода */
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(stringOut);
        while (!scanner.hasNextDouble()) {
                System.out.println("Неправильный формат ввода, попробуйте еще раз ");
                System.out.print(stringOut);
                scanner.next();
            }
        double result = scanner.nextDouble();
        return result;
    }


}




