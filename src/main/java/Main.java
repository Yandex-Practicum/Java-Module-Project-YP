import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько персон разделить счет?"); //Количество людей

        while (true)  {
            if (!scanner.hasNextInt()) {
                System.out.println("Введите целое число.");
                scanner.next();
            }
            int people = scanner.nextInt();
            if (people == 1) {
                System.out.println("Хотите разделить свою еду?\nДобавьте больше людей!");
            }
            if (people < 1) {
                System.out.println("Неправильное количество!\nВведите положительное целое число!");
            }
            if (people > 1) {
                System.out.println("Давайте подсчитаем!");
                Double value = GroceryList.Product(scanner) / people;
                String result = String.format("%.2f", value);
                System.out.println("Сумма с человека: " + result + " " + Rubles.GetRubleAddition((int) Math.floor(value)));
                break;
            }
        }
    }
}