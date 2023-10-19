
// Класс для хранения данных строки счета
public class LineOfBill {
    private String name;
    private float prise;

    public LineOfBill (String name, float prise) {
        this.name = name;
        this.prise = prise;
    }

    public String getName() { return name; }

    public float getPrise() { return prise; }
}
