public class Race {
    String leaderName;
    int leaderDistanse;

    public Race() {
        this.leaderName = "";
        this.leaderDistanse = 0;
    }

    public void updateLeader(Car car) {
        int distanse = 24 * car.speed;
        if (distanse > leaderDistanse) {


            leaderName = car.name;
            leaderDistanse = distanse;
        }
    }

    public String getLeader() {

        return leaderName;
    }
}
