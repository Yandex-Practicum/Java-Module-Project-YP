import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static int calcKolvo(int peopleKol, Scanner scanner) { //метод для запроса количества людей
        while (true) {
            if (scanner.hasNextInt()){ //проверка на ввод букв
                peopleKol = scanner.nextInt();
                if (peopleKol>1){
                    break;
                } else if (peopleKol==1) {
                    System.out.println("Ошибка! Введите значение больше единицы!\nИначе зачем вам делить счёт, если Вы и так одни?)");
                } else {
                    System.out.println("Ошибка! Введите значение больше единицы!");
                }
            } else {
                System.out.println("Ошибка! Введите число больше единицы!");
                scanner.next();
            }

        }
        return peopleKol;
    }

    public static void main(String[] args) {
        float sum=0;
        Calc calc = new Calc();
        Scanner scanner = new Scanner(System.in);

        int kol=0;
        System.out.println("Здравствуйте!\nНа скольких человек необходимо разделить счёт?");
        kol=calcKolvo(kol,scanner);//Считаем людей
        System.out.println("Отлично! Начинаем составлять список!\nВведите сначала имя товара, а после его стоимость:");

        sum=calc.addProduct(sum, scanner, calc.productList);//Создание списка и присваивание итоговой суммы из метода

        System.out.println("Добавленные товары:");
        for (Product product : calc.productList) { //Вывод списка товаров
            String messageTemplate = "Название товара: %s. Цена товара: %.2f %s.";
            System.out.println(String.format(messageTemplate, product.name, product.price, Padesh.padesh(product.price)));

        } //вывод суммы
        float finalsum = sum/kol;
        String messageTemplate = "\n-----------\nОбщая сумма: %.2f %s.\nСумма на каждого: %.2f %s.";
        System.out.println(String.format(messageTemplate, sum, Padesh.padesh(sum), finalsum, Padesh.padesh(finalsum)));
    }
}