public class Race {
    String carLeaderName;
    int distanceOfLeader;

    public Race() {
        this.carLeaderName = "";
        this.distanceOfLeader = 0;
    }

    public void leaderCalculations(Car carObject){
        int distance = 24 * carObject.speed;
        if (distance>distanceOfLeader){
            carLeaderName = carObject.name;
        }
    }
}
