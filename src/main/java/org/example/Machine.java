package org.example;

import java.util.Scanner;


public class Machine {

    static String machineName() {                       //Метод для чтения данных о названии машин от пользователя
        Scanner scanner = new Scanner(System.in);       //Создаю сканнер
        //Принимаю значение, записываю в переменную типа строки
        return scanner.next();                                 //Возвращаю значение
    }

    static Integer speedRange() {                                  //Метод для рамок скорости
                    //Создаю сканнер
        while (true) {                                          //Пишу бесконечный цикл (для случая, когда люая введенная скорость не входит в рамки
            Scanner speed = new Scanner (System.in) ;
            if (speed.hasNextInt()) {
                int  speedInt = speed.nextInt();
                if (0 < speedInt && speedInt < 251) {                    //Пишу условие для составления рамок
                    return speedInt ;                                   //Возвращаю значение
            }   else  {
                    System.out.println("Неправильная скорость");    //Вывожу сообщение о неправильном вводе, если скорость не входит в рамки
            }
        } else {
                System.out.println("Неправильная скорость");
            }
        }
    }

}
