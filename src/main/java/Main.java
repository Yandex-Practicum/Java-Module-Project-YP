import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("На сколько человек необходимо разделить счёт ?");
        Scanner sc = new Scanner(System.in);
        int qPeople = sc.nextInt();
        Check check = new Check();

        while (qPeople <= 1) {
            System.out.println("Введите  количество человек (больше одного)");
            qPeople = sc.nextInt();
        }
        while (true) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Введите название товара: \n Для завершения добавления товаров введите: Завершить");
            String name = sc1.nextLine();
            if (name.equalsIgnoreCase("Завершить")) break;

            System.out.println("Введите цену товара в формате рубли,копейки , например 12,45:");
            double price = 0D;
            while (true) {
                Scanner sc2 = new Scanner(System.in);
                if (sc2.hasNextDouble()) {
                    double result = sc2.nextDouble();
                    if (result <= 1) {
                        System.out.println("Вы ввели неверный формат цены, либо она составляет менее 1 рубля, введите заново:");
                    }
                    else {
                        price = result;
                        break;
                    }
                }
                else {
                    System.out.println("Вы ввели неверный формат цены, либо она составляет менее 1 рубля введите заново:");
                }
            }
            Good good = new Good(name, price);
            check.addSum(good.getPrice());
            check.addGoodName(good.getName());
        }

        String result = "Вот Ваш чек: \n" + (String.format("%,.2f", check.sum)) + "\n" +
                "Счет разделен на " + qPeople + " человек\n" +
                "С каждого человека по " + (String.format("%,.2f", check.div(qPeople))) + " " + getPadej (check, qPeople);
        System.out.println(result);


    }
    public static String getPadej (Check check, int qPeople) {
        String result;
        Double sum = check.div(qPeople);
        int intResult = sum.intValue();
        String strResult = String.valueOf(intResult);
        if (strResult.endsWith("1")) {
            result = "рублю";
        } else if (strResult.endsWith("2") || strResult.endsWith("3") || strResult.endsWith("4")) {
            result = "рубля";
        } else {
            result = "рублей";
        }
        return result;
    }
    }








