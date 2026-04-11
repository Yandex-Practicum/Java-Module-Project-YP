import java.util.Scanner;
public class Main {
private static class Car{
    private String name;
    private int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
    public String getName() {
        return name;}
    public int getSpeed() {
        return speed;
    }
}



private static class Race{


    public static String leader(Car[] nameMassive) {
        int d=0;
        String nameLeader=null;
        int distance=0;

        for (int i=0; i<3; i++){

            d = 24 * nameMassive[i].getSpeed();
            if (distance < d) {
                distance = d;
                nameLeader=nameMassive[i].getName();
            }

        }
        System.out.println("Самая быстрая машина: "+ nameLeader);
        return nameLeader;
    }

}


    public static void main(String[] args) {
        System.out.println("Hello world!");

        Car[] allCars = new Car[3];

        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<3; i++){
            System.out.println("Введите название автомобиля № "+(i+1)+" :");

            String carName = scanner.nextLine().trim();
            if(carName.isEmpty()) {
                System.out.println("Вы не вели название автомобиля");
                System.out.println("Введите корректное название автомобиля № "+(i+1)+" :");
                carName = scanner.nextLine().trim();

            }

            int carSpeed=-1;


            while ( (carSpeed<0) || (carSpeed>250)){
                System.out.println("Введите скорость автомобиля № " + (i + 1) + " :");

                //проверка что число целое - конец
                while (!scanner.hasNextInt()) {
                    System.out.println("Скорость должна быть целым числом. Повторите ввод: ");
                    scanner.next(); // очищаем некорректный ввод
                }
                // проверка что число целое - конец
                carSpeed=scanner.nextInt();


                if((carSpeed<0) || (carSpeed>250)) {
                    System.out.println("Неправильная скорость. Введите значение от 0 до 250! ");
                }
            }
            allCars[i] = new Car(carName, carSpeed);
            scanner.nextLine();
        }
        scanner.close();


        Race.leader(allCars );



    }
}