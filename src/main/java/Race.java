public class Race {
    autoCar leader;
    public void checkLeader(autoCar car){
        if(leader == null || car.speedAuto > leader.speedAuto ){
            leader = car;
        }
    }
    public autoCar getLeader(){
        return leader;
    }
}
