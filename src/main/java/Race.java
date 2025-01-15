public class Race {
        private Car leader;

    public void determineLeader(Car[] cars) {
        double maxDistance = 0;

        for (Car car : cars) {
            double distance = car.speed() * 24;
            if (distance > maxDistance) {
                maxDistance = distance;
                leader = car;
            }
        }
    }
    public Car getLeader() {
        return leader;
    }
}
