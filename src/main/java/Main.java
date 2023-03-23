// dev branch for Y.Practicum


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calcPersonBill = new Calculator("", 0, 0);
        checkAndFormat checker = new checkAndFormat();
        //System.out.println("Привет мир!!!");
        System.out.println("На сколько человек желаете разделить счёт?");

      // проверка  ввода на тип int
        int numPerson = checker.checkPersonVal();

        while (true) {
            System.out.println("Введите Название товара");

            calcPersonBill.itemNameList = calcPersonBill.itemNameList + "\n" + scanner.nextLine(); // добавляем имя в строку

            System.out.println("Введите цену товара");

            calcPersonBill.price = calcPersonBill.price + checker.checkItemVal(); //  Складываем полученые цены по мере ввода
            //scanner.nextLine(); // специфичный метод для завершения ввода...

            System.out.println("Товар добавлен");
            System.out.println("Еще добавим?");

            if  ((scanner.nextLine()).equalsIgnoreCase("Завершить")) { // проверка если пользователь завершил ввод
                break;
            } else calcPersonBill.numItems++;
        }
        float eachPrice = calcPersonBill.price/numPerson;

        System.out.print("Добавленные товары:");
        System.out.println(calcPersonBill.itemNameList);
        System.out.println(" ");

        //String totalSum = "Общая сумма товаров: %.2f";
        System.out.print("Общая сумма товаров: ");
        checker.moneyUnitformat(calcPersonBill.price); // печать суммы товаров правильным с окончанием рублей

        System.out.print("Сумма к оплате с человека: ");
        checker.moneyUnitformat(eachPrice); // печать Сумма к оплате с человека правильным с окончанием рублей

        /*
        Приветствую, Кирилл.
        Честно говоря не совсем понимаю как нормально использовать это метод проверки scanner.hasNextInt(),
        он либо проверяет либо валит программу...

        Собственно вот что пишут наставники:
        "А тебе не нужно проверять его на инт. Функция scanner.nextInt() может вернуть либо int,
        либо уронить программу) Поэтому дополнительной проверки уже после ввода не требуется."

        В итоге вроде всё выстроил, ошибок нет, но приходится иногда вводить число или текст по 2 раза, либо жать enter..
        Хз почему...
        Ощущение будто подтормаживает выполнение..

         */

        }
    }

