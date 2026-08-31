public class Racing {
    private String leaderName;
    private int distance;

    public String getLeaderName() {
        return leaderName;
    }

    public Racing() {
    }

    public void calculateRaceLeader(Car car) {
        int carDistance = car.getSpeed() * 24;
        if (carDistance > this.distance) {
            this.leaderName = car.getName();
            this.distance = carDistance;
        }
    }
}
