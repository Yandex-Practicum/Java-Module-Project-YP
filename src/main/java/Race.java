import java.util.ArrayList;

public class Race {
    static ArrayList<Car> participants = new ArrayList<>();
    static final int hours = 24;
    static String leader;

    public static String identifyingTheLeader() {
        int maxDistance = 0;

        for (Car element : participants) {
            int distance = element.speed * hours;
            if (distance > maxDistance) {
                maxDistance = distance;
                leader = element.name;
            } else if (distance == maxDistance) {
                leader = leader.concat(" и ").concat(element.name);
            }
        }
        return leader;
    }

    public static void participantsArray(String name, int speed) {
        participants.add(new Car(name, speed));
    }
}
