import java.util.ArrayList;

public class Race {
    int timeRace = 24;
    ArrayList<Car> listOfCar;

    // стандартная гонка - 24 часа
    public Race(ArrayList<Car> listOfCar) {
        this.listOfCar = listOfCar;
    }

    // не стандартная гонка(задаём время)
    public Race(ArrayList<Car> listOfCar, int timeRace) {
        this.listOfCar = listOfCar;
        this.timeRace = timeRace;
    }

    public int getTimeRace() {
        return timeRace;
    }

    public void setTimeRace(int timeRace) {
        if (timeRace <= 0) {
            System.out.println("Ошибка. Время гонки не может быть меньше или равно 0");
        } else this.timeRace = timeRace;
    }

    public void resultRace() {
        String carChamp = null;
        int distance = 0;
        int distance2 = 0; // нужно для проверки нет ли  больше одного победителя

        for (Car car : listOfCar) {
            if (car.getCarSpeed() * timeRace > distance) {
                distance = car.getCarSpeed() * timeRace;
                carChamp = car.getCarName();
            } else if (car.getCarSpeed() * timeRace == distance) {
                String carChamp2 = car.getCarName();
                distance2 = car.getCarSpeed() * timeRace;
            }
        }

        if (distance == distance2) {
            System.out.println("Победителей нет, несколько машин пришли одновременно");
        } else {
            System.out.printf("Самая быстрая машина: %s, прошла %d километров", carChamp, distance);
        }
    }
}
