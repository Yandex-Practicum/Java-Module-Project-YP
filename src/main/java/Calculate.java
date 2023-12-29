public class Calculate {
    static double totalCost;

    public void sum(double item) {
        totalCost += item;
        System.out.println(totalCost);
    }

    public double getResult(int count) {
        return totalCost / count;
    }
}
