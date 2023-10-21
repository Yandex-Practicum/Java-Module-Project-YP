import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Приветствие
        System.out.println("Рады приветствовать вас в консольном приложении \"Калькулятор счета\"!");

        //Получение входных данных о людях
        Scanner scanner = new Scanner(System.in);
        int quantityOfPersons;
        String nameOfProduct;
        double priceOfProduct;
        while (true) {
            System.out.print("Введите колличество человек: ");
            quantityOfPersons = scanner.nextInt();
             if (quantityOfPersons > 1) {
                break;
            } else {
                System.out.println("Ошибка,дальнейший расчет не имеет смысла.\n Повторите попытку ввода.");
            }
        }
        // Создаем корзину калькуляции покупок
        boolean flag = true;
        Basket basketCalc = new Basket();
        System.out.println("Ваша корзина готова к заполнению.");

        while(flag) {

            System.out.print("Введите наименование товара: ");
            nameOfProduct = scanner.next();

            System.out.println();
            while (true) {
                System.out.print("Введите цену товара (рубли, копейки): ");
                priceOfProduct = scanner.nextDouble();
                if (priceOfProduct > 0)
                    break;
            }
            //вызов метода добавления товара
            basketCalc.addProduct(nameOfProduct, priceOfProduct);

            while (true) {
                System.out.print("Если желаете добавить еще товар введите \"Да\"\nЕсли желаете завершить введите \"Завершить\".\n");
                String flagValue = scanner.next();
                if (flagValue.equalsIgnoreCase("Завершить")) {
                    flag = false;
                    break;
                } else if (flagValue.equalsIgnoreCase("да")) {
                    break;
                } else {
                    System.out.println("Неверный ввод");
                }
            }
        }

        //вывод результата
        
        System.out.println("Добавленные товары: ");
        for (String el:basketCalc.list) {
            System.out.println(el);
        }
        float lastSum = (float) basketCalc.sum / quantityOfPersons;
        String rub = basketCalc.convertRub(lastSum);

        System.out.printf("К оплате %.2f %s за человека.",lastSum, rub);
    }
}