class Race{

    private Car[] cars;
    private Car leader;

    public Race(Car[] cars){
        this.cars = cars;
        selectLeader();
    }

    private void selectLeader(){
        leader = cars[0];
        for (int i = 1; i < cars.length; i++){
            if (cars[i].distance() > leader.distance()){
                leader = cars[i];
            }
        }
    }

    public Car getLeader(){
            return leader;
    }
}
