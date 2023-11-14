
public class Main {
    public static void main(String[] args) {
        CountPeople countPeople = new CountPeople();
        countPeople.countPeople();

        CountProduct count = new CountProduct();
        count.input();

        CountCostForEveryPerson exitMoney = new CountCostForEveryPerson();

        System.out.println(count.allProduct);
        exitMoney.countCostForEveryPerson(count.allCost, countPeople.allPeople);
    }
}