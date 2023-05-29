public class Menu {
    String menuClient2;

    String[] basket = {};
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
            System.out.println("1. Салат\n2. Первые блюда\n3. Горячие блюда\n4. Десерт\n0. Завершить");
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
                            calc.nameDishMenuClient.add(saladName[0]);
                            calc.priceDishMenuClient.add(saladPrice[0]);
                            break;
                        } else if (menuClient2.equals("2")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(saladName[1], saladPrice[1]);
                            calc.nameDishMenuClient.add(saladName[1]);
                            calc.priceDishMenuClient.add(saladPrice[1]);
                            break;
                        } else if (menuClient2.equals("3")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(saladName[2], saladPrice[2]);
                            calc.nameDishMenuClient.add(saladName[2]);
                            calc.priceDishMenuClient.add(saladPrice[2]);
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
                            calc.nameDishMenuClient.add(oneDishesName[0]);
                            calc.priceDishMenuClient.add(oneDishesPrice[0]);
                            break;
                        } else if (menuClient2.equals("2")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(oneDishesName[1], oneDishesPrice[1]);
                            calc.nameDishMenuClient.add(oneDishesName[1]);
                            calc.priceDishMenuClient.add(oneDishesPrice[1]);
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
                            calc.nameDishMenuClient.add(hotDishesName[0]);
                            calc.priceDishMenuClient.add(hotDishesPrice[0]);
                            break;
                        } else if (menuClient2.equals("2")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(hotDishesName[1], hotDishesPrice[1]);
                            calc.nameDishMenuClient.add(hotDishesName[1]);
                            calc.priceDishMenuClient.add(hotDishesPrice[1]);
                            break;
                        } else if (menuClient2.equals("3")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(hotDishesName[2], hotDishesPrice[2]);
                            calc.nameDishMenuClient.add(hotDishesName[2]);
                            calc.priceDishMenuClient.add(hotDishesPrice[2]);
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
                            calc.nameDishMenuClient.add(dessertName[0]);
                            calc.priceDishMenuClient.add(dessertPrice[0]);
                            break;
                        } else if (menuClient2.equals("2")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(dessertName[1], dessertPrice[1]);
                            calc.nameDishMenuClient.add(dessertName[1]);
                            calc.priceDishMenuClient.add(dessertPrice[1]);
                            break;
                        } else if (menuClient2.equals("3")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(dessertName[2], dessertPrice[2]);
                            calc.nameDishMenuClient.add(dessertName[2]);
                            calc.priceDishMenuClient.add(dessertPrice[2]);
                            break;
                        } else if (menuClient2.equals("0")) {
                            break;
                        } else {
                            System.out.println("Вы что-то не так вводите, попробуйте еще раз");
                        }
                    }
                    break;
                }
                case "0": {
                    calc.basket();

                    return;
                }
                case "Завершить": {
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
                            calc.nameDishMenuClient.add(dessertName[0]);
                            calc.priceDishMenuClient.add(dessertPrice[0]);
                            break;
                        } else if (menuClient2.equals("2")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(dessertName[1], dessertPrice[1]);
                            calc.nameDishMenuClient.add(dessertName[1]);
                            calc.priceDishMenuClient.add(dessertPrice[1]);
                            break;
                        } else if (menuClient2.equals("3")) {
                            System.out.println("\nВы выбрали:");
                            calc.calculator(dessertName[2], dessertPrice[2]);
                            calc.nameDishMenuClient.add(dessertName[2]);
                            calc.priceDishMenuClient.add(dessertPrice[2]);
                            break;
                        } else if (menuClient2.equals("0")) {
                            break;
                        } else {
                            System.out.println("Вы что-то не так вводите, попробуйте еще раз");
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Еще раз");
            }
        }

    }
}

