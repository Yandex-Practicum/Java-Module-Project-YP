import java.util.Objects;

public class Car {
    private final String name;
    private final int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
