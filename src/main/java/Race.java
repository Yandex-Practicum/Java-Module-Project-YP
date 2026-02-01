public class Race {
    String lead;
    int distanceLead;

    public void controlLead(Car car){
        int distance = car.speed * 24;
        lead = car.name;
    }
}
