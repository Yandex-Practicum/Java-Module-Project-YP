public class Race {
    int distance = 0;
    Car theBestCar;

    public Car returnLeader(Car car) {

        if ((24 * car.speed) > distance) {
            distance = 24 * car.speed;
            theBestCar = car;
        }
        return theBestCar;
    }
}
