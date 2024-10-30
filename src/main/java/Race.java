public class Race {
    private String leaderName = "";
    private int leaderDistance = 0;

    public void updateLeader(Car car) {
        int distance = car.getSpeed() * 24; // Расчет дистанции
        if (distance > leaderDistance) {
            leaderDistance = distance;
            leaderName = car.getName();
        }
    }

    public String getLeaderName() {
        return leaderName;
    }
}
