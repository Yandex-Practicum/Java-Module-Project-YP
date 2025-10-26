public class Race {
    public Car raceWinner(Car[] cars) {
        Car winner = cars[0];
        int maxDistance = cars[0].mileage();
        for (int i = 1; i < cars.length; i++) {
            int currentDistance = cars[i].mileage();
            if (currentDistance > maxDistance) {
                maxDistance = currentDistance;
                winner = cars[i];
            }
        }
        return winner;
    }
}

