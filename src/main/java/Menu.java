public class Menu {

    String[] basket = {};
    Calculator calc = new Calculator();

    double [] saladPrice = {1280.0, 1350.0, 1550.0};
    String [] saladName = {"Салат с сочной телятиной и ароматными грибами",
            "Салат с морепродуктами и мятым авокадо",
            "Краб и авокадо"
    };

    double [] oneDishesPrice = {970.0, 860.0};
    String [] oneDishesName = {"Суп по-сычуаньски", "Крем-суп из кукурузы с морепродуктами"};

    double [] hotDishesPrice = {1220.0, 1300.0, 1300.0};
    String [] hotDishesName = {"Томленые говяжьи щечки с солодом",
            "Сочный бифштекс под трюфельным кремом",
            "Филе дорадо с соусом бер блан"
    };

    double [] dessertPrice = {1380.0, 1880.0};
    String [] dessertName = {"Домашняя паста с подкопченной семгой",
            "Королевские гребешки с кремом из цветной капусты"
    };

    public void menuClient() {

        while (true) {
            System.out.println("Что вы будете заказывать?");
            System.out.println("1. Салат\n2. Первые блюда\n3. Горячие блюда\n4. Десерт");
            String menuClient = Main.scanner.next();

            while (true) {
                switch (menuClient) {
                    case "1": {
                        System.out.println("У нас в меню представлено 3 вида салата, какой вы хотели бы заказать");

                        for (int i = 0; i < saladName.length; i++) {
                            System.out.printf("%s. %s = %s р.%n", (i + 1), saladName[i], saladPrice[i]);
                        }
                        System.out.println("0. Назад");

                        while (true) {
                            String menuClient2 = Main.scanner.next();

                            if (menuClient2.equals("1")) {
                                calc.calculator(saladName[0], saladPrice[0]);
                                System.out.println("Gooooooooooood");
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
                        System.out.println("2222");
                        break;
                    }
                    case "3": {
                        System.out.println("3333");
                        break;
                    }
                    case "4": {
                        System.out.println("4444");
                        break;
                    }
                    default:
                        System.out.println("Еще раз");
                }
            }
        }

    }
}

