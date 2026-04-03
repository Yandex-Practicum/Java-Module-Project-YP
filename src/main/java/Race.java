public class Race {
    String name = "";
    int distance = 0;

    public void calculateDistance(String name, int speed) {
        int distance = speed * 24;
        if (distance > this.distance) {
            this.name = name;
            this.distance = distance;
        }
    }

}
