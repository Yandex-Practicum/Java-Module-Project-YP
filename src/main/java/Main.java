import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        for(int i = 0; i <= 2; i += 1){
            System.out.println("— Введите название машины №" + (i + 1) + ":");
            String name = scanner.next();

            while (true){
                System.out.println("— Введите скорость машины №" + (i + 1) + ":");
                try{
                    int speed = Integer.parseInt(scanner.next());
                    System.out.println();
                    if(speed > 0 && speed <= 250){
                        race.controlLead(new Car(name, speed));
                        break;
                    }
                    else{
                        System.out.println("— Неправильная скорость");
                    }
                }
                catch (NumberFormatException e){
                    System.out.println("— Неправильная скорость");
                }
            }
        }
        System.out.println("Самая быстрая машина:" + race.lead);
    }
}