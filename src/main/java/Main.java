import java.util.Scanner; //ипортируем сканер

public class Main {
    public static void main(String[] args) {

        Scanner guest = new Scanner(System.in);

        while (true){
            System.out.println("На какое количество человек делим счет?");
            int x = guest.nextInt();
            if (x > 1){
                System.out.println("Вы ввели правильно, делим счет на " + x);
                break;
            } else if (x == 1){
                System.out.println("На одного и счет не делиться.");
            } else {
                System.out.println("Это не корректное значение.");
            }
        }
    }
}

