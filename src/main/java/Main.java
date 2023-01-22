public class Main {
    public static void main(String[] args) {
        Persons persons = new Persons();
        float totalSale;
        int numberOfPersons;
        numberOfPersons = persons.numberOfPersons();
        Calculator calculator = new Calculator();
        totalSale = calculator.productNameAndSale();
        System.out.println("Общая стоимость товаров составляет: " + totalSale + " рубл. " + ((totalSale * 100 - (int)totalSale * 100)) + " коп.");
        Rub rubles = new Rub();
        rubles.endingOfTheRub(numberOfPersons,totalSale);

    }
}
