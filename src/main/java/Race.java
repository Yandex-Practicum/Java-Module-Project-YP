public class Race {

    public static String race(Car[] carArray) {

        int[] distance = new int[3];
        String leader = "";

        for(int i = 0 ; i < 3; i++) {
            distance[i] = 24 * carArray[i].speedCar;
        }

        int max = -1;
        for (int i=0; i < carArray.length; i++) {
            if (carArray[i].speedCar > max) {
                max = carArray[i].speedCar;
                leader = carArray[i].nameCar;
            }
        }

        int count = 0;
        for (int i=0; i < carArray.length; i++) {
            if (carArray[i].speedCar == max) {
                count = count + 1;
            }
        }

        if (count > 1) {
            System.out.println("В этой гонке победителя нет, попробуйте запустить программу снова!");
        }
        else {
            System.out.println("Самая быстрая машина: " + leader);
        }

        return leader;
    }
}
