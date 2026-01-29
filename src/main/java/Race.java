public class Race {
    private String leaderName = "";
    private int leaderDistance = 0;

    public void determineLeader(Car car) {
        int distance = 24 * car.getSpeed();

        if (distance > leaderDistance) {
            leaderName = car.getName();
            leaderDistance = distance;
        }
    }

    public String getWinner() {
        return leaderName;
    }
}



