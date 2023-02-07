import java.util.ArrayList;
import java.util.Scanner;
public class Calculator {
    ArrayList<String> name = new ArrayList<>();
    ArrayList<Double> price = new ArrayList<>();
    int count;
    double sum;

    double getSum() {return sum;}

    void addGoods (){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Введите товар №"+(count+1)+" или \"Завершить\", чтобы завершить ввод:");
            String nameInput = scanner.nextLine();
            if (nameInput.equalsIgnoreCase("Завершить")) break;
            System.out.println("Сколько стоит " + nameInput + "? (формат ввода: \"0,00\"):");
            double priceInput;
            while (true) {
                if (scanner.hasNextDouble()) {
                    priceInput = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                }
                else {
                    System.out.println("Некорректный ввод, попробуйте еще раз");
                    scanner.nextLine();
                }
            }
            name.add(nameInput);
            price.add(priceInput);
            count++;
            sum += priceInput;
            System.out.println("Товар №"+count+" \"" + nameInput + "\" успешно добавлен!\n");
        }
        scanner.close();
    }


    void print() {
        System.out.println("Добавленные товары:");
        System.out.println("-----------------------------------------------");
        Formatter rub = new Formatter();
        for (int i = 0; i < count; i++) {
            System.out.println(String.format("%2d ",(i + 1)) + String.format(" |%-27s|",name.get(i)) + String.format("%7.2f", price.get(i)) + rub.format(price.get(i)));
        }
        System.out.println("-----------------------------------------------");
        System.out.println("ИТОГО:\t\t\t\t\t\t\t|" + String.format("%7.2f", sum) + rub.format(sum));
        System.out.println("-----------------------------------------------");
    }
}