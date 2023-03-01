import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько персон разделить счет?"); //Количество людей

        while (true) {
            int people = scanner.nextInt();
            if (people == 1) {
                System.out.println("Хотите разделить свою еду?\nДобавьте больше людей!");
            }
            if (people < 1) {
                System.out.println("Неправильное количество!\nДобавьте больше людей!");
            }
            if (people > 1) {
                System.out.println("Давайте подсчитаем!");
                Double value =(GroceryList.Product()/people);
                String result = String.format("%.2f",value);

                System.out.println("Сумма с человека: "+result+" "+Rubles.GetRubleAddition((int)Math.floor(value)));
                break;
            }
        }
    }
}
    class GroceryList {

        public static double Product() {

            double sum = 0.0;
            StringBuilder products = new StringBuilder(("Добавить блюда")); //Обьявить блюда

            while (true) {
                String name;
                Scanner nameProduct = new Scanner(System.in);
                System.out.println("Введите название блюда"); // Ввести название блюда
                name = nameProduct.nextLine();

                if (name.equalsIgnoreCase("Завершить")) { //Подсчет итога
                    System.out.println(products);
                    break;
                }

                double price;
                System.out.println("Введите стоимость блюда"); // Ввести стоимость
                price = nameProduct.nextDouble();

                if (price > 0) {
                    products.append("\n").append(name).append(" по цене ").append(price);
                    sum += price;
                    System.out.println("Блюдо добавлено");
                }

            }
            return sum;
        }
    }