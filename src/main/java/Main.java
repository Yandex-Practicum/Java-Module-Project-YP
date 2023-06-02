import java.util.Scanner; //ипортируем сканер

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int guests = scanner.nextInt();

        while (true){
            System.out.println("На какое количество человек делим счет?");
            if (guests > 1){
                System.out.println("Вы ввели правильно, делим счет на " + guests);
                break;
            } else if (guests == 1){
                System.out.println("На одного и счет не делиться.");
            } else {
                System.out.println("Это не корректное значение.");
            }
        }
        while(true) {
            System.out.println("Какой у вас товар?");
            nameProducts = scanner.nextLine();
            System.out.println("Напишите стоимость продукта: ");
            priceProducts = scanner.nextDouble();
            var p = new Products(nameProducts, priceProducts);
            System.out.println("Ваш товар: " + nameProducts + " ,его цена: " + priceProducts);
            break;
        }
    }
}

