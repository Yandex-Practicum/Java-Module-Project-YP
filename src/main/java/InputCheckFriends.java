public class InputCheckFriends {
    int IntValue;
     String input;
     boolean correct;
        InputCheckFriends (String InputFriends) {
            input = InputFriends;
            correct = isNumeric(InputFriends);
            if (correct) {
                IntValue = Integer.parseInt(input);
            }
        }
        public static boolean isNumeric(String s) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                return false;
            }
            return true;
        }



}

