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

        Пункт задания После добавления товара нужно спрашивать у пользователя, хочет ли он добавить ещё один товар.
        считаю избыточным, так как мы сразу предупредили, что команда <Завершить> прекратит ввод.
        */
        while (!stopped) { //цикл перечисления товаров по порядку.
            //System.out.println("Увеличили счетчик на +1");
            i++; //переводим счётчик на одну позицию в плюс. перед запуском i=0
            while (!stopped) { // цикл ожидания ввода корректного названия товара
                System.out.println("Позиция счёта #" + i);
                System.out.println("Введите название позиции #" + i);
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
                    System.out.println("Введите стоимость позиции (руб.коп) #" + i);
                    positionPriceStr = scanner.next();
                    positionPriceStr = positionPriceStr.toLowerCase();
                    if (positionPriceStr.equals("завершить")) {
                        stopped = true;
                        break;
                    } else if ((!isFloat(positionPriceStr)) || positionPriceStr.contains("-")) {
                        System.out.println("Кажется вы ввели НЕ число или ОТРИЦАТЕЛЬНОЕ число, попробуйте еще раз");
                    } else if (positionPriceStr.contains(".")) {
                        int decimalLen = positionPriceStr.length() - (positionPriceStr.indexOf(".") + 1);
                        if (decimalLen > 2) {
                            /*
                            Запросите у пользователя название товара и его стоимость.
                            Стоимость должна быть в формате рубли.копейки,
                            например 10.45 или 11.40.

                            Проверяем правильно ли пользователь ввёл рубли.копейки,
                            нет ли третьего знака после запятой
                             */
                            System.out.println("Кажется вы ввели более чем 2 знака после запятой, попробуйте ещё раз");
                        } else {
                            System.out.println("Благополучно распознали число в вводе");
                            break;
                        }
                    } else {
                        //positionPrice = Float.parseFloat(positionPriceStr);
                        //System.out.println("Благополучно распознали число в вводе");
                        break;
                    }
                }
                if (!stopped && !(positionPriceStr.trim().isEmpty() || positionName.trim().isEmpty())) {
                    bill.billElementList.add(new FoodElement(i, positionName, positionPriceStr));
                    /*
                    После добавления товара в калькулятор нужно показать пользователю сообщение
                    об успешном добавлении товара.
                     */
                    System.out.println("Позиция #" + i + "Добавлена");
                    break;
                } else {
                    break;
                }
            }

        }
        System.out.println("================");
        System.out.println("Вот все добавленные товары:\n");
        System.out.println(bill.billElementList.toString());
        System.out.println("================");
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        //pricePrinter(bill.calculatorPerPerson());
    }

    public static boolean isFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void pricePrinter(float price) {
        // берём округление вниз (пол) и остаток от деления на 10 покажет последнюю часть числа
        // также делаем проверку деления на 100, так как 11,12,13,14 рублей дают исключение
        int integerPart = (int) Math.floor(price);
        int lastDigitInt = integerPart % 10;
        String messageTemplate = "Сумма, которую должен заплатить каждый участник счёта — %.2f %s";
        if ((integerPart % 100) >= 11 && (integerPart % 100) <= 14) {
            System.out.printf(messageTemplate, price, "рублей");
        } else {
            switch (lastDigitInt) {
                case 1:
                    System.out.printf(messageTemplate, price, "рубль");
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.printf(messageTemplate, price, "рубля");
                    break;
                default:
                    System.out.printf(messageTemplate, price, "рублей");
                    break;
            }
        }
    }
}




