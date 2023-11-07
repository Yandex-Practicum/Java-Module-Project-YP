public class Calculator {

    double totalCost = 0.0;
    double perOne = 0.0;
    String list = "";

           void check(int guest) {

               perOne = totalCost / guest;
           }
           void urn(double basketCost) {
               totalCost =  totalCost + basketCost;

           }
           void addBasket(String basketList) {

               list += basketList + "\n";

               System.out.println(basketList + " успешно добавлен.");
           }

    }







