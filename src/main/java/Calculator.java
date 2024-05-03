import java.util.List;

public class Calculator {
     public double divider(List<Food> listOfFood, int numberOfPeople) {
          double total = 0;

          for ( Food food : listOfFood) {
               total += food.getPrice();
          }
          return total / numberOfPeople;
     }
}
