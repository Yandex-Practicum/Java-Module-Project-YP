import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счет?");

        int people;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                people = scanner.nextInt();
                if (people > 1) {
                    break;
                } else if (people == 1) {
                    System.out.println("В этом случае нет смысла ничего считать и делить");
                } else if (people < 1) {
                    System.out.println("Это некорректное значение для подсчёта");
                }
            } else {
                System.out.println("Ошибка");
                scanner.reset();
            }
        }

        String name;
        float price;
        float totalPrice = 0;
        String allProducts ="";

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название товара");
            name = scanner.nextLine();
            scanner.reset();
            System.out.println("Введите стоимость товара");
            if (scanner.hasNextFloat()) {
                price = scanner.nextFloat();
                if (price <= 0) {
                    System.out.println("Oшибка");
                } else {
                    Scanner scan = new Scanner(System.in);
                    totalPrice = totalPrice + price;
                    allProducts = allProducts  + " " + name;
                    System.out.println("Товар успешно добавлен");
                    System.out.println("Хотите ли вы добавить еще один товар? Если нет, напишите \"Завершить\"");
                    String complete = scan.nextLine();
                    scan.reset();
                    if (complete.equalsIgnoreCase("Завершить")) {
                        System.out.println("Добавленные товары:" +allProducts);
                        String conclusion = "Нужно заплатить каждому: %.2f %s";
                        Ruble declination = new Ruble();
                        System.out.println(String.format(conclusion, totalPrice/people, declination.declination(totalPrice/people)));
                        break;
                    }
                }

            } else {
                System.out.println("Ошибка");
                scanner.reset();
            }

        }


    }
}

class Ruble {
     String declination(float i) { // totalPrice/people
            String form = "%.0f";
            String totalStringPrice = String.format(form, i);
            int lastNumber;
            if (totalStringPrice.length() == 1) {
                lastNumber = Integer.parseInt(totalStringPrice);
                if (lastNumber == 0) {
                    return "рублей";
                } else if (lastNumber == 1) {
                    return "рубль";
                } else if (lastNumber > 1 && lastNumber < 5) {
                    return "рубля";
                } else {
                    return "рублей";
                }
            } else if (totalStringPrice.length() > 1) {
                lastNumber = Integer.parseInt(totalStringPrice.substring(totalStringPrice.length() - 2));
                if (lastNumber < 21) {
                    return "рублей";
                } else {
                    lastNumber = lastNumber % 10;
                    if (lastNumber == 0) {
                        return "рублей";
                    } else if (lastNumber == 1) {
                        return "рубль";
                    } else if (lastNumber > 1 && lastNumber < 5){
                        return "рубля";
                    } else {
                        return "рублей";
                    }
                }
            }
            return "Ошибка";
        }
    }

