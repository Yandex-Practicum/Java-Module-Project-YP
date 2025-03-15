
public class Race {
    static final int hours = 24;
    static StringBuilder leaderBuffer = new StringBuilder();
    static int maxDistance = 0;

    public static void identifyingTheLeader(String name, int speed) {

        int distance = speed * hours;
        if (distance > maxDistance) {
            maxDistance = distance;
            leaderBuffer.append(name);
        } else if (distance == maxDistance) {
            leaderBuffer.append(" и ").append(name);
        }
    }
}
