import java.util.ArrayList;

public class Race {
   ArrayList <Car> cars = new ArrayList<>();
   String nameLeader = " ";
   int leaderDistance = 0;



   public void addCar(Car car){
      cars.add(car);
      determineLeader(car);
   }

   private void determineLeader(Car car) {
      int distance = car.distanceIn24Hours();
      if (distance > leaderDistance) {
         nameLeader = car.getName();
         leaderDistance = distance;
      }
   }
   public String getLeader() {
     return nameLeader; }



}
