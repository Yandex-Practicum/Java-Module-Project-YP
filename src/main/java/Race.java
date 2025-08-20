public class Race {
    String winner = "";
    int winnerDistance = 0;

    public void checkWinner(Car car) {
        int distance = car.speed * 24;

        if (distance > winnerDistance) {
            winner = car.name;
            winnerDistance = distance;

        }
    }

    String getWinner() {
        return winner;
    }

}
