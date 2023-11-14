public class Calculation {

    String productList = "Добавленные товары:";
    int numberPersons;
    double totalPrice;

    Calculation(int numberPersons) {
        this.numberPersons = numberPersons;
    }

    public void addProduct(String product, double price) {
        productList = String.format("%s\n%s стоимость: %.2f %s", productList, product, price, getEnding(price));
        totalPrice = totalPrice + price;
    }

    public String divideCheck() {

        if (numberPersons == 0) {
            return "Ошибка: нет персон";
        }

        double result = totalPrice / numberPersons;

        return String.format("С одного человека: %.2f %s", result, getEnding(result));
    }

    public String getEnding(double number){

        int lastNumber = (int) Math.floor(number);

        if (lastNumber > 100) {
            lastNumber = lastNumber % 100;
        }

        if (lastNumber > 20) {
            lastNumber = lastNumber % 10;
        }

        String ending;

        switch (lastNumber) {
            case 1:
                ending = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                ending = "рубля";
                break;
            default:
                ending = "рублей";
                break;
        }

        return ending;

    }
}
