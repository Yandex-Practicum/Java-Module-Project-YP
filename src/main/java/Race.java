public class Race {
    private String leaderName;
    private int leaderDistance;

    public Race() {
        this.leaderName = "";
        this.leaderDistance = 0;
    }
    public void updateLeader(Car car) {
        int carDistance = car.getSpeed() * 24;

        if (carDistance > leaderDistance) {
            leaderName = car.getName();
            leaderDistance = carDistance;
        }
    }

    public String getWinner() {
        return "Самая быстрая машина: " + leaderName;
    }
}
