
class Rennen {
    String winner; // потенциальный победитель
    int wegWinner;  // расстояние

    Rennen() {
        this.winner = ""; // начальное значение
        this.wegWinner = 0;
    }

    void newWinner(Auto auto) { // метод поиска победителя
        int weg = 24 * auto.getSpeed(); // используем геттер, описанный в Auto


        if (weg > wegWinner) { // ищем максимальную дистанцию
            wegWinner = weg;
            winner = auto.getName();// тоже используем геттер.
        }
    }

    public String getWinnerName() { //  метод для получения имени победителя
        return winner;
    }
}
