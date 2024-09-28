
public class RacingGame {
    private String leaderName;
    private int leaderDistance;

    public RacingGame() {
        this.leaderName = "";
        this.leaderDistance = 0;
    }

    public void setLeader(Car car) {
        int distance = 24 * car.getSpeed();
        if (distance > leaderDistance) {
            leaderName = car.getName();
            leaderDistance = distance;
        }
    }

    public String getLeaderName() {
        return leaderName;
    }
}