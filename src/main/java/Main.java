// dev branch for Y.Practicum


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Привет мир!!!");
        System.out.println("На сколько человек желаете разделить счёт?");
        int numPerson = scanner.nextInt();

        while (numPerson <= 1) {
            System.out.println("Значение не подходит, введите значение больше 1");
            numPerson = scanner.nextInt();
        }

        Calculator calcPersonBill = new Calculator("", 0, 0);

        while (true) {
            System.out.println("Введите Название товара");
// Новый элемент добавляется в указанную позицию (в данном случае — в начало)
            //arrayList.add(0, "Watson");
            calcPersonBill.itemNameList = scanner.nextLine();
            System.out.println(calcPersonBill.itemNameList);

            System.out.println("Введите цену товара");
            calcPersonBill.price =+ scanner.nextFloat();

            System.out.println("Товар добавлен");
            System.out.println("Еще добавим?");
            //String keyWord = scanner.nextLine();
            if  ((scanner.nextLine()).equalsIgnoreCase("Завершить")) {
                break;
            } else calcPersonBill.numItems++;
        }
        System.out.println(calcPersonBill.itemNameList);
       System.out.println(calcPersonBill.price);

        }

    }

