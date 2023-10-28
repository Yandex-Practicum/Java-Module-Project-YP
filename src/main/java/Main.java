import java.util.ArrayList;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        double totalSum = 0;
        String answer;
        String answer1 = "Завершить";
        ArrayList<String> plates = new ArrayList<>();
        String plateName;
        double platePrice;
        String ruble = "";


        Scanner scanner = new Scanner(System.in);
        System.out.println("На скольких человек необходимо разделить счет?");
        int countOfPersons = scanner.nextInt();

        if (countOfPersons <= 1) {
            System.out.println("Вы ввели недопустимое число пользователей");
            System.out.println("Введите количество гостей еще раз, пожалуйста : ");

        } else {
            while (true) {
                System.out.println("Введите название товара: ");
                plateName = scanner.next();
                plates.add(plateName);
                System.out.println(plateName + " успешно добавлен к заказу.");
                System.out.println("Добавленные товары: " + plateName);
                System.out.println("Введите цену товара: ");
                platePrice = scanner.nextDouble();
                totalSum += platePrice;
                System.out.println("Хотите завершить заказ? ");
                answer = scanner.next();

                if (answer.equalsIgnoreCase(answer1))
                    break;

            }

            System.out.println("Добавленные товары: " + plates);
            if ((Math.floor(totalSum / countOfPersons) / 10) == 1) {
                ruble = "рубль";
            } else if ((Math.floor(totalSum / countOfPersons) / 10) == 2) {
                ruble = "рубля";
            } else if ((Math.floor(totalSum / countOfPersons) / 10) == 3) {
                ruble = "рубля";
            } else if ((Math.floor(totalSum / countOfPersons) / 10) == 4) {
                ruble = "рубля";
            } else if ((Math.floor(totalSum / countOfPersons) / 10) == 5) {
                ruble = "рублей";
            }  else if ((Math.floor(totalSum / countOfPersons) / 10) == 6) {
                ruble = "рублей";
            } else if ((Math.floor(totalSum / countOfPersons) / 10) == 7) {
                ruble = "рублей";
            } else if ((Math.floor(totalSum / countOfPersons) / 10) == 8) {
                ruble = "рублей";
            } else if ((Math.floor(totalSum / countOfPersons) / 10) == 9) {
                ruble = "рублей";
            } else if ((Math.floor(totalSum / countOfPersons) / 10) == 0) {
                ruble = "рублей";
            }
                System.out.printf("К оплате с человека: " + (Math.floor(totalSum / countOfPersons) + ruble));


            }


        }


    }




