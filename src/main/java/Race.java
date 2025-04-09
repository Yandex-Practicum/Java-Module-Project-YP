public class Race {
    String leaderName = "";
    int maxDistance = 0;
    int timeOfTheRace = 24;


    public void checkNewLeader(Car car) {
        int distance = car.speed * timeOfTheRace;
        if (distance > maxDistance) {
            maxDistance = distance;
            leaderName = car.name;
        }
    }


}
