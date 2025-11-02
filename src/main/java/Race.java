/**
 * Класс гонки - определяет победителя
 */
public class Race {
    private Car[] cars;
    private Car leader;

    public Race(Car[] cars) {
        this.cars = cars;
        calculateLeader();
    }

    /**
     * Вычисляем лидера по пройденному расстоянию за 24 часа
     */
    private void calculateLeader() {
        if (cars == null || cars.length == 0) {
            return;
        }

        leader = cars[0];
        double maxDistance = leader.calculateDistance();

        for (int i = 1; i < cars.length; i++) {
            double currentDistance = cars[i].calculateDistance();
            if (currentDistance > maxDistance) {
                maxDistance = currentDistance;
                leader = cars[i];
            }
        }
    }

    public Car getLeader() {
        return leader;
    }
}
