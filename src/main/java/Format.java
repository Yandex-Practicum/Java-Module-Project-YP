public class Format {
    public  static String format(int persons, double totalCost){

        double payment = totalCost/persons;
        String formant1 = String.format("Каждому придётся заплатить по счетам сегодня, хоохохо: %.2f ", payment);
        while(true) {
            if (payment % 10 == 1 && payment % 10 != 11) {
                System.out.println(formant1 + "рубль");
                return null;
            } else if (payment % 10 >= 2 && payment % 10 < 5) {
                System.out.println(formant1 + "рубля");
                return null;
            } else {
                System.out.println(formant1 + "рублей");
                return null;
            }
        }

}
}
