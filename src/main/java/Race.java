import java.util.ArrayList;

public class Race {
    String leaderCarName = "";
    int maxDist = 0;

    void addCarToRace(Car c){
        int newDist = 24*c.speed;
        if (newDist>maxDist){
            leaderCarName = c.brand;
            maxDist = newDist;
        }
    }

    String getWinner (){
        return leaderCarName;
    }

}