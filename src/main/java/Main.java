import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

                int guests;
                while (true) {
                    System.out.println("Введите число гостей (от 2-х человек): ");
                    guests = Integer.parseInt(myObj.nextLine());
                    if (guests <= 1) {
                        System.out.println("Некорректное число гостей. Попробуйте еще раз.");
                    } else {
                        break;
                    }
                }
                System.out.println("Введенное количество гостей: " + guests);

                double goods = 0;
                String userInput;

                do {
                    System.out.println("Введите название товара: ");
                    String itemName = myObj.nextLine();

                    System.out.println("Введите стоимость товара: ");
                    double itemPrice;
                    while (true) {
                        if (myObj.hasNextDouble()) {
                            itemPrice = myObj.nextDouble();
                            if (itemPrice <= 0) {
                                System.out.println("Неверная цена товара. Попробуйте еще раз.");
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("Некорректный ввод. Попробуйте еще раз.");
                            myObj.nextLine();
                        }
                    }

                    goods += itemPrice;

                    System.out.println("Добавлен товар " + itemName + ", " + itemPrice);
                    System.out.println("Хотите ли добавить еще товар? (Введите 'завершить' для окончания): ");
                    myObj.nextLine();
                    userInput = myObj.nextLine().toLowerCase();

                } while (!userInput.equals("завершить"));

                double result = goods / guests;
                System.out.printf("%.2f %s", result, rubleEnding(result));
            }

            public static String rubleEnding(double amount) {
                int rubles = (int) amount;

                if (rubles % 10 == 1 && rubles % 100 != 11) {
                    return "рубль";
                } else if (rubles % 10 >= 2 && rubles % 10 <= 4 && (rubles % 100 < 10 || rubles % 100 >= 20)) {
                    return "рубля";
                } else {
                    return "рублей";
                }
            }
        }