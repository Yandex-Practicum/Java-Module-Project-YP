public class Calculator {

    String allProduct = "";

    float totalPrice;

    float costPerPeople;


    void addNameToCart(String nextProduct) {
        allProduct = allProduct + "\n" + nextProduct;
    }

    void costing(float nextPrice) {
        totalPrice = totalPrice + nextPrice;
    }

    void calculatePerPeople(int peopleAmount) {
        costPerPeople = totalPrice / peopleAmount;
    }

    void finalOutput() {
        String endString;
        if (costPerPeople < 2) endString = "бль";
        else if (costPerPeople > 2 && costPerPeople < 5) endString = "бля";
        else endString = "блей";
//        System.out.println("Добавленные товары:" + allProduct + "\nКаждый человек должен заплатить " +
//                +costPerPeople + " ру" + endString + ".");
        String finalOutputTemplate = "Добавленные товары:%s\nКаждый человек должен заплатить %.2f ру%s.";
        String finalOutput = String.format(finalOutputTemplate,allProduct,costPerPeople,endString);
        System.out.println(finalOutput);
        }

}
