import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String avto1;
        String avto2;
        String avto3;
        int speed1 = 0;
        int speed2 = 0;
        int speed3 = 0;
        System.out.println("Введите название машины №1: ");
        avto1 = scanner.nextLine();

        System.out.println("Введите скорость машины №1: ");
        speed1 = scanner.nextInt();
        while (speed1 < 0 || speed1 > 250) {
            System.out.println("Неправильная скорость, введите другое значение для машины номер 1");
            speed1 = scanner.nextInt();
        }
        scanner.nextLine();

        System.out.println("Введите название машины №2: ");
        avto2 = scanner.nextLine();

        System.out.println("Введите скорость машины №2: ");
        speed2 = scanner.nextInt();
        while (speed2 < 0 || speed2 > 250) {
            System.out.println("Неправильная скорость, введите другое значение для машины номер 2");
            speed2 = scanner.nextInt();
        }
        scanner.nextLine();

        System.out.println("Введите название машины №3: ");
        avto3 = scanner.nextLine();

        System.out.println("Введите скорость машины №3: ");
        speed3 = scanner.nextInt();
        while (speed3 < 0 || speed3 > 250) {
            System.out.println("Неправильная скорость, введите другое значение для машины номер 3");
            speed3 = scanner.nextInt();
        }

        if (speed1 > speed2 && speed1 > speed3) {
            System.out.println("Самая быстрая машина: " + avto1);
        }
        if (speed2 > speed1 && speed2 > speed3) {
            System.out.println("Самая быстрая машина: " + avto2);
        }
        if (speed3 > speed1 && speed3 > speed2) {
            System.out.println("Самая быстрая машина: " + avto3);
        }
        scanner.close();

    }
}