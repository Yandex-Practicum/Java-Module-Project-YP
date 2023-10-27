import java.util.Scanner;

public class SkolkoLudei {
        public static void skolkoludei()
    {
        System.out.println("На сколько человек необходимо разделить счёт?");
        Scanner scanner = new Scanner(System.in);
        int skolkoLudei;
        String tovar = Tovar.tovar;
        while (true)

        { try
        {
            skolkoLudei=scanner.nextInt();
            if (skolkoLudei>1)
            {
                System.out.println("Ну-с ,приступим.");
                Calculator.calculator(tovar, skolkoLudei);
                break;
            }
            else
            {
                System.out.println("Введено некорректное значение, введите количество людей");
                scanner = new Scanner(System.in);
            }

        }

            catch (Exception e)

            {
                System.out.println("Введено некорректное значение, введите количество людей");
                scanner = new Scanner(System.in);
            }
        {

        }

            }

        }
    }

