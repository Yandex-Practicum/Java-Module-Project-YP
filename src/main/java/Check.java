import static java.lang.Float.parseFloat;

import java.util.Scanner;
public class Check {
    Input input = new Input();
    StringBuilder check = new StringBuilder();
    Scanner scanner = new Scanner(System.in);
    Format format = new Format();

    public float getItem() {
        boolean point = true;
        float sum = 0.00f;
        String item;
        while (point){// Цикл на ввод товара и подсчет суммы чека
            System.out.println("Введите товар\n Если хотите завершить, веведите 'Завершить'.");
            item = scanner.nextLine();
            if (input.StopOrNot(item))//проверка на завершение ввода
                point = false;
            if (getPrice(item)== 0.00f)//проверка на правильность ввода цены
                System.out.println("Введите товар, стоимость которого больше нуля");
            else {
                sum += getPrice(item);//сумма чека
                check.append("\n" + item + " " +format.ruble(getPrice(item)));
            }
        }



        System.out.println("Добавленные товары:" + check);
        return sum;
    }
    public float getPrice(String item) {
        String strPrice;
        strPrice = item.replace(",",".");//Замена ',' на '.'
        strPrice = item.replaceAll("[^0-9?!\\.]","");//Выбор только стоимость
        float price = parseFloat(strPrice);//перевод строки в число
        if (price >0.00f)
            return price;
        else return 0.00f;
    }

}
