import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int peopleNumber = peopleCounter.countPeople();

        System.out.println("Введите название блюда.");
        String foodName;
        double foodPrice;
        double priceSum = 0;
        String foodList = "Добавленные блюда: ";

        while (true) {
            Scanner foodScanner = new Scanner(System.in);
            foodName = foodScanner.nextLine();
            if (foodName.equalsIgnoreCase("Завершить")) {
                break;
            } else if (foodName.equals("")) {
                System.out.println("Вы ничего не ввели. Необходимо ввести название товара.");
                continue;
            }

            System.out.println("Введите стоимость блюда в формате ХХ,ХХ");

            while (true) {
                Scanner priceScanner = new Scanner(System.in);
                if (priceScanner.hasNextDouble()) {
                    foodPrice = priceScanner.nextDouble();
                    if (foodPrice < 0) {
                        System.out.println("Стоимость блюда не может быть меньше 0, введите верное значение");
                    } else {
                        System.out.println("Блюдо " + foodName + " за " + foodPrice + " руб. добавлено." + "\n" + "Добавьте еще одно блюдо или введите 'Завершить', чтобы узнать, сколько вы должны заплатить.");
                        break;
                    }
                } else {
                    System.out.println("Возможно, вы ошиблись. Введите стоимость блюда в формате ХХ,ХХ");
                    priceScanner.next();
                }
            }
            foodList = String.format("%s\n%s", foodList, foodName);
            priceSum += foodPrice;
        }

        double eachPay = priceSum / peopleNumber;
        String totalResult = "Общая сумма - %.2f";
        String personalResult = "Каждый должен заплатить по %.2f";
        String ruble;
        if ((int) eachPay % 100 >= 10 && (int) eachPay % 100 <= 20) {
            ruble = "рублей";
        } else {
            switch ((int) (eachPay % 10)) {
                case 1:
                    ruble = "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    ruble = "рубля";
                    break;
                default:
                    ruble = "рублей";

        System.out.println(foodList + "\n" + String.format(totalResult, priceSum) + " руб." + "\n" + String.format(personalResult, eachPay) + " " + ruble);

            }
        }
    }

}





