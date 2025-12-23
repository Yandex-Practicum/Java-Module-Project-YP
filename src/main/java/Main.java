import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int amountOfCars = 3;

        Race race = new Race();
        System.out.println("Приветствуем тебя на гонке 24 часа Le Mans. Для того, чтобы узнать, кто победит, давай добавим машины в гонку");
        System.out.printf("Количество машин в этой гонке: %d%n", amountOfCars);

        for (int i=0; i < amountOfCars; i++) {
            System.out.printf("Добавим машину номер %d%n", i+1);
            race.addCarToRace(scanner);
        }
        race.whoIsWinner();
    }
}