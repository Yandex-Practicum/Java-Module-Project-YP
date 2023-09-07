import java.util.Scanner;
public class Calculator {
    boolean check;
    String allProduct = "";
    float totalPrice;
    float costPerPeople;

    void allNames(String nextProduct) {
        allProduct = allProduct + "\n" + nextProduct;
    }

    void fullPrice(float nextCost) {
        totalPrice = totalPrice + nextCost;
    }

    void calcPerPeople(int people) {
        costPerPeople = totalPrice / people;
    }

    void finalOut() {
        Calculator calculator = new Calculator();
        String end;
        if (costPerPeople < 2) end = "бль";
        else if (costPerPeople > 2 && costPerPeople < 5) end = "бля";
        else end = "блей";
        String finalOut = "Добавленные товары:%s\nКаждый человек должен заплатить %.2f ру%s.";
        String finalOutput = String.format(finalOut, allProduct, costPerPeople, end);
        System.out.println(finalOutput);
    }


    void calc() {
        Product prod = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.println("На скольких человек необходимо разделить счёт?");

        int people = 0;
        while (true) {
            people = scanner.nextInt();
            if (people > 1) {
                break;
            } else {
                System.out.println("Введите корректное количество гостей");
            }
        }



        while (true) {
            System.out.println("Введите название товара или завершить");
            prod.name = scanner.next();
            if (prod.name.equalsIgnoreCase("завершить")) {
                break;
            } else {
                while (true) {
                    System.out.println("Введите стоимость (Стоимость должна быть в формате рубли.копейки, например 10.45 или 11.40):");
                        prod.cost = scanner.nextFloat();
                    if (prod.cost > 0) {
                        System.out.println("Товар " + prod.name + " стоимостью " + prod.cost + " успешно добавлен. \nХотите добавить ещё один товар?");
                        allNames(prod.name);
                        fullPrice(prod.cost);
                        break;
                    }
                }
            }
        }
        calcPerPeople(people);
        finalOut();
    }
}



