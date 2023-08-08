package org.example;
import java.util.Scanner;
public class CalculateClass
{
    public static   float allPrice ;
    public static float pricePerPerson ;
    public  String rub="";
  //  public int people;
    void rubleEnding(float rubleInc)
    {
        int ruble = (int) Math.floor(rubleInc);
        if (ruble >= 5 && ruble <= 20)
        { rub="рублей";
            return;
        }
        if (ruble > 100){
            ruble %= 100;}
        if  (ruble > 20){
            ruble %= 10;}
        switch(ruble )
        {
            case 1-> rub = "рубль";
            case 2,3,4-> rub = "рубля";
            case 11,12,13,14-> rub = "рублей";
            default-> rub = "рублей";
        }
    }
    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На скольких человек необходимо разделить счёт ?");
        PeopleClass people = new PeopleClass();
        people.countPeople();
        StringBuilder allProduct = new StringBuilder();
        while(true)
        {
            System.out.println("Введите название товара ");
            Product.name = scanner.next();
            if (Product.name.equalsIgnoreCase("завершить"))
            {   pricePerPerson = allPrice / PeopleClass.people;
                rubleEnding(allPrice);
                System.out.println("Добавленные товары:");
                System.out.println(allProduct);
                String productList=String.format("Общий чек %.2f %s",allPrice,rub);
                System.out.println(productList);

                rubleEnding(pricePerPerson);

                String perPerson=String.format("Каждый должен заплатить- %.2f %s",pricePerPerson,rub);
                System.out.println(perPerson);
                break;
            }

            System.out.println("Введите стоимость товара ");
            allProduct.append(Product.name ).append( "\n");
            while (true)
            {
                while (!scanner.hasNextFloat())
                {
                    System.out.println("Извините, но это явно не число. Попробуйте снова ввести количество гостей цифрой!");
                    scanner.next();
                }
                Product.price = scanner.nextFloat();
                if (Product.price > 0)
                {
                    System.out.println(Product.name + "-" + Product.price + "\n" + "Товар успешно добавлен.\nХотите  добавить ещё один товар?Если нет-введите ЗАВЕРШИТЬ");
                    allPrice = allPrice + Product.price;
                    break;
                }
                if (Product.price <= 0)
                {
                System.out.println("Введена неверная сумма,повторите ввод\nВведите стоимость товара");
                Product.price = scanner.nextFloat();
                 }

        }}
} }


