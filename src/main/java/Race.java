public class Race {

    private String leaderName = "";
    private int leaderDistance = 0;

    public void addNewCar(Car car) {
        int time = 24;
        int carDistance = time * car.speed;
        if (carDistance > leaderDistance) {
            leaderName = car.name;
            leaderDistance = carDistance;
        }
    }

    public String getLeaderName() {
        return leaderName;
    }
}
