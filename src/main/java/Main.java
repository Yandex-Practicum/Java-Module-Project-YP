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

//        Korzina korzina = new Korzina();
//        while (true) {
//            System.out.println("Вы хотите добавить товар ?");
//            printMenu();
//            int command = scanner.nextInt();
//            if ( command == 1 ) {
//                System.out.println("Введите название товара и его стоимость");
//                String product = scanner.nextLine();
//                String[] words = product.split(" ");
//                String name = words[0];
//                double price = Double.parseDouble(words[1]);
//
//            } else if ( command == 2 ) {
//                System.out.println("Завершение программы");
//            }
//        }
//
//
//        System.out.println("Введённое число " + peopleCount);
//    }
//    public static void printMenu() {
//        System.out.println("1 - Добавить товар");
//        System.out.println("2 - Завершить программу");
//
//    }
//    public static String addProduct(String productList, String product) {
//        if (!product.isEmpty()) {
//             productList + product + ".";
//        }
//        else {
//            return productList + product + ", ";
//        }
//
//    }

        double calculator = 0;
        double price = 0;
        String nameProduct = "";
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

//        System.out.println("Названия добавленных товаров " + nameProduct);
//        System.out.println("Товар успешно добавлен. Хотите ли Вы добавить ещё товар?");
//            if ( nameProduct.equalsIgnoreCase (product)) {
//                System.out.println("Итого");
//                break;
//            } esle
//
//        String product = Scanner.nextInt();
//
//        System.out.println("Введите стоимость продукта");
//        double sum = Scanner.nextDouble();
//        calculator = sum + calculator;
//        System.out.println("Сумма продуктов " + calculator);
//
//    }
//    public static void calculator() {
//        double sum = 0;
//        String product;
//        double price;
//        sum () {
//            while ( sum >= 0 ) {
//                System.out.println("Введите стоимость продукта");
//                double price = Scanner.nextDouble();
//                sum = sum + price;
//                System.out.println("Сумма продуктов " + sum);
//                break;
//            }
//        product () {
//                while ( product )
//            }
//        }
//        System.out.println("Введите стоимость продукта");
//        double sum = Scanner.nextDouble();
//        calculator = sum + calculator;
//        System.out.println("Сумма продуктов " + calculator);
//
//
//    }
//    public static void calculator() {
//        double sum = 0;
//        String products;
//        String product;
//        String finish = "Завершить";
//        double price = 0;
//
//        void name2() {
//            System.out.println("Введите название товара ");
//        while (true) {
//            product = scanner.nextLine();
//            if (product.equalsIgnoreCase(finish)) {
//                System.out.println("Ввод завершён");
//                break;
//            } else {
//                products = products + product;
//                System.out.println("Товар успешно добавлен. Хотите ли Вы добавить ещё товар?");
//                System.out.println("Названия добавленных товаров " + products);
//            }
//
//            System.out.print("Введите стоимость товара: ");
//            price = scanner.nextDouble();
//            if (price <= 0) {
//                System.out.println("Вы ввели неверные данные. Повторите ввод.");
//            } else if (price > 0) {
//                sum = sum + price;
//                System.out.println("Общая сумма товаров " + sum + " рублей");
//            }
//        }
//    }

        }
    }
}

