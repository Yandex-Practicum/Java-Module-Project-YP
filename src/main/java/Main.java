import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int guests;
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
        var proc = new Calculate(guests);
        while (true) {
            String nameProducts;
            System.out.println("Какой у вас товар?");
            nameProducts = scanner.nextLine();
            System.out.println("Напишите стоимость продукта: ");
            double priceProducts = scanner.nextDouble();
            var prod = new Products(nameProducts, priceProducts);
            proc.list(prod);
            System.out.println("Товар успешно добавлен!\nМожет еще по одной;)");
            var input = scanner.nextLine();
            if (input.equalsIgnoreCase("завершить")) {
                break;
            }
        }
        System.out.println("Добавленные товары: ");
        System.out.println(proc.catalogProducts);
        System.out.println(proc.result());
    }
}
