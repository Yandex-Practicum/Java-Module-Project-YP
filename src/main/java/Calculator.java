import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public  List<Product> calculateBill (){
        Scanner console = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        String name;
        while (true){
            System.out.println("Введите наименование блюда");

            if (!console.hasNextLine()) {
                System.out.println("Необходимо ввести имя блюда!");
                continue;
            } else {
                name = console.next();
            }

                System.out.println("Введите цену ");
                if (!console.hasNextDouble()){
                    System.out.println("Введите цену в формате 00.00, пробуем заново");
                    continue;
                }
                double price = console.nextDouble();
                products.add(new Product(price, name));

            System.out.println("Завершить подсчет?");
            String answer = console.next();
            if (answer.equalsIgnoreCase("Завершить"))
                break;

        }

        return products;
    }





}
