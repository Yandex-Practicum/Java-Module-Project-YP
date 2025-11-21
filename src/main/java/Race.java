public class Race {
    public Auto auto1;
    public Auto auto2;
    public Auto auto3;

    public void setCars(Auto auto1, Auto auto2, Auto auto3) {
        this.auto1 = auto1;
        this.auto2 = auto2;
        this.auto3 = auto3;
    }

    public Auto findWinner() {
        Auto winner = auto1;
        if (auto2.distance() > winner.distance()) {
            winner = auto2;
        }
        if (auto3.distance() > winner.distance()) {
            winner = auto3;
        }
        return winner;
    }

}
