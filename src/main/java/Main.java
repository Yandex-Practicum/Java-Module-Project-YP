import java.util.Scanner;
import java.text.DecimalFormat;

    public class Main {
        public static void main(String[] args) {
            String nameUser = welcome();
            int numGuests = guest();
            double totalCost = costOfProducts();
            double finalCost = finalCost(totalCost);
            goodBye(nameUser);
            EasterEggs();
        }
        // Приветствие пользователя программой.
        public static String welcome() {
            System.out.println("Добрый день username, я бот-помощник ресторана Практикума! \nЯ могу расчитать для вас сумму за каждого гостя.");
            System.out.println("Как вас зовут?");
            Scanner scan = new Scanner(System.in);
            String nameUser = scan.next();
            System.out.println("Рад познакомиться, " + nameUser + "!");
            System.out.println("Приступаем к расчетам. Бип-Боп. ");
            return nameUser;
        }
        //Запуск запроса на колличество гостей.
        public static int guest() {
            Scanner scanner = new Scanner(System.in);
            Calculator calculator = new Calculator();
            int numGuests = calculator.qtyOfGuest();
            return numGuests;
        }
        // Запрос товара и его стоимости. - перенес в калькулятор
        public static double costOfProducts() {
            System.out.println("Начнем расчеты :)");
            Products products = new Products();
            products.listProd();
            double totalCost = products.getTotalCost();
            String suf1 = products.Suf1(totalCost);
            System.out.println("Общая сумма всех товаров: " + totalCost +" рубл"+suf1+".");
            return totalCost;
        }
        public static double finalCost(double totalCost) {
            System.out.println("\nПодождите операция выполняется:)\n \n \nРасчет завершен.\n  ");
            Calculator calculator = new Calculator();
            double finalCost = calculator.finalCost(totalCost);
            DecimalFormat df = new DecimalFormat("#.##");
            String formattedFinalCost = df.format(finalCost);
            String suf2 = calculator.Suf2(finalCost);
            System.out.println ("Итого каждый из гостей заплатит по: "+ formattedFinalCost+" рубл"+ suf2+".\n");
            return finalCost;
        }
        // Завершение программы.
        public static void goodBye(String nameUser){
            System.out.println("Я рад, что мне удалось вам помочь! \nХорошего дня "+nameUser+"! \nДо скорой встречи!!! :)");
        }
        // Пасхалочка)
        public static void EasterEggs(){
                System.out.println("       __|__\n *---o--(_)--o---*\n *Это типо самолетик:)");
        }
}
