package modules;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Products;

public class Modules {
    final static Scanner scanner = new Scanner(System.in);

    /* Вводим количество человек/гостей (целое положительное число, больше 1)*/
    public static int getCountPeople() {
        int countPeople;
        do {
            System.out.print(" На сколько человек разделить счёт (должно быть целое число > 1) : \n");
            while (!scanner.hasNextInt()) {
                System.out.println("\n Ошибка. Введите целое число больше 1. \n");
                scanner.next();
            }
            countPeople = scanner.nextInt();
            if (countPeople < 2) {
                System.out.println("\n Ошибка. Введенное значение < 2 \n");
            }
        } while (countPeople <= 1);
        System.out.println("\n Значит делим счёт на " + countPeople + " ");
        return countPeople;
    }

    /* Создание списка товаров */
    public static ArrayList<Products> getAddProductsFromUser() {
        String name;
        double price;
        String command;
        ArrayList<Products> products = new ArrayList<>();// для записи результата
        /* Команда для входа в цикл по заполнению списка товаров */
        System.out.println("\n Конструктор списка товаров. \n " +
                " Для добавления товара введите команду \"Добавить\" \n " +
                " или \"Завершить\" для завершения добавления товаров : \n");
        command = scanner.next();
        /* Цикл заполнения списка товаров */
        while (!command.isEmpty()) {
            if (command.equalsIgnoreCase("Добавить")) {
                /* Наименование товара */
                System.out.println("\n Введите наименование товара (любое значение, кроме \" \"): \n");
                name = scanner.next();
                /* Цена товара */
                System.out.println("\n Введите цену товара (в консоли числа типа float, double вводим через запятую - 1,7; 2,7 и т.д.): \n");
                do {
                    while (!scanner.hasNextDouble()) {
                        System.out.println("\n Ошибка. Введите число >= 0 \n");
                        scanner.next();
                    }
                    price = scanner.nextDouble();
                    if (price <= 0.00f) {
                        System.out.println("\n Ошибка. Введенное значение <= 0 \n");
                    }
                } while (price <= 0.00f);
                /* Добавление товара в список и вывод добавленного элемента на консоль */
                Products product = new Products(name, price);//, count
                products.add(product);
                System.out.printf("\n Товар : \n Название = %s \n Цена = %.2f \n\n Товар добавлен успешно ! \n", name, price);
                System.out.println("\n Хотите ли добавить еще один товар ? ");
                /* Запрос команды для взаимодействия с циклом заполнения списка товаров */
                System.out.println("\n Конструктор списка товаров. \n " +
                        " Для добавления товара введите команду \"Добавить\" \n " +
                        " или \"Завершить\" для завершения добавления товаров : \n");
                command = scanner.next();
                /* Завершение работы с циклом заполнения списка товаров */
            } else if (command.equalsIgnoreCase("Завершить")) {
                break;
                /* Введена не корректная команда */
            } else {
                System.out.println("\n Вы ввели \" " + command + " \" ничего не происходит. \n" +
                        " Введите команду \"Добавить\" или \"Завершить\" : \n");
                command = scanner.next();
            }
        }
        /* Выход из цикла и отправление возвращаемого значения в Main*/
        return products;
    }

    /* Распаковка результата */
    public static void makeResult(ArrayList<Products> products, int countPeople) {
        /* Вывод списка товаров и подсчет общей стоимости */
        double sumPriceProducts = 0;
        System.out.println("\n СПИСОК ДОБАВЛЕННЫХ ТОВАРОВ : ");
        for (Products prod : products) {
            sumPriceProducts = sumPriceProducts + prod.getPrice();
            String[] wordsCost = choiceForCost(prod.getPrice());
            String[] numCost = createPartNum(prod.getPrice());
            System.out.printf("\n Добавленный товар : \n Название : %s;    Цена : %s %s %s %s \n", prod.getName(), numCost[0], wordsCost[0], numCost[1], wordsCost[1]);
        }
        /* Вывод результата */
        String[] wordsCost = choiceForCost(sumPriceProducts/countPeople);
        String[] numCost = createPartNum(sumPriceProducts/countPeople);
        System.out.printf("\n\n Каждый из %d друзей должен заплатить по %s %s %s %s. \n\n\n\n",countPeople, numCost[0], wordsCost[0], numCost[1], wordsCost[1]);
    }

