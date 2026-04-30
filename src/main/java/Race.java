public class Race {
    private String leaderName;
    private int leaderDistance;


    public Race() {
        this.leaderName = "";
        this.leaderDistance = 0;
    }

    public void determineLeader(Automobile car) {
        int carDistance = car.calculateDistance();

        if (carDistance > leaderDistance) {
            leaderDistance = carDistance;
            leaderName = car.getName();
        }
    }

    public String getLeaderName() {
        return leaderName;
    }
}