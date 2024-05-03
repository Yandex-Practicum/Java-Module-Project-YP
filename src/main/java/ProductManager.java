import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ProductManager {
    private List<Food> listOfFood;

    public ProductManager() {
        listOfFood = new ArrayList<>();
    }
    public List<Food> getListOfFood() {
        return listOfFood;
    }

    public void addFood(Food food) {
        listOfFood.add(food);
    }
    public void printFoods() {
        System.out.println("Добавленные товары:");
        for (Food food : listOfFood) {
            System.out.println(food.toString());
        }
    }
}
