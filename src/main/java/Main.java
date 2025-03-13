import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        ArrayList<Car> carsList = new ArrayList<Car>();
        String carName;
        for (int i=1;i<4;i++) {
            while (true) {
                System.out.println("- Введите название автомобиля №"+i+": ");
                carName = scanner.nextLine().trim();
                if (carName.isEmpty()){
                    System.out.println("Название не может быть пустым");
                }
                else {
                    break;
                }
            }
            while (true) {
                System.out.println("- Введите скорость для "+carName+": ");

                if (scanner.hasNextInt()) {
                    int carSpeed = scanner.nextInt();
                    scanner.nextLine();
                    if (carSpeed > 0 && carSpeed <= 250) {
                        Car car= new Car(carName,carSpeed);
                        carsList.add(car);
                        break;
                    }
                    else {
                        System.out.println("Число вне допустимого диапазона.Число должно быть от 1 до 250");
                        continue;
                    }
                }
                else {
                    System.out.println("Это недопустимая форма записи для скорости.");
                    scanner.next();
                }
            }
        }
        System.out.println("Победитель гонки: "+ Race.findLeader(carsList));

    }
}
