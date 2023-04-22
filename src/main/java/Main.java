import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Часть 1. Количество поевших человек
        int numberFriends = 0;

            while (true) {
                //Укажите количество человек для разеления счёта
                while (true) { //проверяем ввод количества человек, пока не введут число
                System.out.println("Укажите количество человек для разделения счёта:");
                Scanner scanner = new Scanner(System.in);
                     String input = scanner.next();
                    //проверяем, что там такое внесли в количество друзей
                    InputCheckFriends ICF = new InputCheckFriends(input);
                    if (ICF.correct) {
                        numberFriends = ICF.IntValue;
                        break;
                    }
                }
                    //Проверяем количество человек
                if (numberFriends < 1) {
                    System.out.println("Это некорректное значение для подсчёта.");
                } else if (numberFriends == 1) {
                    System.out.println("За всё платите сами!!!");
                } else {
                    System.out.println("Количество гостей для разделения счёта = " + numberFriends);
                    break;
                }
            }

        //Часть 2. Ввод всего съеденного и выпитого
        float total = 0f;
        int countGoods = 0;
        float goodPrice = 0;
        String listGoods = "Добавленные товары: "; //переменная для хранения полного списка
            System.out.println("Добавьте блюда из списка и их цены.");
            System.out.println("Укажите наименование блюда:");
            while (true) { //просим вводит товары, пока не введут "завершить"
                Scanner scanner = new Scanner(System.in);
                String goodName = scanner.next();
                if (goodName.equalsIgnoreCase("Завершить")) {
                    System.out.println(listGoods + "\nна общую сумму " + String.format("%.2f", total) + " руб.");
                    break;
                }
                System.out.println("Укажите цену блюда:");
                while (true) {//повторяем ввод цены, пока цена не будет указана в правильном формате
                String input = scanner.next();
                InputCheck IC = new InputCheck(input); //проверяем в классе, что там указали в цене
                if (IC.correct) {
                        goodPrice = IC.FloatValue;
                        total = total + goodPrice;
                        break;
                    } else {
                        System.out.println("Укажите цену блюда в формате 'рубли.коп':");
                    }
                }
                    countGoods++;
                listGoods = listGoods + "\n" +countGoods + ". " + goodName + " за " + String.format("%.2f", goodPrice) + " руб.";
                //добавляем товары в список
                System.out.println("Блюдо успешно добавлено в список. Общая сумма счёта = " + String.format("%.2f", total) + " руб.");
                System.out.println("Если вы хотите добавить ещё позиции в список, укажите название следующего блюда, иначе напишите 'Завершить'");
            }
        //Часть 3. Подсчёт
        float PersonalPrice = total / numberFriends;
        RubFormatter RF = new RubFormatter(PersonalPrice);
        System.out.println ("Каждый должен заплатить по " + String.format("%.2f", PersonalPrice) + " " + RF.rubl + ".");
    }
}




