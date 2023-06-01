
public class Main {
    public static void main(String[] args) {
        System.out.println("Привет! На какое количество человек делим счет?");
        Scanner guest = new Scanner(System.in);
        while (true){
            int x = guest.nexInt();

            if (x == 1){
                System.out.println("Должно быть больше одного человека");
                return;
            } else if (x < 1){
                System.out.println("Не может быть меньше одного человека");
            } else
                break;
        }
    }
}