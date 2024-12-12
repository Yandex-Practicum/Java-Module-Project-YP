public class Race {
    private String leaderName;
    private int leaderDistance;

    public Race() {
        this.leaderName = "";
        this.leaderDistance = 0;
    }

    public void determineNewLeader(Auto auto) {
        int distance = 24 * auto.getSpeed();

        if (distance > leaderDistance) {
            leaderName = auto.getName();
            leaderDistance = distance;
        }
    }

    public String getLeaderName() {
        return leaderName;
    }
}