import java.text.DecimalFormat;
import java.util.Scanner;
public class Main
{
        public static void main(String[] args) {

            Product product = new Product();

            System.out.println("На скольких человек необходимо разделить счёт?");
              int people = product.getIntInput();

            while(people<=1){
                System.out.println("Это некорректное значение для подсчёта. Значение должно быть числом больше одного.");
                people = product.getIntInput();
            }


            String products = "Добавленные товары:\n";
            double result = 0.0;


            System.out.println("Укажите название товара");
            String prod2=product.getProduct();
            while(prod2.trim().isEmpty()){
                System.out.println("Строка не должна быть пустой! Укажите товар заново!");
                prod2=product.getProduct();
            }
            System.out.println("Укажите стоимость в формате рубли,копейки, например 10,45 или 11,40.");

            double doubleValue2 = product.getDoubleInput();
            while (doubleValue2 <= 0 ) {
                System.out.println("Это некорректное значение. Значение должно быть числом больше нуля в формате рубли.копейки, например 10,45 или 11,40.");
                doubleValue2 = product.getDoubleInput();
            }
            String ruble2=product.getRuble(doubleValue2);
            String formattedDouble2 = new DecimalFormat("#0.00").format(doubleValue2);

            result = result + doubleValue2;

            products = products+prod2+" "+formattedDouble2+" "+ruble2+"\n";


            while(true) {
                System.out.println("Хотите добавить ещё 1 товар? Укажите название товара или напишите \"завершить\" для подсчёта.");
                String prod=product.getProduct();

                if(prod.equalsIgnoreCase("завершить")){
                    break;
                }
                while(prod.trim().isEmpty()){
                    System.out.println("Строка не должна быть пустой! Укажите товар заново или напишите \"завершить\" для подсчёта.");
                    prod=product.getProduct();
                }
                System.out.println("Укажите стоимость в формате рубли,копейки, например 10,45 или 11,40.");

                double doubleValue = product.getDoubleInput();
                while (doubleValue <= 0) {
                    System.out.println("Это некорректное значение. Значение должно быть числом больше нуля в формате рубли.копейки, например 10,45 или 11,40.");
                    doubleValue = product.getDoubleInput();
                }
                String ruble=product.getRuble(doubleValue);
                String formattedDouble = new DecimalFormat("#0.00").format(doubleValue);

                products = products+prod+" "+formattedDouble+" "+ruble+"\n";

                result = result + doubleValue;
            }
            double finalRes=result/people;

            String formattedDoubleRes = new DecimalFormat("#0.00").format(result);
            String formDoubResPeople = new DecimalFormat("#0.00").format(finalRes);
            String rubleSum = product.getRuble(result);
            String rubleRes = product.getRuble(finalRes);

            System.out.println(products+"\n"+"Сумма счёта: "+formattedDoubleRes+" "+rubleSum+"\n"+"Количество человек: "+people+"\n"+"Сумма на человека: "+formDoubResPeople+" "+rubleRes);

        }

    }