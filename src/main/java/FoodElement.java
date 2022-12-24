public class FoodElement {
    int counter;
    String foodName;
    String foodPrice;

    FoodElement(int counter, String foodName, String foodPrice) {
        this.counter = counter;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public String toString(){
        return "\n#"+counter+" — Название блюда: "+foodName+" — Цена в счёте: "+foodPrice;
    }
}
