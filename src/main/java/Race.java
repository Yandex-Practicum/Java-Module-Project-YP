import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;

    public Race() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String whoLeader() {

        Car leader = cars.get(0);
        for (Car car : cars) {
            if (car.distance() > leader.distance()) {
                leader = car;
            }
        }

        return leader.carName();
    }
}
