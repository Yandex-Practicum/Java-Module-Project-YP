public class Race {
    String bestCarName;
    int bestDistance = 0;

    public void returnPath(SportCar car) {
        int distance = car.getSpeed() * 24;
        if (distance > bestDistance) {
            bestDistance = distance;
            bestCarName = car.name;
        }
    }

    public String getLeader() {
        return bestCarName;
    }
}
