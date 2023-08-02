
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
            while (true) {
                while (!in.hasNextFloat()) {
                    System.out.println("Ошибочка!");
                    System.out.println("Введите повторно");
                    in.next();
                }
                dish.priceOfDish = in.nextFloat();
                if (dish.priceOfDish > 0) break;
                else {
                    System.out.println("Введено некорректное значение! Попробуйте снова!");
                    while (!in.hasNextFloat()) {
                        System.out.println("Ошибочка!");
                        System.out.println("Введите повторно");
                        in.next();
                    }
                }
            }

            sumOfDishes = sumOfDishes + dish.priceOfDish;
            System.out.println("Блюдо успешно добавлено!\nВвести новое блюдо?");
            needToContinue = in.nextLine();
            needToContinue = in.nextLine();

            if (needToContinue.equalsIgnoreCase("завершить")) break;
        }
        System.out.println("Добавленные товары: \n" + namesDishes);
        String formatRubles = Formatter.toFormat(sumOfDishes/countOfPersons);
        System.out.println("Каждый должен заплатить: " + String.format("%.2f", sumOfDishes/countOfPersons) +  formatRubles);

    }
}
