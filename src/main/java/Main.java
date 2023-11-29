import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int persons = countPersons();
        Goods.calculator();
        double part = Goods.sum / persons;
        System.out.println("Добавленные товары:" + Goods.names + "\n");
        System.out.println("Сумма товаров " + String.format("%.2f", Goods.sum) + " " + howToWriteRubles(Goods.sum));
        System.out.println("Каждый должен заплатить " + String.format("%.2f", part) + " " + howToWriteRubles(part));
    }

    public static int countPersons() { //метод для подсчета числа посетителей
        Scanner scanner = new Scanner(System.in);
        System.out.println("На сколько человек нужно разделить счет?");
        int persons = 0;
        while (persons <= 1) {
            while(!scanner.hasNextInt()){
                scanner.next();
                System.out.println("Что-то не так, попробуйте еще раз, но с цифрами!");
            }
            persons = scanner.nextInt();
            if (persons > 1) {
                break;
            } else {
                System.out.println("Неверное значение, попробуйте еще раз!");
            }
        }
        return  persons;
    }


    public static String howToWriteRubles(double p){ //метод для определения падежа слова "рубль"
        int rubles = (int) (p % 100);
        String write = "";

        if (rubles >= 11 && rubles <= 19){
            write = "рублей";
        } else {
            rubles %= 10;
        switch (rubles) {
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
        }
        return write;
    }
}