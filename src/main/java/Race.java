public class Race {
    String autoLeader = "";
    int leaderDist = 0;
    public void leaderNumber(Car car) {
        int distance = 24 * car.getSpeed();
        if (distance > leaderDist) {
            autoLeader = car.getName();
            leaderDist = distance;

        }
    }
    public String getLeaderName() {
        return autoLeader;
    }
    public int getLeaderDistance() {
        return leaderDist;
    }
}
