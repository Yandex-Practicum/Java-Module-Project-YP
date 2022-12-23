import java.util.Scanner;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {

        System.out.println("На скольких человек необходимо разделить счёт?");
        Scanner count = new Scanner(System.in);
        String scountOfFriends = count.next();
        int countOfFriends = isGoodCount(scountOfFriends);

        float sum = 0%.2f;
        StringJoiner listProducts = new StringJoiner("\n");

        while (true) {
            Product newProduct = Product.addNewProduct();
            productAdded(newProduct);
            sum += newProduct.priсe;
            listProducts.add(newProduct.name);
            String benchNow = String.format("Полная стоимость покупок: %.2f\nДобавленные товары:\n%s",sum,listProducts);
            System.out.println(benchNow + "\nДобавить еще товар?");
            Scanner stop = new Scanner(System.in);
            String stopIt = stop.next();
            if (stopIt.equalsIgnoreCase("Завершить")) break;
        }
        String result = String.format("Вы потратили %.2f %s\nСписок покупок:\n%s\nВам нужно скинуться по %.2f %s",sum,endOfSum(sum),listProducts, sum / (float) countOfFriends, endOfSum((int) (sum / (float) countOfFriends)));
        System.out.println(result);

    }

    public static void productAdded(Product newProduct){
        String outStr = String.format("Добавлен Товар %s, цена: %.2f",newProduct.name,newProduct.priсe);
        System.out.println(outStr);
    }

    public static int isGoodCount(String scount) {
        while (true) {
            if (checkForChar(scount)) {
                if (Integer.parseInt(scount) >= 1) {
                    if (Integer.parseInt(scount) == 1) {
                        System.out.println("Вам одному оплачивать весь счет");
                        System.exit(0);
                    } else System.out.println("Сейчас мы все посчитаем:");
                    break;
                } else scount = isCorrectNum();
            } else scount = isCorrectNum();
        }
        return Integer.parseInt(scount);
    }


    public static boolean checkForChar(String parametr) {
        return parametr.matches("\\d+");

    }


    public static String isCorrectNum() {
        Scanner testCount = new Scanner(System.in);
        System.out.println("Введите корректное число");
        return testCount.next();
    }

    public static String endOfSum(float fsum) {
        int sum = (int)fsum;
    if (sum%10==1) return "рубль";
    else
    if ((sum%10==0)||(sum%100)/10==1||(sum%10>4&&sum%10<10)) return "рублей";
    else
        return "рубля";

    }


}