public class Race {
    private String leaderName = "";
    private int leaderDist = 0;

    public void whoLeader(Car car) {
        int distance = 24 * car.getSpeed();
        if (distance > leaderDist) {
            leaderDist = distance;
            leaderName = car.getName();
        }
    }

    public String lName() {
        return leaderName;
    }
}