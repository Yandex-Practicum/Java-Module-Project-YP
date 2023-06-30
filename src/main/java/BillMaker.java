import java.util.Scanner;

public class BillMaker {
    Scanner sc = new Scanner(System.in);

    void BillMakerMethod(int numberOfPeople) {

        StringBuilder products = new StringBuilder("Добавленные товары: \n");

        BillLoop:
        while (true) {

            //ОБЪЯВЛЕНИЕ ПЕРЕМЕННЫХ И НОВЫХ ОБЪЕКТОВ
            int MAX_PRODUCTS = 50;
            Product[] product = new Product[MAX_PRODUCTS];
            Calculator calculator = new Calculator();
            FormatRubles rub = new FormatRubles();
            int x = 0;


            //Условие x==50 - ниже
            while (x < MAX_PRODUCTS) {

                //ВВОД ДАННЫХ ТОВАРА (КЛАСС PRODUCT)
                product[x] = new Product();
                System.out.println("Введите название товара:");
                String name;
                name = product[x].insertName();
                System.out.println("Введите его стоимость (Рубли,копейки)");
                float price;
                price = product[x].insertPrice();
                //ЕСЛИ СТОИТ 0, начинаем добавлять товар сначала
                if (price == 0) {
                    continue;
                }

                //ВЫВОД ТОВАРОВ
                System.out.println("Вы успешно добавили: ");
                String namesOfProducts = "%s стоимостью %.2f %s";
                String formatProduct = String.format(namesOfProducts, name, price, rub.Rubles(price));
                System.out.println(formatProduct);

                //ВСЕ ТОВАРЫ ЦЕНА
                float sum = calculator.sum(price);
                products.append(formatProduct).append("\n");

                // ДОБАВИТЬ ТОВАР ЕЩЕ РАЗ
                System.out.println("Желаете продолжить добавление товаров? (Команда \"Завершить\"- для подсчета)");
                String againProduct = sc.next();
                String lowerCaseAgainProduct = againProduct.toLowerCase().trim();
                if (lowerCaseAgainProduct.equals("завершить")) {
                    //СЧЕТ
                    //ВЫВОД ВСЕХ ТОВАРОВ
                    System.out.println(products);
                    //НА КАЖДОГО
                    calculator.calculate(sum, numberOfPeople);
                    break BillLoop;
                } else {
                    x = x + 1;
                }

                if (x == MAX_PRODUCTS) {
                    System.out.println("Вы достигли максимума :с");
                    System.out.println("Вот Ваш счет на все введенные товары:");
                    break BillLoop;
                }
            }

        }

    }

}
