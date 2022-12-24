import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /* 1. После запуска программа должна спрашивать у пользователя,
        на скольких человек необходимо разделить счёт.*/
        System.out.println("Привет, на скольких людей мы хотим разделить счёт?");
        SplitTheBill bill = new SplitTheBill();
        bill.quantityQuestionaire();
        System.out.println("Число пользователей "+bill.personsQuantity);
        System.out.println("=============");
        System.out.println("Начните вводить список позиций из счёта.\nДля прекращения введите <Завершить>");
        System.out.println("=============");
        int i = 0; // счётчик для количества добавленных позиций.

        while (true) {
            i++; //переводим счётчик на одну позицию в плюс
            while (true) { // цикл ожидания ввода корректного названия товара
                System.out.println("Позиция счёта #" + i);
                System.out.println("Введите название позиции #"+i);
                Scanner scanner = new Scanner(System.in);
                String positionName;
                float positionPrice;
                positionName = scanner.next();
                positionName = positionName.toLowerCase();
                boolean stopped = false;
                if (positionName.equals("завершить")) {
                    break;
                } else if (isFloat(positionName)) {
                    System.out.println("Кажется вы ввели число вместо имени позиции");
                    break;
                }
                while (true) { //цикл ожидания ввода корректной стоимости товара
                    System.out.println("Введите стоимость позиции #" + i);
                    String positionPriceStr;
                    positionPriceStr = scanner.next();
                    positionPriceStr = positionPriceStr.toLowerCase();
                    if (positionPriceStr.equals("завершить")) {
                        break;
                        stopped = true
                    } else if (!isFloat(positionPriceStr)) {
                        System.out.println("Кажется вы ввели НЕ число, попробуйте еще раз");
                        break;
                    } else {
                        positionPrice = Float.parseFloat(positionPriceStr);
                    }
                }
                if (stopped) {
                    break;
                }
            }
        }
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости

    }

    public static boolean isFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}