    /* Преобразователь Double чисел, разбиваем число и выбираем последние два символа целой и дробной части */
    public static String[] choiceForCost(double money){
        /* Разбиваем на целое и дробное */
        double moneyDouble = money - (int) money; // Дробная часть числа
        String doubleTwoNum = String.format("%.2f", moneyDouble);// Строка с округленной до двух чисел дробной частью
        int moneyInt = (int) money; // Целая часть числа, можно и через floor
        /* Последний и предпоследний символ целой части */
        String moneyIntStr = Integer.toString(moneyInt);
        int indexForIntMoney = moneyIntStr.length()-1;
        char lastElemStrMoneyInt = moneyIntStr.charAt(indexForIntMoney);
        int lastInt = Integer.parseInt(String.valueOf(lastElemStrMoneyInt));
        /* Предпоследний символ целой части */
        int indexPreLastInt = 0;
        int preLastInt = 0;
        if (moneyInt > 9) {
            indexPreLastInt = indexForIntMoney-1;
            char prelastElemStrMoneyInt = moneyIntStr.charAt(indexPreLastInt);
            preLastInt = Integer.parseInt(String.valueOf(prelastElemStrMoneyInt));
        }
        /* Последний и предпоследний символ после запятой */
        String[] twoNumRight = doubleTwoNum.split(".",3);
        String twoNumNotInt = twoNumRight[2];
        int indexForDoubleMoney = twoNumNotInt.length()-1;
        char lastElemStrMoneyDouble = twoNumNotInt.charAt(indexForDoubleMoney);
        int lastDoubleNum = Integer.parseInt(String.valueOf(lastElemStrMoneyDouble));
        int indexForDoubleMoneyPreLast = twoNumNotInt.length()-2;
        char preLastElemStrMoneyDouble = twoNumNotInt.charAt(indexForDoubleMoneyPreLast);
        int preLastDoubleNum = Integer.parseInt(String.valueOf(preLastElemStrMoneyDouble));

        String[] result = choiceWords(lastInt, preLastInt, lastDoubleNum, preLastDoubleNum);
        return result;
    }

    /* Подбираем слова с нужными окончаниями */
    public static String[] choiceWords(int lastInt, int preLastInt, int lastDoubleNum, int preLastDoubleNum){
        /* Массив слов */
        String[][] someWords = {{"Рубль","Рубля","Рублей"},{"Копейка","Копейки", "Копеек"}};
        /* Для записи результата */
        String rub = null;
        String kop = null;
        /* Для целой части Double числа */
        if ((preLastInt > 1)||(preLastInt == 0)) {
            switch (lastInt) {
                case 1:
                    rub = someWords[0][0];
                    break;
                case 2:
                case 3:
                case 4:
                    rub = someWords[0][1];
                    break;
                default:
                    rub = someWords[0][2];
                    break;

            }
        } else if (preLastInt == 1){
            switch (lastInt) {
                default:
                    rub = someWords[0][2];
                    break;

            }
        }
        /* Для чисел после запятой */
        if ((preLastDoubleNum > 1) || (preLastDoubleNum == 0)){
            switch (lastDoubleNum) {
                case 1:
                    kop = someWords[1][0];
                    break;
                case 2:
                case 3:
                case 4:
                    kop = someWords[1][1];
                    break;
                default:
                    kop = someWords[1][2];
                    break;

            }
        } else if (preLastDoubleNum == 1) {
            switch (lastDoubleNum) {
                default:
                    kop = someWords[1][2];
                    break;
            }
        }
        String[] result = {rub,kop};
        return result;
    }

    /* Разбиение числа на целую и дробную часть */
    public static String[] createPartNum(double money){
        String moneyIntStr = Integer.toString((int) money);
        double moneyDouble = money - (int) money; // Дробная часть числа
        String doubleTwoNum = String.format("%.2f", moneyDouble);// Строка с округленной до двух чисел дробной частью
        String[] twoNumRight = doubleTwoNum.split(".",3);
        String twoNumNotInt = twoNumRight[2];
        String[] result = {moneyIntStr, twoNumNotInt};
        return result;
    }
}
