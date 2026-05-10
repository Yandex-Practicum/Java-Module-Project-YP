import java.util.Scanner;

public class Car {
    String name;
    int speed;

    // Чуть меняем конструктор
    Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public static Car[] ProcessData() {
        Car[] cars = new Car[3];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < cars.length; i++) {
            String carName = "";
            int carSpeed = 0;

            boolean nameIsValid = false;
            boolean speedIsValid = false;

            while (!nameIsValid) {
                System.out.println("Введите название авто #" + (i + 1) + ":");

                carName = sc.nextLine(); // использую nextLine, вместо next, потому что так мы учитываем пустую строку (не помню, чтобы этому вообще учили).
                if (carName.trim().isEmpty()) {
                    System.out.println("Ошибка при вводе имени. Попробуйте снова: ");
                } else {
                    nameIsValid = true;
                }
            }

            // Переписать
            while (!speedIsValid) {
                System.out.println("Введите скорость авто #" + (i + 1));

                if (sc.hasNextInt()) {
                    carSpeed = sc.nextInt();
                    sc.nextLine();
                    if (carSpeed > 0 && carSpeed <= 250) {
                        speedIsValid = true;
                    } else {
                        System.out.println("Введите число в диапазоне от 1 до 250.");
                    }
                }

//                // если забуду: https://metanit.com/java/tutorial/2.10.php
//                try {
//                    carSpeed = sc.nextInt();
//                    if (carSpeed > 0 && carSpeed <= 250) {
//                        speedIsValid = true;
//                        sc.next();
//
//                    } else {
//                        System.out.println("Введите число в диапазоне от 1 до 250.");
//                    }
//                } catch (Exception e) { // Считываю вообще любые исключения
//                    System.out.println("Ошибка ввода. Некорректный формат данных. Попробуйте снова.");
//                    sc.next(); // Очищаем буфер. Подробнее разобрать как работает буфер
//                }
            }

            cars[i] = new Car(carName, carSpeed);
        }

        // Закрываю сканнер именно здесь, так как не планирую его реюзать в других частях программы.
        sc.close();

        return cars;
    }
}

// https://javarush.com/groups/posts/1385-potoki-vvodavihvoda-i-stroki-v-java
// Про System.in и System.out