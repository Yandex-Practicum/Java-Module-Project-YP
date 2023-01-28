import java.util.Scanner;

public class Calculator {
    String nameOfProduct, totalListOfItems ="Добавленные товары:", trailingSlashes;
    float priceOfProduct, totalPriceOfProducts;
    int priceOfItem;
    Scanner scanner = new Scanner(System.in);

    public float productNameAndSale(){

        System.out.println("Введите названия и стоимости товаров (стоимости должны быть в формате рубли,копейки). После ввода команды \"завершить\", ввод товаров прекратится.\n");

        while(true){
            System.out.println("Введите название товара:");
            nameOfProduct = scanner.nextLine();
            if (nameOfProduct.equalsIgnoreCase("завершить")){
                break;
            }
            totalListOfItems += ("\n" + nameOfProduct);
            System.out.println("Введите стоимость товара:");
            while(true) {
                if(scanner.hasNextFloat()) {
                    priceOfProduct = scanner.nextFloat();
                    scanner.nextLine();
                    if(priceOfProduct>=0){
                        totalPriceOfProducts += priceOfProduct;
                        priceOfItem = (int) priceOfProduct;
                        trailingSlashes = "";
                        for(int i = nameOfProduct.length(); i<= 30; i++)
                        {
                            trailingSlashes +="_" ;
                        }
                        totalListOfItems += (" " + trailingSlashes + " " + priceOfItem + " рубл. " + (int) ((priceOfProduct * 100 - priceOfItem * 100)) + " коп.");
                        System.out.println("Товар успешно добавлен! Продолжите ввод или введите команду \"Завершить\" для подстчета итога:");
                        break;
                    }else{
                        System.out.println("Стоимость товара должно быть больше или равно 0. Попробуйте снова!");
                    }

                }else{
                    if(scanner.nextLine().equalsIgnoreCase("завершить")){
                        System.out.println("\nДля завершения ввода добавьте цену последнего товара и введите \"Завершить\"!");
                    }
                    System.out.println("Стоимость блюда должнабыть числом в формате рубли,копейки. Попробуйте снова!");
                }
            }
        }
        System.out.println(totalListOfItems);
        return totalPriceOfProducts;
    }
}
