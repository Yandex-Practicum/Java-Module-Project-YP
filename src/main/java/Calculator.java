import java.util.Scanner;

public class Calculator {
    public static String spisok = "";

    public static void calculator(String tovar, int skolkoLudei) {
        float itogo = 0.00f;
        float itogoSKazhdogo = 0.00f;
        String raschet = "";
        String okonchanie = "";

        while (true) {
            System.out.println("Хотите добавить товар?");
            System.out.println("введите название товара ( если товаров более нет, то введите  *Завершить*)");
            Scanner scanner = new Scanner(System.in);
            String nazvanieTovara = scanner.nextLine();
            if (nazvanieTovara.equalsIgnoreCase("завершить")) {
                itogoSKazhdogo = itogo / (float) skolkoLudei;
                raschet = String.format("%.2f", itogoSKazhdogo);
                okonchanie = Rublei.rublei(itogoSKazhdogo);
                System.out.println("общий список: \n" + spisok);
                System.out.println("итого с каждого: " + raschet + " рубл" + okonchanie);
                return;
            } else {
                while (true) {
                    System.out.println("введите стоимость в формате *рубли.копейки*");
                    try {
                        float cena = scanner.nextFloat();
                            itogo = itogo + cena;
                            tovar = (nazvanieTovara + (" ") + cena);
                            spisok = (spisok + tovar + "\n");
                            System.out.println("итого: \n" + spisok);
                            break;

                    } catch (Exception e) {
                        System.out.println("Введено некорректное значение");
                        break;
                                           }
                }

            }
        }
    }
}



