public class Race {
    String leaderName = "";
    int leaderDistance =0;
    public void formula(Car car) {
        int carDistance = 24 * car.speed;
        if (carDistance > leaderDistance) {
            leaderDistance = carDistance;
            leaderName = car.name;
        }
    }
}
