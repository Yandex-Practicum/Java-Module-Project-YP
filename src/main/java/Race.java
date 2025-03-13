import java.util.ArrayList;
import java.util.Iterator;

public class Race {
    public static int countDistance(Car car){
        return car.getSpeed() * 24;
    }
    public static String findLeader(ArrayList<Car> cars){
        int maxDistance=0;
        String leaderCar=" ";
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if(countDistance(car)>maxDistance){
                maxDistance=countDistance(car);
                leaderCar= car.getName();
            }

        }
        return leaderCar;
    }
}
