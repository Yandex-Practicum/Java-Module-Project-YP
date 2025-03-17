public class Race {
    private String leaderName = "";
    private int leaderDistance = 0;

    public void updateLeader(Car car) {
        int distance = car.calculateDistance(24);
        if (distance > leaderDistance) {
            leaderName = car.name;
            leaderDistance = distance;
        }
    }

    public String getLeader() {
        return leaderName;
    }
}
