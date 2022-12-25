import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Counter j=new Counter();
        int i=j.count();
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости

        System.out.println("Заполняем список заказанных товаров. После ввода всех товаров наберите 'Завершить'");
        Scanner sc = new Scanner(System.in);
        String a=""; //сюда вводятся названия товаров
        String bill=""; //здесь записываем счет
        float b=0f; //сюда записываем цену
        float total=0f; //здесь считаем стоимость всего счета
        while (true) {
            System.out.println("Введите название товара.");
            a=sc.next();
            if (a.toLowerCase().equals("завершить")) {
                break;
            }
            System.out.println("Введите цену товара.");
            while (true) {
                sc = new Scanner(System.in);
                if (sc.hasNextFloat()) {
                    b=sc.nextFloat();
                    break;
                } else {
                    System.out.println("Введите цену в численном формате.");
                }
            }
            bill=bill + String.format("%s цена %.2f р\n",a,b);
            total=total+b;
            }



            float pricePersonal=total/(i); //здесь считаем цену для каждого человека
            System.out.println("Добавленные товары: \n");
            System.out.println(bill);

            String ruble="";
            int e=((int)(pricePersonal))%10; //сюда записываем последнюю цифру


            switch (e) {
            case (1):
                ruble="рубль";
                break;
            case (2):
                case (3):
                case (4):
                    ruble="рубля";
                break;
                default:
                ruble="рублей";
                break;

            }

            String itog="";


            itog=String.format("На каждого человека приходится %.2f %s",pricePersonal,ruble);

            System.out.println(itog);

        }








}















