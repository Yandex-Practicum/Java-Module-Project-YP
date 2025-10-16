package auto;

public enum CarNumbers {
    NUMBER1(1),
    NUMBER2(2),
    NUMBER3(3);

    final int num;

    public int getNum() {
        return this.num;
    }

    CarNumbers(int num) {
        this.num = num;
    }
}
