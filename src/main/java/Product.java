import java.util.Scanner;
public class Product {
    String productName;
    double price;
    String command;
    double totalAmount;
    String orderList="";
    int numberOfGuests;
    double finalScore;
    String rubles;
    Scanner scanner=new Scanner(System.in);
    void basicProgram() {
        while (true) {
                        if (scanner.hasNextInt()) {
                                                        numberOfGuests = Integer.parseInt(scanner.nextLine());

                if (numberOfGuests > 1){
                    showGroceryList();
                    break;
                } else {
                    System.out.println("Введено некорректное значение, попробуйте еще раз.");
                }
            } else {
                            System.out.println("Введено некорректное значение, попробуйте еще пару раз.");
                            scanner.nextLine();
                                                }
    }
    }
    void showGroceryList() {
        while (true) {
            System.out.println("Введите название товара");
                        productName = scanner.next();
            orderList = orderList + productName + "\n";
            System.out.println("Введите стоимость товара в формате:рубли.копейки.");
            inputOfGoodsCost();
            totalAmount = totalAmount + price;
            System.out.println("Товар успешно добавлен. Хотите ли вы добавить еще один товар?\n" + "Если да - введите любое слово или букву.\n" + "Если нет - введите команду: завершить");
            command = scanner.next();
            String complete = "завершить";
            if (command.equalsIgnoreCase(complete)) {
                System.out.println("Добавленные товары:" +"\n" + orderList);
                finalScore = totalAmount/numberOfGuests;
                performFormatting();
                System.out.println("Каждый человек должен заплатить - " + String.format("%.2f", finalScore) +" " + rubles+".");
                break;
            }
        }
    }
    void inputOfGoodsCost () {
        while (true) {
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                if (price > 0){
                    break;
                } else {
                    System.out.println("Введено некорректная стоимость товара, попробуйте еще 1 раз.");
                }
            } else {
                System.out.println("Введено некорректная стоимость товара, попробуйте еще раз.");
                scanner.next();
            }
        }
    }
    void performFormatting () {
        int numberRoundUp = (int) Math.floor(finalScore);

        switch (numberRoundUp%100) {
            case 11,12,13,14:
                rubles = "рублей";
                break;
            default:
                switch (numberRoundUp%10) {
                    case 1:
                        rubles = "рубль";
                        break;
                    case 2,3,4:
                        rubles = "рубля";;
                        break;
                    case 5,6,7,8,9,0:
                        rubles = "рублей";
                        break;
                }
        }
    }
}

