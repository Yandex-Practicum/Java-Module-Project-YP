public class Car {
    String nameCar;
    int speedCar;

    public Car(String nameCar, int speedCar) {
        this.nameCar = nameCar;
        this.speedCar = speedCar;
    }

    public String getName() {
        return nameCar;
    }

    public double getSpeed() {
        return speedCar;
    }


    public int distanceIn24Hours() {
        return speedCar * 24;
    }
}
