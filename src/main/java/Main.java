import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RushLeMann rushLeMann = new RushLeMann("", 0);
        Scanner scanner = new Scanner(System.in);
        String staff = "Введите заново: ";

        System.out.println("Введите названия первого автомобиля: ");
        String name1 = scanner.next();
        while ((name1 == null) || (name1.isEmpty())) {
            System.out.println(staff);
            name1 = scanner.next();
        }
        System.out.println("Введите скорость первого автомобиля: ");
        int speed1;
        while (true) {
            if (scanner.hasNextInt()) {
                speed1 = scanner.nextInt();
                if (speed1 <= 0 || speed1 > 250) {
                    System.out.println(staff);
                } else {
                    break;
                }
            } else {
                System.out.println(staff);
                scanner.next();
            }
        }

        Auto auto1 = new Auto(name1, speed1);
        rushLeMann.rushLeader(auto1);

        System.out.println("Введите названия второго автомобиля: ");
        String name2 = scanner.next();
        while ((name2 == null) || (name2.isEmpty())) {
            System.out.println(staff);
            name2 = scanner.next();
        }
        System.out.println("Введите скорость второго автомобиля: ");
        int speed2;
        while (true) {
            if (scanner.hasNextInt()) {
                speed2 = scanner.nextInt();
                if (speed2 <= 0 || speed2 > 250) {
                    System.out.println(staff);
                } else {
                    break;
                }
            } else {
                System.out.println(staff);
                scanner.next();
            }
        }
        Auto auto2 = new Auto(name2, speed2);
        rushLeMann.rushLeader(auto2);

        System.out.println("Введите названия третьего автомобиля: ");
        String name3 = scanner.next();
        while ((name3 == null) || (name3.isEmpty())) {
            System.out.println(staff);
            name3 = scanner.next();
        }
        System.out.println("Введите скорость третьего автомобиля: ");
        int speed3;
        while (true) {
            if (scanner.hasNextInt()) {
                speed3 = scanner.nextInt();
                if (speed3 <= 0 || speed3 > 250) {
                    System.out.println(staff);
                } else {
                    break;
                }
            } else {
                System.out.println(staff);
                scanner.next();
            }
        }

        Auto auto3 = new Auto(name3, speed3);
        rushLeMann.rushLeader(auto3);

        System.out.println("Победитель: " + rushLeMann.leader);
    }
}

class RushLeMann {
    int currentDistance;
    String leader;
    int distance;
    RushLeMann(String leader, int currentDistance){
        this.leader = leader;
        this.currentDistance = currentDistance;
    }

    public int calculationCurrentDistance(Auto auto){
        return distance = 24 * auto.speedAuto;
    }
    public String rushLeader(Auto auto) {
        if (currentDistance < calculationCurrentDistance(auto)){
            currentDistance = calculationCurrentDistance(auto);
            leader = auto.nameAuto;
        }
        else {
            return leader;
        }
        return leader;
    }
}

class Auto {
    String nameAuto;
    int speedAuto;

    Auto(String nameAuto, int speedAuto) {
        this.nameAuto = nameAuto;
        this.speedAuto = speedAuto;
    }
}