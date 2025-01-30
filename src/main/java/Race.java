class Race {
    String leadRace = "";
    int leadDistance = 0;
    int draw = 0;
    public void makeRace(Car newCar) {
        int time = 24;
        int distance = time * newCar.speed;
        if (distance == leadDistance) {
            draw = -1;
        }
        if (distance > leadDistance) {
            leadRace = newCar.brand;
            leadDistance = distance;
            draw = 0;
        }
    }
}