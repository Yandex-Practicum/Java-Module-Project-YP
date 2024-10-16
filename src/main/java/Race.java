import java.util.List;

public class Race {
    private List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public Car fWin() {
        double mDistant = 0;
        Car win = null;

        for (Car car : cars) {
            double distan = calcDistanc(car);
            if (distan > mDistant){
            mDistant = distan;
            win = car;
        }
    }

        return win;
}

    private double calcDistanc(Car car) {
        return  car.gSpeed() * 24;
}
    public void printLeadInfo() {
        Car win = fWin();
        System.out.printf("Самая быстрая машина: %s, прошла %,.2f км за 24 часа.\n", win.gName(), calcDistanc(win));
    }
}
