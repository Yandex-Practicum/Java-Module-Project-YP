import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cars> carList= new ArrayList<>();
        int countCars=1;
        String carName="";
        int carSpeed=0;

        for (int i = 0; i < 3; i++) {
            System.out.printf("Введите название машины №%d:%n",countCars);
            carName=scanner.next();

            while (true){
                System.out.printf("Введите скорость машины №%d:%n",countCars);
                if (scanner.hasNextInt()){
                    carSpeed=scanner.nextInt();
                    if (carSpeed>0 && carSpeed<=250){
                        Cars car = new Cars(carName,carSpeed);
                        carList.add(car);
                        countCars++;
                        break;
                    }else {
                        System.out.println("Неправильная скорость ");
                    }
                }else {
                    System.out.println("Нужно ввести целое число!");
                    scanner.next();
                }

            }
        }

        Racing race = new Racing();
        race.calculateLeader(carList);


    }
}
