public class Race {
    private static Car currentLeader;

    public static void defineLeaderFromParticipants(Car one, Car two, Car three) {
        if (one.getSpeed() >= two.getSpeed() && one.getSpeed() >= three.getSpeed()) {
            setLeader(one);
        } else if (two.getSpeed() >= one.getSpeed() && two.getSpeed() >= three.getSpeed()) {
            setLeader(two);
        } else {
            setLeader(three);
        }
    }

    private static void setLeader(Car leader) {
        currentLeader = leader;
    }

    public static Car getLeader() {
        return currentLeader;
    }
}
