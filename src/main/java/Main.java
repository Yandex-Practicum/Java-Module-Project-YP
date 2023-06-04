import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int guests = 0;

        while (true){
            System.out.println("На какое количество человек делим счет?");
            guests = scanner.nextInt();
            if (guests > 1){
                System.out.println("Вы ввели правильно, делим счет на " + guests);
                break;
            } else if (guests == 1){
                System.out.println("На одного и счет не делиться.");
            } else {
                System.out.println("Это не корректное значение.");
            }
        }
        var sum = new Calculate(guests);
        while (true){
            String nameProducts;
            System.out.println("Какой товар выбрали?");
            nameProducts = scanner.nextLine();
            System.out.println("Напишити его стоимость");
            double priceProducts = scanner.nextInt();
            System.out.println("Товар добавлен!");
            System.out.println("Закажете еще?");

            String user = scanner.nextLine();
            if (user.equalsIgnoreCase("завершить")){
                break;
            }
            var prod = new Products(nameProducts, priceProducts);
            sum.add(prod);
            System.out.println(sum.catalog);
            System.out.println(getResult);
        }
    }
}

