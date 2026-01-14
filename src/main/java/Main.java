import java.util.Scanner;

public class Main {
    private static final int AMOUNT_OF_CARS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        Race race = new Race();
        System.out.println("Приветствуем тебя на гонке 24 часа Le Mans. Для того, чтобы узнать, кто победит, давай добавим машины в гонку");
        System.out.printf("Количество машин в этой гонке: %d%n", AMOUNT_OF_CARS);

        for (int i=0; i < AMOUNT_OF_CARS; i++) {
            System.out.printf("Добавим машину номер %d%n", i+1);
            race.addCarToRace(scanner);
        }
        race.whoIsWinner();
    }
}