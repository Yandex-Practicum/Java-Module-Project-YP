public class Result {
    Calculator menuMany = new Calculator();
    Friends kolVoPeople = new Friends();
    double Finish(){
        double zrachKa,peOple,reShala,celoe;
        int proverKa, ostatok;
        peOple = kolVoPeople.friends();
        zrachKa = menuMany.Calculator();
        System.out.print("\n");
        reShala = zrachKa / peOple;
        proverKa = (int)Math.floor(reShala);
        ostatok = proverKa%10;

        celoe = ((proverKa - ostatok)/10)%10;


       if (celoe == 1) {
            System.out.printf("С каждого человека пo: %.2f рублей\n", reShala);
        } else {
            if (ostatok == 1  ){
                System.out.printf("С каждого человека пo: %.2f рубль\n", reShala);
            }
            else if (ostatok > 1 && ostatok < 5 ){
                System.out.printf("С каждого человека пo: %.2f рубля\n", reShala);
            }else {
                System.out.printf("С каждого человека пo: %.2f рублей\n", reShala);
            }


        }



        return reShala;




    }



}


/*    double i = 4;

    int f = (int) Math.floor(i);
    int result = f%10;

        if(result == 1){
                System.out.println("Рубль");
                } else if (result > 1 && result < 5){
        System.out.println("Рубля");
        }

 */