public class Race {
    //Новый пулл
    private Car leader;

    // Метод для определения лидера гонки
    public void determineLeader(Car[] cars) {
        double maxDistance = 0;

        for (Car car : cars) {
            double distance = car.getSpeed() * 24; // Расчет расстояния за 24 часа
            if (distance > maxDistance) {
                maxDistance = distance;
                leader = car;
            }
        }
    }

    // Геттер для получения лидера гонки
    public Car getLeader() {
        return leader;
    }
}
