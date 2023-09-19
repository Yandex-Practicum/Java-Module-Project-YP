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
        String price;
        System.out.println("Если хотите завершить, веведите 'Завершить'.");
        while (point){// Цикл на ввод товара и подсчет суммы чека
            System.out.println("Введите наименование товара");
            item = scanner.nextLine();
            if (input.StopOrNot(item))//проверка на завершение ввода
                break;
            System.out.println("Введите цену товара");
            price = scanner.nextLine();

            if (getPrice(price) == 0.0f)//проверка на правильность ввода цены
                System.out.println("Введите товар, стоимость которого больше нуля");
            else {
                sum += getPrice(price);//сумма чека

                check.append("\n" + item + " " + getPrice(price) + format.ruble(getPrice(price)));
            }
        }
        System.out.println("Добавленные товары:" + check);
        return sum;
    }
    public float getPrice(String item) {
        String strPrice;

        if (item.replaceAll("[^-]","").equals("-")) {
            return 0.0f;//отрицательная стоимость
        }

        if (!(item.replaceAll("[^a-zA-Zа-яА-Я]", "").equals(""))) {
            return 0.0f; //текст в цене
        }

        strPrice = item.replaceAll(",",".");//Замена ',' на '.';

        strPrice = strPrice.replaceAll("[^0-9?!\\.]","");//Выбор только стоимость

        if (strPrice.equals("")) return 0.0f;// нет цены
        else{
            float price = parseFloat(strPrice);//перевод строки в число
            if (price > 0.009f)
                return price;
            else return 0.0f;
        }
    }

}
