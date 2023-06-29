import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {

        //Приветствие
        System.out.println("Добро пожаловать!");
        System.out.println("На сколько человек Вы желаете разделить счет?");
        Scanner sc = new Scanner(System.in);

        MainLoop: while(true) {

            try{
            int numberOfPeople = sc.nextInt();

            //Людей больше 1
            if (numberOfPeople > 1) {

                StringBuilder products = new StringBuilder("Добавленные товары: \n");

                //СЧЕТ ПЕРВЫЙ
                BillLoop: while(true) {

                    Product[] pr = new Product[50];
                    Calculator bl = new Calculator();
                    FormatRubles rub = new FormatRubles();
                    int x = 0;
                    //Не сделала бесконенчый цикл, потому что массив определила на 50 товаров, так что подумала это неважно
                    //Условие x==50 - ниже
                     while (x < 50) {

                        //ВВОД ДАННЫХ ТОВАРА (КЛАСС PRODUCT)
                        pr[x] = new Product();
                        System.out.println("Введите название товара:");
                        String name;
                        name = pr[x].insertName();
                        System.out.println("Введите его стоимость (Рубли,копейки)");
                        float price;
                        price = pr[x].insertPrice();

                        //ВЫВОД ТОВАРОВ
                         System.out.println("Вы успешно добавили: ");
                         String namesOfProducts = "%s стоимостью %.2f %s";
                         String formatProduct = String.format(namesOfProducts, name, price, rub.Rubles(price));
                         System.out.println(formatProduct);

                        //ВСЕ ТОВАРЫ ЦЕНА
                        float sum = bl.sum(price);
                        products.append(formatProduct +"\n");

                        // ДОБАВИТЬ ТОВАР ЕЩЕ РАЗ
                        System.out.println("Желаете продолжить добавление товаров? (Команда \"Завершить\"- для подсчета)");
                            String againProduct = sc.next();
                            String lowerCaseAgainProduct = againProduct.toLowerCase().trim();
                            if (lowerCaseAgainProduct.equals("завершить")) {
                                //СЧЕТ
                                //ВЫВОД ВСЕХ ТОВАРОВ
                                System.out.println(products);
                                //НА КАЖДОГО
                                bl.calculate(sum, numberOfPeople);
                                break BillLoop;
                            }
                            else {
                                    x = x + 1;
                            }

                            if (x == 50) {
                                System.out.println("Вы достигли максимума добавленных товаров");
                                System.out.println("Вот Ваш счет на 50 введенных товаров:");
                                break BillLoop;
                            }

                    }

                }

                //Разделить счет еще раз
                System.out.println("Желаете разделить счет еще раз?");
                while(true) {
                    String againBill = sc.next();
                    String lowerCaseAgainBill = againBill.toLowerCase().trim();
                    switch (lowerCaseAgainBill) {
                        case "да":
                        case "еще раз":
                        case "желаю":
                        case "хочу":
                            System.out.println("На сколько человек Вы желаете разделить счет?");
                            break;
                        case "нет":
                        case "не хочу":
                        case "не желаю":
                        case "завершить":
                        case "выйти":
                            System.out.println("Хорошего дня и до скорых встреч!");
                            break MainLoop;
                        default:
                            System.out.println("Не понимаю, введите еще раз: Да или Нет");
                            break;

                    }

                }
            }

            // 1 человек
            if (numberOfPeople == 1) {
                System.out.println("Нет смысла ничего считать, ведь вы всего один :с");
                System.out.println("Может, кто-то из друзей уже подошел, на сколько человек делить сейчас?");
            }
            // меньше 1 человека
            if (numberOfPeople < 1) {
                System.out.println("Никого нет :с");
                System.out.println("Может, кто-то из друзей уже подошел, на сколько человек делить сейчас?");

            }
            //Неправильный ввод
            }
            catch(InputMismatchException e){
                System.out.println("Вы ввели что-то не то :с Попробуйте еще раз");
                sc.nextLine();
            }
        }
    }
}