public class Race {
    public static void ProcessLeader(Car[] cars) {
        String leaderName = "";
        int bestDistance = 0;
        int time = 24;

        for (Car car : cars) {
            int currentDistance = time * car.speed;
            if (currentDistance > bestDistance) {
                bestDistance = currentDistance;
                leaderName = car.name;
            }
        }

        System.out.printf("Самая быстрая машина - %s", leaderName);
    }
}
