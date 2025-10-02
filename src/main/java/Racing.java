import java.util.ArrayList;
import java.util.HashMap;

public class Racing {
    String leader="";
    int distance;
    int topDistance=0;

    public void calculateLeader(ArrayList<Cars> carList){//1056  1584  512
        for (Cars car :carList){
            distance=car.speed *24;
            if (distance>topDistance){
                topDistance=distance;
                leader= car.name;
            }

        }
        System.out.printf("Самая быстрая машина: %s%n",leader);

    }

}
