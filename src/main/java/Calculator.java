import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    ArrayList<Item> items = new ArrayList<>();

    public void addItems() {
        System.out.println("Введите название товара или напишите \"завершить\"");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        while(true){
            String itemName = scanner.nextLine();
            if(itemName.equalsIgnoreCase("завершить")){
                break;
            }
            System.out.println(String.format("Введите стоимость товара \"%s\"", itemName));
            try{
                String inputPrice = scanner.nextLine();
                if(inputPrice.equalsIgnoreCase("завершить")){
                    break;
                }
                Double itemPrice = Double.parseDouble(inputPrice.replace(",","."));
                if(itemPrice > 0){
                    items.add(new Item(itemName, itemPrice));
                    System.out.println(String.format("Товар %s успешно добавлен!\n", itemName));
                    System.out.println("Напишите название следующего товара или напишите \"завершить\"");
                } else {
                    System.out.println("Стоимость товара не может быть отрицательной или равна 0, напишите название товара или напишите \"завершить\"");
                }
            } catch (NumberFormatException e){
                System.out.println("Стоимость введена неверно, напишите название товара или напишите \"завершить\"");
            }
        }
        scanner.close();
    }
    public void calculate(int visitors){
        Double total = 0.0;
        for (Item item : items) {
            total += item.price;
        }
        Double separatedPrice = total/visitors;
        System.out.println(String.format("Каждый из %s должен заплатить %.2f %s", visitors, separatedPrice, new Formatter().getCase(separatedPrice)));
    }

    public void showItems() {
        System.out.println("Добавленные товары:");
        for (Item item: items) {
            System.out.println(String.format("- %s: %s %s", item.name, item.price, new Formatter().getCase(item.price)));
        }
    }
}
