import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[3];
        String name = "";
        int speed = 0;

        for (int i = 0; i < 3; i++){
            System.out.println("Введите данные для автомобиля " + (i + 1) + ":");
            boolean validName = false;

            while (!validName) {

                System.out.println("Введите название автомобиля:");
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Вы ничего не ввели. Попробуйте еще раз");
                } else {
                    validName = true;
                }

            }

            boolean validSpeed = false;
            while (!validSpeed) {

                System.out.println("Введите скорость от 1 до 250 км/ч: ");
                String scanner1 = "";
                boolean validScanner = false;
                while (!validScanner){

                    scanner1 = scanner.nextLine().trim();
                    if (scanner1.isEmpty()){
                        System.out.println("Вы ничего не ввели. Попробуйте еще раз");
                        System.out.println("Введите скорость от 1 до 250 км/ч: ");
                    } else {
                        validScanner = true;
                    }
                }
                try {
                    speed = Integer.parseInt(scanner1);
                } catch (NumberFormatException e){
                    System.out.println("Ошибка: Введите целое число");
                    continue;
                }
                if (speed > 0 && speed < 250) {
                    validSpeed = true;
                    cars[i] = new Car(name, speed);
                }else {
                    System.out.println("Скорость должна быть от 1 до 250 км/ч. Попробуйте еще раз.");
                }
            }

        }
        Race race = new Race(cars);
        Car leader = race.getLeader();

        System.out.println("Победититель: " + leader.getName());

    }

}