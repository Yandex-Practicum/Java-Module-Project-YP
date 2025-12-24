import java.util.ArrayList;

public class Race {
    int raceResult(int speed){
        speed *= 24;
        return speed;
    }

    Car getLeader(ArrayList<Car> cars){
        Car leader = cars.get(0);
        int raceDistance = raceResult(leader.carSpeed);
        for (Car car : cars){
            int distance = raceResult(car.carSpeed);
            if (distance > raceDistance){
                raceDistance = distance;
                leader = car;
            }
        }
        return leader;
    }
}
