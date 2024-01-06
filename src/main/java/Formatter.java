public class Formatter {

    public String formatAmount(double amountPerPerson) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%.2f", amountPerPerson));
        sb.append(" руб");
        int num = (int) Math.floor(amountPerPerson) % 10;
        if (num == 1) {
            sb.append("ль");
        } else if (num > 1 && num < 5) {
            sb.append("ля");
        } else {
            sb.append("лей");
        }
        return sb.toString();
    }
}
