public class Race {

    String currentLider;
    int currentMaxDistance;

    public Race(){

        currentLider = "";
        currentMaxDistance = 0;

    }

    public void whoIsTheLeader(Car cars){

        if (24 * cars.speed > currentMaxDistance){
            currentMaxDistance = 24 * cars.speed;
            currentLider = cars.name;
        }

    }
}
