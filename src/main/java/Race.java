public class Race {
    String winner(Car[] cars) {
        String winner = "Победителей нет";
        int maxDistance = 0;
        for(Car car: cars) {
            if ((car.speed * 24) > maxDistance) {
                maxDistance = car.speed * 24;
                winner = car.name;
            }
        }
        return "Победителем гонки является: " + winner;
    }
}
