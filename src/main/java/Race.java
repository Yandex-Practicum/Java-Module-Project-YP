public class Race {
    private String leaderName = "";
        private int maxDistance = 0;
        public void updateLeader(Car car) {
            int distance = car.speed * 24;
            if (distance > maxDistance) {
                maxDistance = distance;
                leaderName = car.name;
            }
        }
        public String getLeaderName() {
            return leaderName;
        }
    }

