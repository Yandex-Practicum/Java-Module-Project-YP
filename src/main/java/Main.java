import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RubFormat rubFormat = new RubFormat();

        System.out.println("Введите количество людей, на которых нужно разделить счет:");


        int count = getIntFromTerminal();
        PeopleCout peopleCout = new PeopleCout();
        while (true) {
            if (peopleCout.setCount(count)) {
                break;
            } else { count = scanner.nextInt(); }
        }


        ProductManager manager = new ProductManager();
        while (true) {
            System.out.println("Введите название товара:");
            String foodName = scanner.next();

            System.out.println("Введите стоимость товара в формате рубли,копейки (например 10,45 или 11,40):");
            double foodPrice = getDoubleFromTerminal();

            Food food = new Food(foodName, foodPrice);
            manager.addFood(food);
            System.out.println("Вы ввели товар: " + foodName);
            System.out.println("Стоимость товара: " + rubFormat.rubFormat(foodPrice));

            System.out.println("Если не хотите добавлять товар: " + "'" + "Завершить " + "'" + "или любой символ, чтобы добавить еще");
            String yesOrNot = scanner.next().toLowerCase();
            if (yesOrNot.equals("завершить")) {
                manager.printFoods();
                break;
            }
        }
        Calculator calculator = new Calculator();
        double total = calculator.divider(manager.getListOfFood(), count);

        System.out.println("Каждый должен заплатить по: " + rubFormat.rubFormat(total));

    }
    private static int getIntFromTerminal() {
        int count;
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (Throwable t) {
            System.out.println("Некорректное значение. Пожалуйста, введитe число заново:");
            return getIntFromTerminal();

        }
    }
    private static  double getDoubleFromTerminal() {
        double foodPrice;
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextDouble();
        } catch (Throwable t) {
            System.out.println("Некорректное значение. Пожалуйста, введитe число заново:");
            return getDoubleFromTerminal();
        }
    }
}