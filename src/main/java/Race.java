public class Race {
    String leaderName = "";
    int leaderDistance = 0;

    public void determineWinner(Car car) {
        int distance = car.speed * 24;

        if (distance > leaderDistance) {
            leaderDistance = distance;
            leaderName = car.model;
        }
    }
}