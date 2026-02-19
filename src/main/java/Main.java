import java.util.Scanner;
 public  class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Rennen rennen = new Rennen(); // создаем обьект гонки


        System.out.println("Поздравляем!Вы почетный участник гонки года.");

        for (int i = 1; i <= 3; i++) { // нам нужно только три авто
            System.out.print("Введите название автомобиля " + i);
            String name = scanner.nextLine(); // считываем строку и только символы

            // Проверка на пустое название
            while (name.isEmpty()) {
                System.out.print("Ай-яяй.Пустой ввод.Введите название автомобиля с помощью букв.");
                name = scanner.nextLine(); // считываем строку
            }

            int speed = checkSpeed(scanner, i); // наш метод
            Auto auto = new Auto(name, speed); // передаем имя и скорость
            rennen.newWinner(auto); // передаем в гонку название авто
        }


        System.out.println("Лидер гонки: " + rennen.getWinnerName()); // используем метод для имени,потому что имя победителя находится не здесь

        scanner.close(); // очистка данных
    }

     static int checkSpeed(Scanner scanner, int autoNumber) { // метод на корректность ввода скорости
        while (true) {
            System.out.print("Введите скорость машины " + autoNumber +" целым числом в диапазоне 0-250 км/ч");

            if (scanner.hasNextInt()) { //  проверяем, целое число и предотвращаем исключение
                int speed = scanner.nextInt();
                scanner.nextLine(); // считываем строку и только числа!

                if (speed > 0 && speed <= 250) {
                    return speed;
                } else {
                    System.out.println("Некорректное значение скорости,дружище!Скорость должна быть в диапазоне 0-250 !");
                }
            } else {
                System.out.println("Неверный ввод,какая грусть.Введите целое число.");
                scanner.nextLine();
            }
        }
    }
}