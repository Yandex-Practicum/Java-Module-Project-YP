import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Race {
    int hours = 24;

    public Auto getFastestCar(Auto auto1, Auto auto2, Auto auto3) {
        Auto[] cars = {auto1, auto2, auto3};
        HashMap<Auto, Integer> autoToDistanceMap = new HashMap<>();
        for (Auto car : cars) {
            autoToDistanceMap.put(car, getDistancePerDay(car));
        }
        Map.Entry<Auto, Integer> maxEntry = Collections.max(
                autoToDistanceMap.entrySet(),
                Map.Entry.comparingByValue()
        );
        return maxEntry.getKey();
    }

    private int getDistancePerDay(Auto auto) {
        return auto.speed * hours;
    }
}
