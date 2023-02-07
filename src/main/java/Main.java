import java.util.Scanner;

// dev branch for Y.Practicum

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        // Часть 1 - вводные параметры для счетчика (количество гостей)
        int guestCount;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nНа скольких человек необходимо разделить счет?");
            while (true) {
                if (scanner.hasNextInt()) {
                    guestCount = scanner.nextInt();
                    break;
                }
                else {
                    scanner.next();
                    System.out.println("Некорректный ввод, попробуйте еще раз");
                }
            }
            if (guestCount>1) break;
            else if (guestCount == 1) {
                System.out.println("Если вы один, то вам за все и платить!");
            }
            else {
                System.out.println("Некорректный ввод, попробуйте еще раз");
            }
        }


        // Часть 2 - создание чека и добавление товаров (в конструкторе)
        Calculator check = new Calculator();
        check.addGoods();

        // Часть 3 - вывод результатов
        check.print();

        double checkPerOne = check.getSum()/guestCount;
        Formatter rub = new Formatter();
        System.out.println("Вас было "+guestCount+", значит с каждого по " + String.format("%.2f", checkPerOne) + rub.format(checkPerOne));
        scanner.close();
    }
}

