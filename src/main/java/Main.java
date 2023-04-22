import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // счетчик
        int quantity;
        String quantityString;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            quantityString = scanner.nextLine();
            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity > 1) {
                    break;
                } else {
                    System.out.println("Ошибка ввода. Число людей должно быть больше одного.");
                }
            }
            catch (NumberFormatException nfe) {
                System.out.println("Ошибка ввода. Необходимо ввести целое число.");
            }
        }
        //калькулятор
        Calculator calc = new Calculator();
        calc.inputProduct();
        double part = Calculator.sum/quantity;
        Declension dec = new Declension();
        dec.decline(Math.floor(part));
        String partPrint = String.format ("%.2f", part);
        partPrint = partPrint.replace(',','.');
        System.out.println("Каждый человек должен заплатить " + partPrint + " " + Declension.rouble + ".");
        scanner.close();
    }
}

class Calculator {
    static double sum;
    int costRoubles, costCopecks;
    String list = "Добавленные товары:\n", printCostCopecks;
    void inputProduct() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Какой товар вы хотите заказать?");
            String product = scanner.nextLine();
            System.out.println("Какова стоимость товара '" + product + "'?\nСтоимость товара введите в формате\nРубли: 11\nКопейки: 45");
            while (true) {
                System.out.print("Рубли: ");
                String amountRoubles = scanner.nextLine();
                try {
                    costRoubles = Integer.parseInt(amountRoubles);
                    if (costRoubles>-1) {
                        break;
                    } else {
                        System.out.println("Ошибка ввода. Число рублей не может быть отрицательной величиной.");
                    }
                }
                catch (NumberFormatException nfe) {
                    System.out.println("Ошибка ввода. Необходимо ввести целое число.");
                }
            }
            while (true) {
                System.out.print("Копейки: ");
                String amountCopecks = scanner.nextLine();
                try {
                    costCopecks = Integer.parseInt(amountCopecks);
                    if (costCopecks>-1 && costCopecks<100) {
                        break;
                    } else {
                        System.out.println("Ошибка ввода. Число копеек должно быть в диапазоне от 0 до 99.");
                    }
                }
                catch (NumberFormatException nfe) {
                    System.out.println("Ошибка ввода. Необходимо ввести целое число.");
                }
            }
            Declension dec = new Declension();
            double dcostRoubles = costRoubles;
            dec.decline(dcostRoubles);
            if (costCopecks<10) {
                printCostCopecks = "0" + costCopecks;
            } else {
                printCostCopecks = "" + costCopecks;
            }
            System.out.println("Вы добавили товар " + product + " стоимостью " + costRoubles + "." + printCostCopecks + " " + Declension.rouble + " в список покупок.\nЕсли хотите закончить формирование списка товаров, введите 'Завершить'.\nЕсли хотите добавить товар, введите любой другой символ.");
            double dcostCopecks = costCopecks;
            sum = sum + costRoubles + (dcostCopecks / 100);
            list = list + product + " " + costRoubles + "." + printCostCopecks + " " + Declension.rouble + ".\n";
            String request = scanner.nextLine();
            if (request.equalsIgnoreCase("Завершить")){
                System.out.println(list);
                dec.decline(Math.floor(sum));
                String sumPrint = String.format ("%.2f", sum);
                sumPrint = sumPrint.replace(',','.');
                System.out.println("Общая сумма - " + sumPrint + " " + Declension.rouble + ".");
                break;
            }
        }
    }
}

class Declension {
    static String rouble;
    void decline (double a) {
        String cut = String.format ("%.2f", a);
        int c2 = cut.charAt(cut.length() - 4) - 48;
        if (c2 == 0 || c2 > 4) rouble = "рублей";
        if (c2 == 1) rouble = "рубль";
        if (c2 > 1 && c2 < 5) rouble = "рубля";
        if (a>=10) {
            int c1 = cut.charAt(cut.length() - 5) - 48;
            if (c1 == 1) {
                rouble = "рублей";
            }
        }
    }
}