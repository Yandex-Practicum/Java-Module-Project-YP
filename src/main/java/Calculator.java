import java.util.List;

public class Calculator {
    List<Product> listOfProducts;
    int numOfPeople;

    Calculator(List<Product> listOfProducts, int numOfPeople) {
        this.listOfProducts = listOfProducts;
        this.numOfPeople = numOfPeople;
    }

    void printListOfProducts() {
        double sumOfProducts = 0.0;
        System.out.println("Добавленные товары:");
        for (int i = 0; i < listOfProducts.size(); i++) {
            System.out.println(listOfProducts.get(i).name + " стоимостью " + listOfProducts.get(i).price);
        }
        System.out.println("Каждый человек должен заплатить:");
        for (int i = 0; i < listOfProducts.size(); i++) {
            sumOfProducts += listOfProducts.get(i).price;
        }
        double priceToPay = sumOfProducts / numOfPeople;

        if ((int) priceToPay % 10 == 1 && !((int) priceToPay % 100 == 11)) {
            System.out.println(priceToPay + " рубль");
        } else if ((int) priceToPay % 10 == 2 && (int) priceToPay % 100 != 12
                || (int) priceToPay % 10 == 3 && (int) priceToPay % 100 != 13
                || (int) priceToPay % 10 == 4 && (int) priceToPay % 100 != 14) {
            System.out.println(priceToPay + " рубля");
        } else if ((int) priceToPay % 100 == 11 || (int) priceToPay % 100 == 12 || (int) priceToPay % 100 == 13 || (int) priceToPay % 100 == 14) {
            System.out.println(priceToPay + " рублей");
        } else {
            System.out.println(priceToPay + " рублей");
        }

    }

}
