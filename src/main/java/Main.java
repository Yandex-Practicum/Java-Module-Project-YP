import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //TODO задание 1 пункт 1: спрашивать сколько человек делят счёт

        /* 1. После запуска программа должна спрашивать у пользователя,
        на скольких человек необходимо разделить счёт.*/
        System.out.println("Привет, на скольких людей мы хотим разделить счёт?");
        SplitTheBill bill = new SplitTheBill();
        bill.quantityQuestionaire(); //специальный опросник в классе SplitTheBill
        //System.out.println("Число пользователей "+bill.personsQuantity);
        System.out.println("=============");
        System.out.println("Начните вводить список позиций из счёта.\nДля прекращения введите <Завершить>");
        System.out.println("=============");
        int i = 0; // счётчик для количества добавленных позиций.
        boolean stopped = false;
        /*
        специальная переменная, чтобы выходить из цикла while через слово "Завершить" на любом этапе
        а также не создавать экземпляр товара в случае если
        пользователь введёт "Завершить" на этапе ввода цены товара.
        */
        while (!stopped) { //цикл перечисления товаров по порядку.
            //System.out.println("Увеличили счетчик на +1");
            i++; //переводим счётчик на одну позицию в плюс. перед запуском i=0
            while (!stopped) { // цикл ожидания ввода корректного названия товара
                System.out.println("Позиция счёта #" + i);
                System.out.println("Введите название позиции #"+i);
                Scanner scanner = new Scanner(System.in);
                String positionName = ""; //инициируем пустые позиции, иначе будет ошибка компилятора
                String positionPriceStr = "";
                /*
                Если цена или имя в конце цикла окажутся пустыми хотя бы у одной позиции
                мы не будем добавлять ее в ArrayList <FoodElement>
                Для этого делаем проверку через trim().isEmpty()

                До метода калькулятора мы не работаем с числами
                храним строки

                 */
                float positionPrice;
                positionName = scanner.next();
                positionName = positionName.toLowerCase();

                if (positionName.equals("завершить")) {
                    stopped = true;
                    break;
                } else if (isFloat(positionName)) {
                    System.out.println("Кажется вы ввели число вместо имени позиции, исправьте");
                    break;
                } else if (positionName.trim().isEmpty()) {
                    System.out.println("Кажется вы ввели пустое имя позиции, исправьте");
                    break;
                }
                while (!stopped) { //цикл ожидания ввода корректной стоимости товара
                    System.out.println("Введите стоимость позиции #" + i);
                    positionPriceStr = scanner.next();
                    positionPriceStr = positionPriceStr.toLowerCase();
                    if (positionPriceStr.equals("завершить")) {
                        stopped = true;
                        break;
                    } else if (!isFloat(positionPriceStr)) {
                        System.out.println("Кажется вы ввели НЕ число, попробуйте еще раз");
                    } else if (positionPriceStr.contains(".")) {
                        int decimalLen = positionPriceStr.length()-(positionPriceStr.indexOf(".")+1);
                        if (decimalLen>2) {
                            System.out.println("Кажется вы ввели более чем 2 знака после запятой, попробуйте ещё раз");
                        } else {
                            System.out.println("Благополучно распознали число в вводе");
                            break;
                        }
                    } else {
                        //positionPrice = Float.parseFloat(positionPriceStr);
                        System.out.println("Благополучно распознали число в вводе");
                        break;
                    }
                }
                if (!stopped && !(positionPriceStr.trim().isEmpty() || positionName.trim().isEmpty())) {
                    bill.billElementList.add(new FoodElement(i,positionName,positionPriceStr));
                    System.out.println("Благополучно записали элемент #"+i);
                    break;
                } else {
                    break;
                }
            }

        }
        System.out.println(bill.billElementList.toString());

        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        System.out.println("================");
        System.out.println(bill.CalculatorPerPerson());
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




