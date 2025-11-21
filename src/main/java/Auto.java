public class Auto {
    public String name;
    public int speed;

    public Auto(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int distance() {
        return 24 * speed;
    }
}
