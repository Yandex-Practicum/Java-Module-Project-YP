public class Race {
    private Car[] cars;

    public Race(Car[] cars) {
        this.cars = cars;
    }

    public Car determineWinner() {
        Car winner = cars[0];

        for (Car car : cars) {
            if (car.calculateDistance(24) > winner.calculateDistance(24)) {
                winner = car;
            }
        }

        return winner;
    }
}