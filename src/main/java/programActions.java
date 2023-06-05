import java.util.Scanner; // импорт сканера
class Bill {
    String dishName;
    double dishPrice;
}
public class programActions extends helpLibrary

{

    public static int peopleQuantity() /* Ввод количества человек, на которое делится счет с проверками корректности ввода
    Метод возвращает колиечество человек, на которых делится счет */
    {

        int peopleQuant = checkIntInput("Введите количество человек, на которых надо поделить счет: ");
        boolean rightEntry = false;

        while (rightEntry == false)
        {
            if (peopleQuant < 1) {
                System.out.println("Мне кажется, что Вы несколько перебрали со спиртным. Людей не может быть меньше одного!");
                peopleQuant = checkIntInput("Введите правильное количество человек: ");
            } else if (peopleQuant == 1) {
                System.out.println("Рекомендую посмотреть на итоговую сумму счета и полностью ее оплатить, добавиви, по желанию, чаевые. ");
                peopleQuant = checkIntInput("Введите правильное количество человек: ");
            }
            else
            {
                rightEntry = true;
            }
        }
        return peopleQuant;
    }

    public static Bill addDish() /* Метод обеспечивает ввод позиций счета, состоящих из названия блюда и его цены, с проверкой корректности ввода.
     Завершение ввода осуществляется при вводе пользователем слова "Завершить" в любом регистре любой из букв слова */
    {

        Scanner scanner = new Scanner(System.in);
        Bill currentBill = new Bill();
        currentBill.dishName = "";
        currentBill.dishPrice = 0;
        String currentName = "";
        System.out.println("Если есть желание ввести еще одну позицию счета - вводите, если хотите закончить - введите слово \"Завершить\" для выхода: ");
        currentName = scanner.nextLine();
        do {
              double currentPrice = checkDoubleInput("Введите стоимость блюда: ");
              if (currentPrice < 0) /* Проверка на цену меньше нуля. Возможен вариант с меньше или равно, но нулевые позиции в ресторанах иногда встречаются,
               например - какие-то комплименты от заведения */
              {
                  System.out.println("Стоимость позиции меньше нуля, думаете ресторан собирается Вам доплатить?");
              }
             else
            {
              currentBill.dishPrice += currentPrice;
              currentBill.dishName += currentName + " - " + String.format("%.2f", currentPrice) + " " + roublesEnd(currentPrice) + "\n";
              System.out.println("Вы ввели товар "+ currentName + " стоиомстью " + String.format("%.2f", currentPrice) + " " + roublesEnd(currentPrice) + "\n");
              System.out.println("Если есть желание ввести еще одну позицию счета - вводите, если хотите закончить - введите слово \"Завершить\" для выхода: ");
              currentName = scanner.nextLine();
            }

            }
            while (checkEndInput(currentName, "завершить") == false);
        currentBill.dishName += "завершить" + "\n";

        return currentBill;
     }


    public static void showBill(Bill currentBill, int quantity) /* Метод выводит счет по пощзициям с ценами, общую суммму,
     и сумму, которую должен заплатить каждый участник застолья */
    {

        Scanner scanner = new Scanner(currentBill.dishName);
        String billPosition = scanner.nextLine();
        System.out.println("\n \n \n Добавленные товары: \n");
        while(!billPosition.equals("завершить"))
     {
         System.out.println(billPosition);
         billPosition = scanner.nextLine();

     }
        System.out.println("\n" + "Счет итого: " + String.format("%.2f", currentBill.dishPrice) + " " + roublesEnd(currentBill.dishPrice));
        System.out.println("Количество участников: " +  quantity + ". \nНа каждого участника получается: " + String.format("%.2f", (currentBill.dishPrice / quantity)) + " " + roublesEnd(currentBill.dishPrice / quantity));
    }





}
