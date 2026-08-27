public class Race {

    public String leedName;

    public int leedDistance;

    public void addPlayer(String name, int speed)
    {
        int newDistance = countDistance(speed);
        if (leedDistance < newDistance)
        {
            leedName = name;
            leedDistance = newDistance;
        }

    }

    private int countDistance(int speed)
    {
        return 24*speed;
    }
}
