import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Auto> autoList = new ArrayList<>();
        Auto leader;
        for (int i=0; i<3; i++) {
            String name;
            while (true) {
                System.out.println("Введите название " + (i+1) + " автомобиля:");
                name = scanner.nextLine().trim();
                if (!name.isEmpty()) {
                    break;
                } else {
                    System.out.println("Некорректно указано название автомобиля");
                }
            }
            int speed;
            String speedInput;
            while (true) {
                System.out.println("Введите скорость " + (i + 1) + " автомобиля:");
                speedInput = scanner.nextLine().trim();
                boolean isInt = true;
                for (int j=0; j < speedInput.length(); j++) {
                    char c = speedInput.charAt(j);
                    if (c < '0' || c > '9') {
                        isInt = false;
                    }
                }
                if (speedInput.isEmpty() || !isInt) {
                    System.out.println("Некорректно указана скорость автомобиля");
                } else {
                    speed = Integer.parseInt(speedInput);
                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Некорректно указана скорость автомобиля");
                    }
                }
            }
            Auto auto = new Auto(name, speed);
            autoList.add(auto);
        }
        leader = Race.identifyLeader(autoList);
        System.out.println("Самая быстрая машина: " + leader.name);
        scanner.close();
    }

    public static class Auto {
        String name;
        int speed;

        Auto(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }
    }

    public static class Race {
        static Auto identifyLeader(ArrayList<Auto> autoList) {
            Auto leader = autoList.getFirst();
            int maxDistance = leader.speed * 24;
            for (Auto auto : autoList) {
                int currentDistance = auto.speed * 24;
                if (currentDistance>maxDistance) {
                    leader = auto;
                    maxDistance = currentDistance;
                }
            }
            return leader;
        }
    }
}