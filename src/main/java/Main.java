import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// создаем сканер
        Race race = new Race();//запускаем метод сравнения пройденного пути и определения лидера гонки

        for(int i=1; i<=3; i++){ // создаем цикл ввода данных на три автомобиля
            System.out.println("Введите название машины №" + i + ":");
            String name = scanner.next();// вводим марку авто

            int speed;
            while (true){ // вводим скорость авто
                System.out.println("Введите скорость машины №" + i + ":");
                if(scanner.hasNextInt()){ // создаем условие на проверку корректного ввода цифр
                    speed = scanner.nextInt();
                    if (speed > 0 && speed <= 250) {// проверяем допустимый диапазон
                        break;
                    } else{
                        System.out.println("Неправильная скорость, введите скорость от 0 до 250");
                    }
                } else{
                    System.out.println("Введите значение скорости арабскими цифрами!");
                    scanner.next();
                }
            }

            Car car = new Car(name, speed); // запускаем конструктор авто
            race.distanceCar(car);// определяем лидера
        }
        scanner.close();
        System.out.println("Самая быстрая машина:" + race.leader);// выводим марку поббедителя гонки

    }
}




