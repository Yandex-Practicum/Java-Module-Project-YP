package org.example;

import java.util.Scanner;

public  class PeopleClass
 {
    public static int people;
    Scanner scanner = new Scanner(System.in);

    // public int people;
    void countPeople()
    {
        while (true)
        {
            while (!scanner.hasNextInt()) {
                System.out.println("Извините, но это явно не число. Попробуйте снова ввести количество гостей цифрой!");
                scanner.next();
            }
                PeopleClass.people = scanner.nextInt();
            if (PeopleClass.people > 1)
            {
                System.out.println("Спасибо!Количество гостей "+people);
                break;
            }
            else
            {
                System.out.println("Введите  колличество гостей (более одного,цифрой)");
            }
        }



    }
 }


