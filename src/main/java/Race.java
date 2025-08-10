public class Race {
    String winner = "";
    int spaceValue;

    public void calculate(Car autos) {
        int space = autos.speed * 24;
        if (spaceValue < space) {
            winner = autos.name;
            spaceValue = space;
        }
    }

    public String getWinner() {

        return winner;
    }
}


