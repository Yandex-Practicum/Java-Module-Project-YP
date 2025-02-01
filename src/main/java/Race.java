import java.util.List;

public class Race {

    public void printWinner(List<Car> cars) {
        Car winner = new Car();
        for (Car car : cars) {
            if (winner.getSpeed() <= car.getSpeed()) {
                winner = car;
            }
        }

        System.out.println("\n*-------------------------------------------------------------------------*");
        System.out.println(" Победитель в нашей гонке - '" + winner.getName() + "'!");
        System.out.println("*-------------------------------------------------------------------------*");
    }
}
