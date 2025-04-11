public class Car {
    private String carName;
    private int carSpeed;

    public Car(String carName, int carSpeed) {
        this.carName = carName;
        this.carSpeed = carSpeed;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarSpeed() {
        return carSpeed;
    }


    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setCarSpeed(int carSpeed) {
        if (carSpeed <= 0) {
            System.out.println("Ошибка. Скорость автомобиля не может быть отрицательной или равна нулю");
        } else if (carSpeed >= 250) {
            System.out.println("Ошибка. Скорость автомобиля не может быть больше 250");
        } else this.carSpeed = carSpeed;
    }
}
