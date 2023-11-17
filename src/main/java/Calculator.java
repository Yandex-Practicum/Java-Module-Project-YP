import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private int NumberOfGuests;
    private double totalCost;
    private Scanner scanner;
    ArrayList<String> itemNames = new ArrayList<String>();

    public Calculator() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        getNumberOfGuests();
        addItemsToCalculator();
        showResults();
    }

    private void getNumberOfGuests() {
        System.out.println("Введите количество гостей");
        while (true) {
            try {  NumberOfGuests = scanner.nextInt();
                if (NumberOfGuests == 1) {
                    System.out.println("Некорректное количество гостей");
                } else if (NumberOfGuests < 1) {
                    System.out.println("Некорректное количество гостей");
                } else {
                    break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Некорректный ввод. Введите число");
                scanner.next();
            }
        }
    }

    private void addItemsToCalculator() {
        System.out.println("Добавление товаров для подсчета. Введите 'Завершить' что бы завершить процесс.");
        while (true) {
            System.out.println("Введите название товара:");
            String itemName = scanner.next();
            if (itemName.equalsIgnoreCase("Завершить")) {
                break;
            }
            System.out.println("Введите стоимость товара:");
            double itemCost = scanner.nextDouble();
            if (itemCost < 0) {
                System.out.println("Некорректный ввод.Стоимость не может быть отрицательной");
            } else{
                itemNames.add(itemName);
                totalCost += itemCost;
                System.out.println("Товар '" + itemName + "' успешно добавлен");
            }
        }
    }

    private void showResults() {
        System.out.println("Добавленые товары:");
        for (String name : itemNames){
            System.out.println(name);
        }
        System.out.println("Общая стоимость:" + totalCost);
        int costPerGuest = (int)(totalCost/NumberOfGuests);
        String currency = "рублей";
        if (costPerGuest % 10 == 1 && costPerGuest % 100 != 11){
            currency = "рубль";
        } else if (costPerGuest % 10 >= 2 && costPerGuest % 10 <= 4 && (costPerGuest % 100 < 10 || costPerGuest % 100 >= 20)){
            currency = "рубля";
        }
        System.out.println("Стоимость на каждого гостя: " + String.format("%.2f", totalCost / NumberOfGuests) + ""+ currency );
    }
}