public class Race {
    String currentWinner = "";
    int currentDistance = 0;

    public void updateWinner(String newBrand, int newSpeed) {
        int newDistance = newSpeed * 24;

        if (newDistance > currentDistance) {
            currentWinner = newBrand;
            currentDistance = newDistance;
        }
    }

    public String getCurrentWinner() {
        return "Самая быстрая машина: " + currentWinner;
    }
}
