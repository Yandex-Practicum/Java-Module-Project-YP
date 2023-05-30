import java.util.ArrayList;

public class Menu {
    ArrayList<String> nameDishMenuClient = new ArrayList<>();
    ArrayList<Double> priceDishMenuClient = new ArrayList<>();
    String menuClient2;
    SumPriceMenu sSum = new SumPriceMenu();
    ReadLine readLine = new ReadLine();


    Calculator calc = new Calculator();

    double[] saladPrice = {1280.0, 1350.0, 1550.0};
    String[] saladName = {"Салат с сочной телятиной и ароматными грибами",
            "Салат с морепродуктами и мятым авокадо",
            "Краб и авокадо"
    };

    double[] oneDishesPrice = {970.0, 860.0};
    String[] oneDishesName = {"Суп по-сычуаньски", "Крем-суп из кукурузы с морепродуктами"};

    double[] hotDishesPrice = {1220.0, 1300.0, 1300.0};
    String[] hotDishesName = {"Томленые говяжьи щечки с солодом",
            "Сочный бифштекс под трюфельным кремом",
            "Филе дорадо с соусом бер блан"
    };

    double[] dessertPrice = {1380.0, 1880.0};
    String[] dessertName = {"Домашняя паста с подкопченной семгой",
            "Королевские гребешки с кремом из цветной капусты"
    };

    public void menuClient() {

        while (true) {
            System.out.println("Что вы будете заказывать?");
            System.out.println("1. Салат\n2. Первые блюда\n3. Горячие блюда\n4. Десерт\n5. Свой вариант\n0. Завершить");
            String menuClient = Main.scanner.next();

            switch (menuClient) {
                case "1": {
                    System.out.println("У нас в меню представлено 3 вида салата, какой вы хотели бы заказать");

                    for (int i = 0; i < saladName.length; i++) {
                        System.out.printf("%s. %s = %s р.%n", (i + 1), saladName[i], saladPrice[i]);
                    }
                    System.out.println("0. Назад");

                    while (true) {
                        menuClient2 = Main.scanner.next();

                        if (menuClient2.equals("1")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(saladName[0], saladPrice[0]);
                            nameDishMenuClient.add(saladName[0]);
                            priceDishMenuClient.add(saladPrice[0]);
                            break;
                        } else if (menuClient2.equals("2")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(saladName[1], saladPrice[1]);
                            nameDishMenuClient.add(saladName[1]);
                            priceDishMenuClient.add(saladPrice[1]);
                            break;
                        } else if (menuClient2.equals("3")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(saladName[2], saladPrice[2]);
                            nameDishMenuClient.add(saladName[2]);
                            priceDishMenuClient.add(saladPrice[2]);
                            break;
                        } else if (menuClient2.equals("0")) {
                            break;
                        } else {
                            System.out.println("Вы что-то не так вводите, попробуйте еще раз");
                        }
                    }
                    break;
                }
                case "2": {
                    System.out.println("У нас в меню представлено 2 вида первых блюда, какой вы хотели бы заказать");

                    for (int i = 0; i < oneDishesName.length; i++) {
                        System.out.printf("%s. %s = %s р.%n", (i + 1), oneDishesName[i], oneDishesPrice[i]);
                    }
                    System.out.println("0. Назад");

                    while (true) {
                        menuClient2 = Main.scanner.next();

                        if (menuClient2.equals("1")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(oneDishesName[0], oneDishesPrice[0]);
                            nameDishMenuClient.add(oneDishesName[0]);
                            priceDishMenuClient.add(oneDishesPrice[0]);
                            break;
                        } else if (menuClient2.equals("2")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(oneDishesName[1], oneDishesPrice[1]);
                            nameDishMenuClient.add(oneDishesName[1]);
                            priceDishMenuClient.add(oneDishesPrice[1]);
                            break;
                        } else if (menuClient2.equals("0")) {
                            break;
                        } else {
                            System.out.println("Вы что-то не так вводите, попробуйте еще раз");
                        }
                    }
                    break;
                }
                case "3": {
                    System.out.println("У нас в меню представлено 3 вида горячих блюд, какой вы хотели бы заказать");

                    for (int i = 0; i < hotDishesName.length; i++) {
                        System.out.printf("%s. %s = %s р.%n", (i + 1), hotDishesName[i], hotDishesPrice[i]);
                    }
                    System.out.println("0. Назад");

                    while (true) {
                        menuClient2 = Main.scanner.next();

                        if (menuClient2.equals("1")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(hotDishesName[0], hotDishesPrice[0]);
                            nameDishMenuClient.add(hotDishesName[0]);
                            priceDishMenuClient.add(hotDishesPrice[0]);
                            break;
                        } else if (menuClient2.equals("2")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(hotDishesName[1], hotDishesPrice[1]);
                            nameDishMenuClient.add(hotDishesName[1]);
                            priceDishMenuClient.add(hotDishesPrice[1]);
                            break;
                        } else if (menuClient2.equals("3")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(hotDishesName[2], hotDishesPrice[2]);
                            nameDishMenuClient.add(hotDishesName[2]);
                            priceDishMenuClient.add(hotDishesPrice[2]);
                            break;
                        } else if (menuClient2.equals("0")) {
                            break;
                        } else {
                            System.out.println("Вы что-то не так вводите, попробуйте еще раз");
                        }
                    }
                    break;
                }
                case "4": {
                    System.out.println("У нас в меню представлено 2 вида десерта, какой вы хотели бы заказать");

                    for (int i = 0; i < dessertName.length; i++) {
                        System.out.printf("%s. %s = %s р.%n", (i + 1), dessertName[i], dessertPrice[i]);
                    }
                    System.out.println("0. Назад");

                    while (true) {
                        menuClient2 = Main.scanner.next();

                        if (menuClient2.equals("1")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(dessertName[0], dessertPrice[0]);
                            nameDishMenuClient.add(dessertName[0]);
                            priceDishMenuClient.add(dessertPrice[0]);
                            break;
                        } else if (menuClient2.equals("2")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(dessertName[1], dessertPrice[1]);
                            nameDishMenuClient.add(dessertName[1]);
                            priceDishMenuClient.add(dessertPrice[1]);
                            break;
                        } else if (menuClient2.equals("3")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(dessertName[2], dessertPrice[2]);
                            nameDishMenuClient.add(dessertName[2]);
                            priceDishMenuClient.add(dessertPrice[2]);
                            break;
                        } else if (menuClient2.equals("0")) {
                            break;
                        } else {
                            System.out.println("Вы что-то не так вводите, попробуйте еще раз");
                        }
                    }
                    break;
                }
                case "5": {
                    while (true) {
                        System.out.println("Введите название товара");
                        String myOption = Main.scanner.next();
                        nameDishMenuClient.add(myOption);
                        Double myNewScan = null;

                        do {
                            System.out.println("Введите цену товара больше 0");
                            try {
                                myNewScan = Main.scanner.nextDouble();
                            } catch (Exception e) {
                                System.out.println("Введите корректные данные");
                                Main.scanner.next();
                            }
                        } while (myNewScan == null || myNewScan < 0);

                        System.out.println("\nВы выбрали:");
                        calc.calculator(myOption, myNewScan);
                        priceDishMenuClient.add(myNewScan);
                        break;
                    }
                    break;
                }
                case "0": {
                    basket();
                    return;
                }
                case "Завершить": {
                    break;
                }
                default:
                    System.out.println("Еще раз");
            }
        }

    }

