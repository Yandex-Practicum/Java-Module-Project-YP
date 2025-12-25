import java.util.ArrayList;

public class Race {

    int calculateDistance(int speed){
        return speed * 24;
    }

    Car getLeader(ArrayList<Car> cars){
        Car leader = cars.get(0);
        int leaderDistance = calculateDistance(leader.speed);

        for (Car car : cars){
            int distance = calculateDistance(car.speed);
            if (distance > leaderDistance){
                leaderDistance = distance;
                leader = car;
            }
        }
        return leader;
    }
}