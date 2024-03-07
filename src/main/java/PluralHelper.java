public class PluralHelper {
    private String one;
    private String couple;
    private String some;
    public PluralHelper(String one, String couple, String some) {
        this.one = one;
        this.couple = couple;
        this.some = some;
    }
    private String getStringFormattedPlurals(double count) {
        int val = Math.abs((int)count) % 100;
        int num = val % 10;
        if (val > 10 && val < 20) return some;
        if (num > 1 && num < 5) return couple;
        if (num == 1) return one;
        return some;
    }

    public String getFormattedPluralPattern(double count, String pattern) {
        return String.format(pattern, count, getStringFormattedPlurals(count));
    }

}
