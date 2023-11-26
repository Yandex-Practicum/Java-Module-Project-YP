import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int persons = countPersons();
        calculator();
        double part = Goods.sum / persons;
        System.out.println("Добавленные товары:" + Goods.names + "\n");
        System.out.println("Сумма товаров " + String.format("%.2f", Goods.sum) + " " + howToWriteRubles(Goods.sum));
        System.out.println("Каждый должен заплатить " + String.format("%.2f", part) + " " + howToWriteRubles(part));
    }
    public static class Goods{ // Создаем класс со статическими переменными, хранящие сумму заказа и названия товаров
        String name;
        double price;
        static double sum = 0;
        static String names="";

        public Goods(String n, double p){
            price = p;
            name = n;
            sum += price;
            names += "\n" + name;
        }
    }
    public static int countPersons() { //метод для подсчета числа посетителей
        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько человек нужно разделить счет?");
        int persons = 0;
        while (persons <= 1) {
            persons = scanner.nextInt();
            if (persons > 1) {
                break;
            } else {
                System.out.println("Неверное значение, попробуйте еще раз!");
            }
        }
        return  persons;
    }
    public static void calculator(){ // метод для добавления товаров
        Scanner scanner = new Scanner(System.in);
        String check = "0";
        while (check.toLowerCase() != "завершить"){
            if(check.toLowerCase().equals("завершить")) break;
            else {
                String name;
                String price = "-1";
                while (Double.parseDouble(price) < 0) {
                    System.out.println("Введите название и цену товара(формат - название рубли.копейки)");
                    name = scanner.next();
                    price = scanner.next();
                    if (Double.parseDouble(price) > 0) {
                        Goods nnew = new Goods(name, Double.parseDouble(price));
                        break;
                    } else {
                        System.out.println("Неверный ввод! попробуйте еще раз");
                    }
                }
                System.out.println("Желаете продолжить? Для выхода введите 'завершить'");
                check = scanner.next();
            }
        }
    }

    public static String howToWriteRubles(double p){ //метод для определения падежа слова "рубль"
        int rubles = (int) (p % 10);
        String write = "";
        switch (rubles){
            case 1:
                write = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                write = "рубля";
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 0:
                write = "рублей";
        }
        return write;
    }
}



