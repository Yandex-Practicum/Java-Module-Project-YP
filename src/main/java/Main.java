import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        HashMap<String, Integer> autoMap = new HashMap<>();
        for (int i=0; i<3;i++){
            System.out.println("Введите название: ");
            String name = scanner.next();
            System.out.println("Введите скорость: ");
            int speed = scanner.nextInt();
            if(Races.speedLimit(speed)){
                autoMap.put(name,speed);
            }else {
                System.out.println("Неправильная скорzость");
                i--;
            }
        }
        List<Integer> l = autoMap.values().stream().sorted().toList();
        System.out.println(l.get(l.size()-1));
    }
}

