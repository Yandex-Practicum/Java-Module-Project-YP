public class Race {
    public void startRace(Car carOne, Car carTwo, Car carThree) {
        System.out.println("Да начнется гонка!");

        int distanceOneCar = 24 * carOne.speed;
        int distanceTwoCar = 24 * carTwo.speed;
        int distanceThreeCar = 24 * carThree.speed;

        Car lider;

        if (distanceOneCar >= distanceTwoCar && distanceOneCar >= distanceThreeCar) {
            lider = carOne;
        } else if (distanceTwoCar >= distanceThreeCar) {
            lider = carTwo;
        } else {
            lider = carThree;
        }

        System.out.println("Победитель: " + lider.name + " (проехал " + (24 * lider.speed) + " км)");
    }
}
