import java.util.Objects;

public final class Car {
    private final String name;
    private final double speed;

    public Car(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    public String name() {
        return name;
    }

    public double speed() {
        return speed;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Car) obj;
        return Objects.equals(this.name, that.name) &&
                Double.doubleToLongBits(this.speed) == Double.doubleToLongBits(that.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, speed);
    }

    @Override
    public String toString() {
        return "Car[" +
                "name=" + name + ", " +
                "speed=" + speed + ']';
    }

}
