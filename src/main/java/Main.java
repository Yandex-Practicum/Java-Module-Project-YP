import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        int peopleCount = 0;
        while (peopleCount <= 1) {
            System.out.println("Введите количество гостей");
            peopleCount = scanner.nextInt();
            if (peopleCount <= 1) {
                System.out.println("Пожалуйста введите корректное значение");
            }
        }

        double calculator = 0;
        double price = 0;
        String nameProduct = " ";
        String product = "";
        String finish = "Завершить";
        while (true) {
            System.out.println("Введите название товара");
            product = scanner.next();
            nameProduct += product + "; \n";
            System.out.println("Введите стоимость продукта");
            price = scanner.nextDouble();
            calculator = calculator + price;
            System.out.println("Товар успешно добавлен.\nХотите ли Вы добавить ещё товар?\nЕсли нет, то нажмите \"Завершить\".");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Завершить")) {
                break;
            }

            double everyCheck = calculator / peopleCount;
            String.format("%.2f", everyCheck);
            String rub = "";
            int sumCheck = (int) ((Math.floor(everyCheck))%10);
            switch (sumCheck) {
                case 1:
                    rub = "Рубль";
                    break;
                case 2:
                    rub = "Рубля";
                    break;
                case 3:
                    rub = "Рубля";
                    break;
                case 4:
                    rub = "Рубля";
                    break;
                case 5:
                    rub = "Рублей";
                    break;
                case 9:
                    rub = "Рублей";
                    break;
                case 12:
                    rub = "Рублей";
                    break;
                case 18:
                    rub = "Рублей";
                    break;
                default:
                    rub = "Рублей";
                    break;
            }
            System.out.println("Каждому нужно заплатить " + String.format("%.2f", everyCheck) + " " + rub + ".");

        }
    }
}

