import java.util.ArrayList;

public class Wheel {
    ArrayList<Car> racers = new ArrayList<>();

    public void checkWhoWinnerFrom() {
        Car winner;

        if (!(this.racers.isEmpty())) {
            winner = this.racers.get(0);

            for(Car challenger : racers) {
                if (CalculateDistance(challenger.speed) > CalculateDistance(winner.speed)) {
                    winner = challenger;
                }
            }
            System.out.println(String.format("%s оказалась самой быстрой машиной", winner.name));
        } else {
            System.out.println("Ошибка при расчете победителя");
        }


    }

    public static Integer CalculateDistance(Integer speed) {
        return speed * 24;
    }

}