    public int quantityPeople;

    public void basket() {
        System.out.println("\nВаш список заказанных блюд:");
        double sumOnePeople = sumPriceMenu() / quantityPeople;

        for (int i = 0; i < priceDishMenuClient.size(); i++) {
            System.out.printf("%s. %s = %s\n", i + 1, nameDishMenuClient.get(i), priceDishMenuClient.get(i));
        }
        System.out.printf("\nОбщей суммой = %s", sumPriceMenu());
        System.out.printf("\nДля %s посетителей. Сумма на каждого = %.2f %s.", quantityPeople,
                sumOnePeople, "ру" + rub());
    }


    String rub() {
        int sumOnePeople = (int) sumPriceMenu() / quantityPeople;

        while (true) {
            int edge = sumOnePeople % 10;
            if (edge == 1) {
                return "бль";
            } else if (edge > 1 && edge < 5) {
                return "бля";
            } else {
                return "блей";
            }

        }
    }

    public double sumPriceMenu() {
        double sum = 0;

        for (int i = 0; i <= priceDishMenuClient.size() - 1; i++) {
            sum += priceDishMenuClient.get(i);
        }
        return sum;
    }

    public void oneLine() {
        while (!Main.scanner.hasNextInt()) {
            System.out.println("Введиде корректное число");
            Main.scanner.next();
        }
        quantityPeople = Main.scanner.nextInt();
        twoLine();
    }

    public void twoLine() {
        if (quantityPeople > 1) {
            System.out.println("Количество посетителей = " + quantityPeople + "\n");
            return;
        } else {
            System.out.println("Введите количество посетителей больше 1");
            oneLine();
        }
    }
}

