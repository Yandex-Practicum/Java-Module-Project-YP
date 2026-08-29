import java.util.ArrayList;

public class Race {

    public void resultRace (ArrayList<Car> cars){
        Car firstCar = cars.get(0);
        Car secondCar = cars.get(1);
        Car thirdCar = cars.get(2);

        if (firstCar.speed >= secondCar.speed && firstCar.speed >= thirdCar.speed){
            System.out.println("Победил участник на " + firstCar.carMake + ", он проехал " + firstCar.speed * 24 + " км");
        } else if ( secondCar.speed >= firstCar.speed && secondCar.speed >= thirdCar.speed){
            System.out.println("Победил участник на " + secondCar.carMake + ", он проехал " + secondCar.speed * 24 + " км");
        } else {
            System.out.println("Победил участник на " + thirdCar.carMake + ", он проехал " + thirdCar.speed * 24 + " км");
        }


    }

}
