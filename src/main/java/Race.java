public class Race {


    String leaderName = "";
    int leaderSpeed = 0;

    public void checkLeader(Car car) {



        int distance = car.carSpeed * 24;

        if (distance >= leaderSpeed) {
            leaderSpeed = distance;
            leaderName = car.carName;

        }


    }
}