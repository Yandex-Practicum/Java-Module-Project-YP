// dev branch for Y.Practicum


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calcPersonBill = new Calculator("", 0, 0);
        //System.out.println("Привет мир!!!");
        System.out.println("На сколько человек желаете разделить счёт?");

        while (true) {  // проверка типа ввода
            if (!scanner.hasNextInt()) {
                System.out.println("Извините, но это явно не число. Перезапустите программу и попробуйте снова!");
                scanner.nextLine();}
            else break;
        }
        int numPerson = scanner.nextInt();
        scanner.nextLine();

        while (numPerson <= 1) {
            System.out.println("Значение не подходит, введите другое значение");
            numPerson = scanner.nextInt();
            scanner.nextLine();
        }

        while (true) {
            System.out.println("Введите Название товара");

            calcPersonBill.itemNameList = calcPersonBill.itemNameList + "\n" + scanner.nextLine(); // добавляем имя в строку

            System.out.println("Введите цену товара");
            calcPersonBill.price = calcPersonBill.price + scanner.nextFloat(); //  Складываем полученые цены по мере ввода
            scanner.nextLine(); // специфичный метод для завершения ввода...

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
        calcPersonBill.moneyUnitformat(calcPersonBill.price); // печать суммы товаров правильным с окончанием рублей

        System.out.print("Сумма к оплате с человека: ");
        calcPersonBill.moneyUnitformat(eachPrice); // печать Сумма к оплате с человека правильным с окончанием рублей

        }
    }

