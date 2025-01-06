public class Race {
    private String currentLeaderName = "";
    private int currentLeaderDistance = 0;
    private static final int RACE_HOURS = 24;

    public void checkForNewLeader(Car car) {
        int distance = car.getSpeed() * RACE_HOURS;
        if (distance > currentLeaderDistance) {
            currentLeaderName = car.getName();
            currentLeaderDistance = distance;
        }
    }

    public String getWinner() {
        return currentLeaderName;
    }
}