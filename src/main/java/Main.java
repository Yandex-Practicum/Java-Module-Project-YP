import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            String name;
            int speed;
            while (true) {
                System.out.println("— Введите название машины № " + i + ":");
                name = scanner.nextLine().trim();
                if(!name.isEmpty()){
                    break;
                }else{
                    System.out.println("— Название не может быть пустым!");
                }

            }


            while (true){
                System.out.println("— Введите скорость машины №" + i + ":");
                if (scanner.hasNextInt()){
                    speed = scanner.nextInt();
                    scanner.nextLine();

                    if(speed > 0 && speed <=250){
                        break;
                    }else{
                        System.out.println("— Неправильная скорость");
                    }
                }else {
                    System.out.println("— Неправильная скорость");
                    scanner.nextLine();
                }
            }
            autoCar currentCar = new autoCar(name, speed);

            race.checkLeader(currentCar);
        }
        scanner.close();

        System.out.println("Самая быстрая машина: " + race.getLeader().nameAuto);
    }
}