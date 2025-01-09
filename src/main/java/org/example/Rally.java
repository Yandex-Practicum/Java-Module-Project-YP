package org.example;

public class Rally {
    static String winner(long firstSpeed, long secondSpeed, long thirdSpeed, String firstMachine, String secondMachine, String thirdMachine) {
        long firstDistance = 24 * firstSpeed;
        long secondDistance = 24 * secondSpeed;
        long thirdDistance = 24 * thirdSpeed;
        String winner = "";
        if (firstDistance > secondDistance && firstDistance > thirdDistance) {
            winner = firstMachine;
        } else if (secondDistance > firstDistance && secondDistance > thirdDistance) {
            winner = secondMachine;
        } else if (thirdDistance > secondDistance && thirdDistance > firstDistance) {
            winner = thirdMachine;
        }
        return("Самая быстрая машина: " + winner);
    }
}