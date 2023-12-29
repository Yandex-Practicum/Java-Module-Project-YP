public class Formatter {
    
    public String formate(int num) {
        int res = num;
        while (res > 20) {
            res = res % 10;
        }
        return res > 1 && res < 5 ? " рубля" : res == 1 ? " рубль" : " рублей";
    }
}
