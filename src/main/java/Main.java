
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car1 = new Car(null, 0); // создаем значения из класса Car
        Car car2 = new Car(null, 0);
        Car car3 = new Car(null, 0);
        Race race24 = new Race(); // чтобы можно было делать ссылки на класс Race

// Машина номер 1
        System.out.println("Введите название машины номер 1");

        while (true) {
            String inputName = scanner.nextLine();
            if (inputName.trim().isEmpty()){
                System.out.println ("Поле не может быть пустым");
            } else {
                car1.name = inputName;
                break;
            }
            }


        System.out.println("Введите скорость машины номер 1");

        while (true){
            if (scanner.hasNextInt()){
                int tempSpeed = scanner.nextInt();
                String tail = scanner.nextLine(); // если скорость введена как 250 250, забирается " 250"
                if (tail.trim().isEmpty()) { // убираем пробелы из tail и проверяем: был ли tempSpeed введен одним числом или несколькими (если одним, то после числа ничего не осталось, если двумя и более, то минимум 1 число останется)
                    if (tempSpeed >= 0 && tempSpeed <= 250) {
                        car1.speed = tempSpeed;

                        break;
                    } else {

                        System.out.println("Некорректная скорость. Попробуйте снова. Скорость от 0 до 250");

                    }
                } else {
                    System.out.println("Некорректная скорость. Попробуйте снова. Должно быть только одно число");
                }
            } else {
                scanner.nextLine();
                System.out.println("Некорректная скорость. Попробуйте снова. Должно быть введено целое число");
            }
        }

        race24.calculateDistance(car1); //Считаем дистанцию и смотрим, лидер или нет


// Машина номер 2
        System.out.println("Введите название машины номер 2");
        while (true) {
            String inputName = scanner.nextLine();
            if (inputName.trim().isEmpty()){
                System.out.println ("Поле не может быть пустым");
            } else if (car1.name.equalsIgnoreCase((inputName))) {
                System.out.println("Такая машина уже учавствует в гонке.");
            } else {
                car2.name = inputName;
                break;
            }
        }


        System.out.println("Введите скорость машины номер 2");
        while (true){
            if (scanner.hasNextInt()){
                int tempSpeed = scanner.nextInt();
                String tail = scanner.nextLine(); // если скорость введена как 250 250, забирается " 250"
                if (tail.trim().isEmpty()) { // убираем пробелы из tail и проверяем: был ли tempSpeed введен одним числом или несколькими (если одним, то после числа ничего не осталось, если двумя и более, то минимум 1 число останется)
                    if (tempSpeed >= 0 && tempSpeed <= 250) {
                        car2.speed = tempSpeed;
                        break;
                    } else {

                        System.out.println("Некорректная скорость. Попробуйте снова. Скорость от 0 до 250");
                    }
                } else {
                    System.out.println("Некорректная скорость. Попробуйте снова. Должно быть только одно число");
                }
            } else {
                scanner.nextLine();
                System.out.println("Некорректная скорость. Попробуйте снова. Должно быть введено целое число");
            }
        }
        race24.calculateDistance(car2);//Считаем дистанцию и смотрим, лидер или нет

        // Машина номер 3
        System.out.println("Введите название машины номер 3");
        while (true) {
            String inputName = scanner.nextLine();
            if (inputName.trim().isEmpty()){
                System.out.println ("Поле не может быть пустым");
            } else if (car1.name.equalsIgnoreCase((inputName)) || car2.name.equalsIgnoreCase((inputName))) {
                System.out.println("Такая машина уже учавствует в гонке.");
            } else {
                car3.name = inputName;
                break;
            }
        }

        System.out.println("Введите скорость машины номер 3");
        while (true){
            if (scanner.hasNextInt()){
                int tempSpeed = scanner.nextInt();
                String tail = scanner.nextLine(); // если скорость введена как 250 250, забирается " 250"
                if (tail.trim().isEmpty()) { // убираем пробелы из tail и проверяем: был ли tempSpeed введен одним числом или несколькими (если одним, то после числа ничего не осталось, если двумя и более, то минимум 1 число останется)
                    if (tempSpeed >= 0 && tempSpeed <= 250) {
                        car3.speed = tempSpeed;
                        break;
                    } else {

                        System.out.println("Некорректная скорость. Попробуйте снова. Скорость от 0 до 250");

                    }
                } else {
                    System.out.println("Некорректная скорость. Попробуйте снова. Должно быть только одно число");
                }
            } else {
                scanner.nextLine();
                System.out.println("Некорректная скорость. Попробуйте снова. Должно быть введено целое число");
            }
        }
        race24.calculateDistance(car3);//Считаем дистанцию и смотрим, лидер или нет

        race24.printWinner(); // объявляем лидера
    }


}
