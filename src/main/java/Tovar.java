public class Tovar
{
    public static String tovar;
    public String nazvanieTovara;
    public float cena;
    public void Tovar(String nazvanieTovara, float cena)
    {
        this.nazvanieTovara=nazvanieTovara;
        this.cena=cena;
        tovar = (nazvanieTovara+cena);
    }
}
