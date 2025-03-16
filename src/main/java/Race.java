public class Race {
        String leader = "";
        int distance = 0;

        public void findNewLeader(Auto auto) {
            int distanceNew = auto.speed * 24;
            if (distance < distanceNew) {
                distance = distanceNew;
                leader = auto.name;
            }
        }
    }
