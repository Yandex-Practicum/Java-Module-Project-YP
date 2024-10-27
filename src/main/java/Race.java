package org.example;

public class Race {
    private String leader = " "; // текущий лидер гонки
    private int distanseLeader = 0; // дистанция, которую проехал текущий лидер

    public void raceLeader(Car car) {
        int distanse = 24 * car.getSpeed();
        if (distanse > distanseLeader) {
            leader = car.getName();
            distanseLeader = distanse;
        }
    }

    public String getLeader() {
        return leader;
    }

}
