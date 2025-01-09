package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите Название машины №1:");
        String firstMachine = Machine.machineName();
        System.out.println("Введите скорость машины №1:");
        long firstSpeed = Machine.speedRange();
        System.out.println("Введите Название машины №2:");
        String secondMachine = Machine.machineName();
        System.out.println("Введите скорость машины №2:");
        long secondSpeed = Machine.speedRange();
        System.out.println("Введите Название машины №3:");
        String thirdMachine = Machine.machineName();
        System.out.println("Введите скорость машины №3:");
        long thirdSpeed = Machine.speedRange();

        System.out.println(Rally.winner(firstSpeed, secondSpeed, thirdSpeed, firstMachine, secondMachine, thirdMachine));

    }
}

