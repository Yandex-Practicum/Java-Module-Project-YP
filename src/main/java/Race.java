public class Race {
    static String leader;
    static int distance = 0;

    static String result(String carName, int carSpeed){
        int result = carSpeed * 24;
        if (result > distance) {
            distance = result;
            leader = carName;
        }
        return leader;
    }
}
