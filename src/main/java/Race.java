import java.util.List;

public class Race {
    private static final int RACE_TIME = 24;

    public void calculateFastestCar(List<Car> cars) {
        Car fastestCar = null;
        for (Car car : cars) {
            if (fastestCar == null || car.speed() > fastestCar.speed()) {
                fastestCar = car;
            }
            System.out.printf("Машина \"%s\" проехала %d км за %d часа%n",
                    car.name(), car.speed() * RACE_TIME, RACE_TIME);
        }
        System.out.println("Самая быстрая машина: " + fastestCar.name());
    }
}
