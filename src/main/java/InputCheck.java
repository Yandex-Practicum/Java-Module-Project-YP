public class InputCheck {
    Float FloatValue;
    String input;
    boolean correct;

     InputCheck(String InputPrice) {
        input = InputPrice;
        correct = isNumeric(InputPrice);
        if (correct) {
            FloatValue = Float.parseFloat(input);
        }
     }
    public static boolean isNumeric(String s)
    {
        try {
            Float.parseFloat(s);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }


}
