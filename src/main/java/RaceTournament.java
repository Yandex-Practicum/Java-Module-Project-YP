import java.util.Iterator;
import java.util.Map;

public class RaceTournament {
    String winnerCarName;
    int winnerCarSpeed;

    public void startTournament(RaceCars cars) {
        for (Map.Entry<String, Integer> carSpec : cars.carsSpecs.entrySet()) {
            if (carSpec.getValue() > winnerCarSpeed) {
                winnerCarSpeed = carSpec.getValue();
                winnerCarName = carSpec.getKey();
            }
        }

        System.out.printf("Самая быстрая машина: '%s' со скоростью '%d'", winnerCarName, winnerCarSpeed);
    }
}


