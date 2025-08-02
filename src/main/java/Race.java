public class Race {
    // Класс Гонка
        private String leaderName;
        private int leaderDistance;

        public Race() {
            leaderName = "";
            leaderDistance = 0;
        }

        public void determineLeader(Car car) {
            int currentDistance = car.calculateDistance();
            if (currentDistance > leaderDistance) {
                leaderName = car.getName();
                leaderDistance = currentDistance;
            }
        }

        public String getLeaderName() {
            return leaderName;
        }

}
