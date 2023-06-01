import java.util.Scanner; //ипортируем сканер

public class Main {
    public static void main(String[] args) {
        System.out.println("Привет! На какое количество человек делим счет?");
        Scanner guest = new Scanner(System.in);

        while (true){
            int x = guest.nextInt();
            if (x > 1){
                System.out.println("Вы ввели правильно");
                break;
            }
                System.out.println("Должно быть больше одного человека");

        }
    }
}