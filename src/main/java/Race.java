public class Race {
    private String leaderName = "";
    private int bestDistance = 0;

    public void checkLeader(Car car) {
        int distance = 24 *car.getSpeed();
        if (distance > bestDistance) {
            leaderName = car.getName();
            bestDistance = distance;
        }
    }

    public String getLeaderName() {
        return leaderName;
    }
}
