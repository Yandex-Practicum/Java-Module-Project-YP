public class Race {
    private String leaderName;
    private int leaderDistance;

    public Race() {
        this.leaderName = "";
        this.leaderDistance = 0;
    }

    public void checkLeader(Car car) {
        int distance = car.calculateDistance();

        if (distance > leaderDistance) {
            leaderDistance = distance;
            leaderName = car.getName();
        }
    }

    public String getLeaderName() {
        return leaderName;
    }
}