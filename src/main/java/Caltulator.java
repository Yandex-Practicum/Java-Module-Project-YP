
import java.util.Scanner;
public class Caltulator {
    Scanner in = new Scanner(System.in);
    String namesDishes = "";
    Float sumOfDishes = 0.00f;

    Dish dish = new Dish();
    void getDish(int countOfPersons) {
        while (true) {
            String needToContinue;
            System.out.println("Введите название блюда");
            dish.nameOfDish = in.nextLine();
            namesDishes = namesDishes + dish.nameOfDish + "\n";
            System.out.println("Введите цену блюда");
            while (!in.hasNextFloat()) {
                System.out.println("Ошибочка!");
                System.out.println("Введите повторно");
                in.next();
            }
            dish.priceOfDish = in.nextFloat();
            sumOfDishes = sumOfDishes + dish.priceOfDish;
            System.out.println("Блюдо успешно добавлено!\nВвести новое блюдо?");
            needToContinue = in.nextLine();
            needToContinue = in.nextLine();

            if (needToContinue.equalsIgnoreCase("завершить")) break;
        }
        System.out.println("Добавленные товары: \n" + namesDishes);
        Formatter format = new Formatter();
        String formatRubles = format.toFormat(sumOfDishes/countOfPersons);
        System.out.println("Каждый должен заплатить: " + String.format("%.2f", sumOfDishes/countOfPersons) +  formatRubles);

    }
}
