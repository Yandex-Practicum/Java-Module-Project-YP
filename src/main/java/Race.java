public class Race {
    String leader = "";
    int leaderDistance = 0;

    public void defineLeader(Car car) {
        int distance = 24 * car.speed;

        if (distance > leaderDistance) {
            leaderDistance = distance;
            leader = car.name;
        }
    }
}
