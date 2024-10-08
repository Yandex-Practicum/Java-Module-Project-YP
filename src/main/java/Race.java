public class Race {

    private String leader = "";

    private int distance = 0;

    public String getLeader() {
        return leader;
    }

    public void addRacer(String name, int speed) {
        int newDistance = speed * 24;
        if (distance < newDistance) {
            distance = newDistance;
            leader = name;
        }
    }
}
