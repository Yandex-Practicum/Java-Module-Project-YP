public class PeopleCout {
    private int count = 0;

    public int getCount() {
        return count;
    }
    public boolean setCount(int count) {
        if (count < 2) {
            return false;
        } else {
            this.count = count;
            return true;
        }
    }
}
