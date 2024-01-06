public class Calculator {
    String item = "";
    static double sum = 0;

    public double productsSum(Items items) {
        sum += items.costOfProduct();
        System.out.println("Общая сумма товаров: " + sum + " руб.");
        return sum;
    }

    public void addNewProducts(Items items) {
        String result = String.format(items.nameOfProduct() + "\n");
        item += result ;
        System.out.println("Добавленные товары:" + "\n" + item);
    }
    public double chequePerPerson() {
        return sum;

    }
}
