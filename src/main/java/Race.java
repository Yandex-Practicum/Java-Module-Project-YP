import java.util.List;
public class Race {
    private final List<Car> cars;
    public Race(List<Car> cars) {
            this.cars = cars;
        }

        public Car determineWinner() {
            Car winner = null;
            int maxDistance = 0;

            for (Car car : cars) {
                int distance = car.getSpeed() * 24;
                if (distance > maxDistance) {
                    maxDistance = distance;
                    winner = car;
                }
            }

            return winner;
        }
    }